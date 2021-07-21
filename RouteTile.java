public class RouteTile implements Comparable<RouteTile> {

    private Tile current;
    private Tile previous;

    private int routeScore;
    private int estimatedScore;

    public RouteTile(Tile current) {
        this(current, null, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public RouteTile(Tile current, Tile previous, int routeScore, int estimatedScore) {
        this.current = current;
        this.previous = previous;
        this.routeScore = routeScore;
        this.estimatedScore = estimatedScore;
    }

    public Tile getCurrent() {
        return current;
    }

    public Tile getPrevious() {
        return previous;
    }

    public void setPrevious(Tile previous) {
        this.previous = previous;
    }

    public int getRouteScore() {
        return routeScore;
    }

    public void setRouteScore(int routeScore) {
        this.routeScore = routeScore;
    }

    public void setEstimatedScore(int estimatedScore) {
        this.estimatedScore = estimatedScore;
    }

    @Override
    public int compareTo(RouteTile o) {
        return Integer.compare(this.estimatedScore, o.estimatedScore);
    }
}