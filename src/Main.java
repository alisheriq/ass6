import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create vertices
        Vertex<String> vA = new Vertex<>("A");
        Vertex<String> vB = new Vertex<>("B");
        Vertex<String> vC = new Vertex<>("C");
        Vertex<String> vD = new Vertex<>("D");
        Vertex<String> vE = new Vertex<>("E");

        // Create weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(vA);
        graph.addVertex(vB);
        graph.addVertex(vC);
        graph.addVertex(vD);
        graph.addVertex(vE);

        // Add edges
        graph.addEdge(vA, vB, 5.0);
        graph.addEdge(vA, vC, 2.0);
        graph.addEdge(vB, vD, 1.0);
        graph.addEdge(vC, vD, 3.0);
        graph.addEdge(vC, vE, 4.0);
        graph.addEdge(vD, vE, 6.0);

        // Perform breadth-first search
        Search<String> bfs = new BreadthFirstSearch<>(graph);
        List<String> bfsPath = bfs.findPath(vA, vE);
        System.out.println("Breadth-First Search Path: " + bfsPath);

        // Perform Dijkstra's algorithm
        Search<String> dijkstra = new DijkstraSearch<>(graph);
        List<String> dijkstraPath = dijkstra.findPath(vA, vE);
        System.out.println("Dijkstra's Algorithm Path: " + dijkstraPath);
    }
}