package com.somduttasinha.structura.graph.traversal;

import com.somduttasinha.structura.graph.Graph;
import com.somduttasinha.structura.graph.Vertex;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Traverser<V> {

    /**
     * Traversal of a graph. If no startVertex is provided, the implementation may start at any
     * {@link Vertex}. As traversal ordering is important, we use a {@link java.util.List} instead
     * of a {@link Set}
     *
     * @param graph Graph to traverse
     * @param startVertex Vertex to start traversal from.
     */
    List<Vertex<V>> traverse(Graph<V> graph, Optional<Vertex<V>> startVertex);
}
