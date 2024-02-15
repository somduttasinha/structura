package com.somduttasinha.structura.graph.traversal;

import java.util.Set;

import com.somduttasinha.structura.graph.Graph;
import com.somduttasinha.structura.graph.Vertex;

public interface Traversable<V> {

    Set<Vertex<V>> traverse(Graph<V> graph);

}
