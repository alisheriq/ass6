import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<V> findPath(Vertex<V> source, Vertex<V> destination) {
        Queue<Vertex<V>> queue = new LinkedList<>();  // Queue to perform breadth-first search
        Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();  // Map to store the parent vertices for constructing the path

        queue.add(source);  // Start the search from the source vertex
        parentMap.put(source, null);  // Set the parent of the source vertex as null

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();  // Take the next vertex from the queue

            if (current.equals(destination)) {
                return constructPath(parentMap, destination);  // If the destination vertex is found, construct and return the path
            }

            for (WeightedGraph.WeightedEdge<V> edge : graph.getEdges(current)) {
                Vertex<V> neighbor = (Vertex<V>) edge.getDestination();  // Get the neighboring vertex

                if (!parentMap.containsKey(neighbor)) {
                    queue.add(neighbor);  // Add the neighbor to the queue for further exploration
                    parentMap.put(neighbor, current);  // Set the current vertex as the parent of the neighbor
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
