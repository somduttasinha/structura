package com.somduttasinha.structura.graph.traversal;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.somduttasinha.structura.graph.Graph;
import com.somduttasinha.structura.graph.SparseGraph;
import com.somduttasinha.structura.graph.Vertex;


class BreadthFirstTraverserTest {

    private BreadthFirstTraverser<String> breadthFirstTraverser;

    @BeforeEach
    public void setUp() {
        breadthFirstTraverser = new BreadthFirstTraverser<>();
    }

    @Test
    public void testOne() {

        Graph<String> graph = new SparseGraph<>();

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");
        Vertex<String> f = new Vertex<>("F");
        Vertex<String> g = new Vertex<>("G");
        Vertex<String> h = new Vertex<>("H");

        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 1);

        graph.addEdge(c, a, 1);
        graph.addEdge(c, d, 1);
        graph.addEdge(c, h, 1);

        graph.addEdge(d, e, 1);

        graph.addEdge(e, f, 1);
        graph.addEdge(e, g, 1);


        breadthFirstTraverser = new BreadthFirstTraverser<>();

        List<Vertex<String>> vertices = breadthFirstTraverser.traverse(graph, Optional.of(e));

        System.out.println(vertices);


    }
}
