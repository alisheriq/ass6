import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<WeightedEdge<V>>> map;  // Stores the vertices and their corresponding weighted edges

    public WeightedGraph() {
        this.map = new HashMap<>();  // Initializes the map to store the vertices and edges
    }

    public void addVertex(Vertex<V> vertex) {
        map.put(vertex, new ArrayList<>());  // Adds a vertex to the graph with an empty list of edges
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        validateVertex(source);
        validateVertex(destination);

        List<WeightedEdge<V>> edges = map.get(source);  // Retrieves the list of edges for the source vertex
        edges.add(new WeightedEdge<>(source, destination, weight));  // Creates a new weighted edge and adds it to the list
    }

    private void validateVertex(Vertex<V> vertex) {
        if (!map.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is not part of the graph");
        }
    }

    public List<WeightedEdge<V>> getEdges() {
        List<WeightedEdge<V>> allEdges = new ArrayList<>();
        for (List<WeightedEdge<V>> edges : map.values()) {
            allEdges.addAll(edges);  // Collects all the weighted edges from each vertex and adds them to the list
        }
        return allEdges;
    }

    public List<WeightedEdge<V>> getEdges(Vertex<V> vertex) {
        validateVertex(vertex);
        return map.get(vertex);  // Retrieves the list of weighted edges for the specified vertex
    }

    public List<Vertex<V>> getVertices() {
        return new ArrayList<>(map.keySet());  // Returns a list of all vertices in the graph
    }

    public static class WeightedEdge<V> {
        private Vertex<V> source;  // The source vertex of the edge
        private Vertex<V> destination;  // The destination vertex of the edge
        private double weight;  // The weight of the edge

        public WeightedEdge(Vertex<V> source, Vertex<V> destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public Vertex<V> getSource() {
            return source;  // Returns the source vertex of the edge
        }

        public Vertex<V> getDestination() {
            return destination;  // Returns the destination vertex of the edge
        }

        public double getWeight() {
            return weight;  // Returns the weight of the edge
        }
    }
}
