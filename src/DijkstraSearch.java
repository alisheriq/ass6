import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<V> findPath(Vertex<V> source, Vertex<V> destination) {
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(Vertex<V>::getDistance));
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();

        for (Vertex<V> vertex : graph.getVertices()) {
            if (vertex.equals(source)) {
                vertex.setDistance(0.0);  // Set the distance of the source vertex to 0
            } else {
                vertex.setDistance(Double.POSITIVE_INFINITY);  // Set the distance of other vertices to infinity
            }
            distances.put(vertex, vertex.getDistance());  // Store the distances in the map
            queue.add(vertex);  // Add the vertices to the priority queue
        }

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();  // Get the vertex with the smallest distance from the queue

            if (current.equals(destination)) {
                return constructPath(parentMap, destination);  // If the destination vertex is found, construct and return the path
            }

            for (WeightedGraph.WeightedEdge<V> edge : graph.getEdges(current)) {
                Vertex<V> neighbor = (Vertex<V>) edge.getDestination();  // Get the neighboring vertex
                double newDistance = current.getDistance() + edge.getWeight();  // Calculate the new distance

                if (newDistance < neighbor.getDistance()) {
                    queue.remove(neighbor);  // Remove the neighbor from the queue to update its distance
                    neighbor.setDistance(newDistance);  // Update the distance of the neighbor
                    distances.put(neighbor, newDistance);  // Update the distance in the map
                    parentMap.put(neighbor, current);  // Update the parent vertex in the parent map
                    queue.add(neighbor);  // Add the neighbor back to the queue with the updated distance
                }
            }
        }

        return Collections.emptyList();  // If no path is found, return an empty list
    }

    private List<V> constructPath(Map<Vertex<V>, Vertex<V>> parentMap, Vertex<V> destination) {
        List<V> path = new LinkedList<>();
        Vertex<V> current = destination;

        while (current != null) {
            path.add(0, current.getData());  // Add the data of each vertex to the path list in reverse order
            current = parentMap.get(current);  // Move to the parent vertex
        }

        return path;
    }
}
