package com.somduttasinha.structura.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/** A Sparse Graph which uses an adjacency list representation of vertices and edges. */
public class SparseGraph<V> implements Graph<V> {

    // we use a list of edges to allow for multiple uni-directional edges between
    // vertices
    private Map<Vertex<V>, Set<Edge>> adjacencyList;

    private Set<Vertex<V>> vertices;

    /** SparseGraph constructor given the adjacency list. */
    public SparseGraph(Map<Vertex<V>, Set<SparseGraph<V>.Edge>> adjacencyList) {
        this.adjacencyList = adjacencyList;

        for (Entry<Vertex<V>, Set<Edge>> entry : this.adjacencyList.entrySet()) {
            vertices.add(entry.getKey());

            Set<Vertex<V>> adjacentVertices =
                    entry.getValue().stream().map(e -> e.to).collect(Collectors.toSet());

            vertices.addAll(adjacentVertices);
        }
    }

    public SparseGraph() {
        this.adjacencyList = new java.util.HashMap<>();
        this.vertices = new HashSet<>();
    }

    @Override
    public void addEdge(Vertex<V> from, Vertex<V> to, int weight) {

        this.vertices.add(from);
        this.vertices.add(to);

        Set<Edge> edges = this.adjacencyList.getOrDefault(from, new HashSet<>());

        edges.add(new Edge(from, to, weight));

        this.adjacencyList.put(from, edges);
    }

    @Override
    public boolean hasEdge(Vertex<V> from, Vertex<V> to) {
        Set<Vertex<V>> target =
                adjacencyList.getOrDefault(from, new HashSet<>()).stream()
                        .map(e -> e.to)
                        .filter(v -> v.equals(to))
                        .collect(Collectors.toSet());
        return target.contains(to);
    }

    @Override
    public Iterator<Vertex<V>> adjacentVertices(Vertex<V> vertex) {
        return this.adjacencyList.getOrDefault(vertex, new HashSet<>()).stream()
                .map(e -> e.to)
                .iterator();
    }

    @Override
    public int vertexCount() {
        return this.vertices.size();
    }

    @Override
    public int edgeCount() {
        return this.adjacencyList.values().stream()
                .map(edgeList -> edgeList.size())
                .reduce(0, (a, b) -> a + b);
    }

    @Override
    public Set<Vertex<V>> vertices() {
        return this.vertices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex<V> vertex : this.vertices) {
            sb.append(vertex.toString());
            sb.append(" -> ");
            sb.append(this.adjacencyList.get(vertex));
            sb.append("\n");
        }

        return sb.toString();
    }

    private class Edge {

        Vertex<V> from;
        Vertex<V> to;
        int weight;

        public Edge(Vertex<V> from, Vertex<V> to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
        }


    }
}
