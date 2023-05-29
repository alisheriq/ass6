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
## Install
 Copy the code from Main.java file to your project.  
 **IMPORTANT:** You will need to remove the comments to run the code.

## Download
Compiled binary material can be found at [releases](https://github.com/alisheriq/ass6/tree/master/src).

## License
Majority of the source code is written by myself.
Any use of code without my permission is prohibited.
