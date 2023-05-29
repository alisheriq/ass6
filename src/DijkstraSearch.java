public class DijkstraSearch <V> implements Search<V>{
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }
}
