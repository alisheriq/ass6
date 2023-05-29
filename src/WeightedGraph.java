import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph <V>{
    private Map<Vertex<V>, List<WeightedEdge<V>>> map;
    public WeightedGraph() {
        this.map = new HashMap<>();
    }
    public static class WeightedEdge<V> {
        private Vertex<V> source;
        private Vertex<V> destination;
        private double weight;


    }
}
