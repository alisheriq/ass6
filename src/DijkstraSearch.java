import java.util.*;
public class DijkstraSearch <V> implements Search<V>{
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
                vertex.setDistance(0.0);
            } else {
                vertex.setDistance(Double.POSITIVE_INFINITY);
            }
            distances.put(vertex, vertex.getDistance());
            queue.add(vertex);
        }

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            if (current.equals(destination)) {
                return constructPath(parentMap, destination);
            }

            for (WeightedGraph.WeightedEdge<V> edge : graph.getEdges(current)) {
                Vertex<V> neighbor = (Vertex<V>) edge.getDestination();
                double newDistance = current.getDistance() + edge.getWeight();

                if (newDistance < neighbor.getDistance()) {
                    queue.remove(neighbor);
                    neighbor.setDistance(newDistance);
                    distances.put(neighbor, newDistance);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return Collections.emptyList(); // No path found
    }
    private List<V> constructPath(Map<Vertex<V>, Vertex<V>> parentMap, Vertex<V> destination) {
        List<V> path = new LinkedList<>();
        Vertex<V> current = destination;

        while (current != null) {
            path.add(0, current.getData());
            current = parentMap.get(current);
        }

        return path;
    }
}
