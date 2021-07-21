import java.util.*;

public class Pathfinder {

    public List<Tile> FindPath(Tile from, Tile to) {

        Queue<RouteTile> openSet = new PriorityQueue<>();
        Map<Tile, RouteTile> allTiles = new HashMap<>();

        RouteTile start = new RouteTile(from, null, 0, ComputeCost(from, to));
        openSet.add(start);
        allTiles.put(from, start);

        while (!openSet.isEmpty()) {
            RouteTile next = openSet.poll();
            if (next.getCurrent().equals(to)) {
                List<Tile> route = new ArrayList<>();
                RouteTile current = next;
                 do {
                     route.add(0, current.getCurrent());
                     current = allTiles.get(current.getPrevious());
                 } while (current != null);

                 return route;
            }

            for (Tile i : next.getCurrent().GetNeighbors()) {
                RouteTile nextTile = allTiles.getOrDefault(i, new RouteTile(i));
                allTiles.put(i, nextTile);

                int newScore = next.getRouteScore() + 1;

                if(newScore < nextTile.getRouteScore()) {
                    nextTile.setPrevious(next.getCurrent());
                    nextTile.setRouteScore(newScore);
                    nextTile.setEstimatedScore(newScore + ComputeCost(i, to));
                    openSet.add(nextTile);
                }
            }
        }
        System.out.println("ERROR NO PATH AVAILABLE.");
        return null;
    }

    public int ComputeCost(Tile from, Tile to) {
        return Math.abs(to.x - from.x) + Math.abs(to.y - from.y);
    }
}