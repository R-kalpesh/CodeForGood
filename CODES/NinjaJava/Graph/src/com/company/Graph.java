package com.company;

// Java code to demonstrate Graph representation
// using ArrayList in Java
import java.util.*;

class Graph {

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(ArrayList<ArrayList<Integer>> adj) {

        for (int i = 0; i < adj.size(); i++) {

            System.out.println("\nAdjacency list of vertex" + i);

            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            
            System.out.println();
        }
    }
}
