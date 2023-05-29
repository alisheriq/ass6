import java.util.HashMap;
import java.util.Map;

public class Vertex <V>{
    private V data;  // Stores the data associated with the vertex
    private Map<Vertex<V>, Double> adjacentVertices;  // Stores the adjacent vertices and their corresponding weights
    private double distance;  // Stores the distance of the vertex from a source vertex

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();  // Initializes the map to store adjacent vertices
        this.distance = Double.POSITIVE_INFINITY;  // Sets the initial distance to infinity
    }

    public V getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);  // Adds an adjacent vertex with its weight to the map
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;  // Returns the map of adjacent vertices
    }

    public void setDistance(double distance) {
        this.distance = distance;  // Sets the distance of the vertex from a source vertex
    }

    public double getDistance() {
        return distance;  // Returns the distance of the vertex from a source vertex
    }
}
