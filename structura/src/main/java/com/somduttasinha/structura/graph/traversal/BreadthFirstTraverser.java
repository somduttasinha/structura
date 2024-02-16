package com.somduttasinha.structura.graph.traversal;

import com.somduttasinha.structura.graph.Graph;
import com.somduttasinha.structura.graph.Vertex;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstTraverser<V> implements Traverser<V> {

    @Override
    public List<Vertex<V>> traverse(Graph<V> graph, Optional<Vertex<V>> startVertex) {

        Set<Vertex<V>> vertices = graph.vertices();

        Set<Vertex<V>> unvisitedVertices = new HashSet<Vertex<V>>(vertices);

        Queue<Vertex<V>> queue = new LinkedList<>();

        LinkedList<Vertex<V>> traversedVerticies = new LinkedList<>();

        Vertex<V> firstVertex;

        if (startVertex.isPresent()) {
            firstVertex = startVertex.get();
            if (!vertices.contains(firstVertex)) {
                throw new RuntimeException("Provided vertex does not exist in the graph.");
            }
        } else {
            firstVertex = unvisitedVertices.iterator().next();
        }

        queue.add(firstVertex);

        while (!unvisitedVertices.isEmpty()) {
            if (queue.isEmpty()) {
                queue.add(unvisitedVertices.iterator().next());
            }

            Vertex<V> vertex = queue.poll();

            traversedVerticies.add(vertex);

            unvisitedVertices.remove(vertex);

            Iterator<Vertex<V>> adjacentVertices = graph.adjacentVertices(vertex);

            while (adjacentVertices.hasNext()) {
                Vertex<V> next = adjacentVertices.next();
                if (unvisitedVertices.contains(next)) {
                    queue.add(next);
                }
            }
        }

        return traversedVerticies;
    }
}
