# Graph Classes
# Assigment 6
# Course: Algorithms and Data Structures
---

## Tasks from
- [Assignment 6](https://moodle.astanait.edu.kz/mod/assign/view.php?id=82710&action=view)

## Build
IntelliJ IDEA
- I used v2022.3.1
## Explanation of the Assignment 5

This repository contains Java classes for working with weighted graphs and implementing search algorithms. 
The following classes are included:

<details>
<summary>Vertex class</summary>
 
The Vertex class represents a vertex in a graph. It stores the data associated with the vertex, maintains a map of adjacent vertices and their corresponding weights, and keeps track of the distance of the vertex from a source vertex.

Constructor:

Vertex(V data): Initializes a new vertex with the given data.

Methods:

V getData(): Returns the data associated with the vertex.

void addAdjacentVertex(Vertex<V> destination, double weight): Adds an adjacent vertex with its weight to the map of adjacent vertices.
 
Map<Vertex<V>, Double> getAdjacentVertices(): Returns the map of adjacent vertices and their corresponding weights.
 
void setDistance(double distance): Sets the distance of the vertex from a source vertex.
 
double getDistance(): Returns the distance of the vertex from a source vertex.
 
</details>

<details>
<summary>WeightedGraph class</summary>
 
The WeightedGraph class represents a weighted graph. It maintains a map of vertices and their corresponding weighted edges.

Constructor:
 
WeightedGraph(): Initializes a new weighted graph.
 
Methods:
 
void addVertex(Vertex<V> vertex): Adds a vertex to the graph with an empty list of edges.
 
void addEdge(Vertex<V> source, Vertex<V> destination, double weight): Adds a weighted edge between the source and destination vertices with the given weight.
 
List<WeightedEdge<V>> getEdges(): Returns a list of all the weighted edges in the graph.
 
List<WeightedEdge<V>> getEdges(Vertex<V> vertex): Returns a list of weighted edges adjacent to the specified vertex.
 
List<Vertex<V>> getVertices(): Returns a list of all vertices in the graph.
 
WeightedEdge:

The WeightedEdge class represents a weighted edge between two vertices in a graph. It stores the source vertex, destination vertex, and weight of the edge.

Constructor:
 
WeightedEdge(Vertex<V> source, Vertex<V> destination, double weight): Initializes a new weighted edge with the given source, destination, and weight.
 
Methods:
 
Vertex<V> getSource(): Returns the source vertex of the edge.
 
Vertex<V> getDestination(): Returns the destination vertex of the edge.
 
double getWeight(): Returns the weight of the edge.
 
</details>

<details>
<summary>BreadthFirstSearch class</summary>
 
The BreadthFirstSearch class implements the Search interface and performs breadth-first search on a weighted graph. It finds the shortest path between a source vertex and a destination vertex.

Constructor:
 
BreadthFirstSearch(WeightedGraph<V> graph): Initializes a new breadth-first search with the given weighted graph.
 
Methods:
 
List<V> findPath(Vertex<V> source, Vertex<V> destination): Finds the shortest path between the source and destination vertices using breadth-first search.
 
</details>
 
<details>
<summary>DijkstraSearch class</summary>
 
The DijkstraSearch class implements the Search interface and performs Dijkstra's algorithm on a weighted graph. It finds the shortest path between a source vertex and a destination vertex.

Constructor:
 
DijkstraSearch(WeightedGraph<V> graph): Initializes a new Dijkstra's algorithm with the given weighted graph.
 
Methods:
 
List<V> findPath(Vertex<V> source, Vertex<V> destination): Finds the shortest path between the source and destination vertices using Dijkstra's algorithm.
 
</details>
 
## Install
 Copy the code from Main.java file to your project.  
 **IMPORTANT:** You will need to remove the comments to run the code.

## Download
Compiled binary material can be found at [releases](https://github.com/alisheriq/ass6/tree/master/src).

## License
Majority of the source code is written by myself.
Any use of code without my permission is prohibited.
