package graphTest;

/*Generated by MPS */

import junit.framework.TestCase;
import jetbrains.mps.graphLayout.graph.Graph;
import visualization.GraphIO;
import java.util.Scanner;
import java.util.Map;
import jetbrains.mps.graphLayout.graph.Edge;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import junit.framework.Assert;
import jetbrains.mps.graphLayout.algorithms.MinCostCirculation;
import jetbrains.mps.graphLayout.graph.Node;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.SetSequence;

public class MinCirculation_Test extends TestCase {
  public void test_test1() throws Exception {
    String graphString = "4 4  0 1  1 2  2 3  3 0";
    Graph graph = GraphIO.scanGraph(new Scanner(graphString));
    Map<Edge, Integer> low = MapSequence.fromMap(new HashMap<Edge, Integer>());
    setEdgesMap(low, graph.getNode(0), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(low, graph.getNode(1), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(low, graph.getNode(2), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(low, graph.getNode(3), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    Map<Edge, Integer> capacity = MapSequence.fromMap(new HashMap<Edge, Integer>());
    setEdgesMap(capacity, graph.getNode(0), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(capacity, graph.getNode(1), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(capacity, graph.getNode(2), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(capacity, graph.getNode(3), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    Map<Edge, Integer> cost = MapSequence.fromMap(new HashMap<Edge, Integer>());
    setEdgesMap(cost, graph.getNode(0), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(cost, graph.getNode(1), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(cost, graph.getNode(2), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(cost, graph.getNode(3), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    Map<Edge, Integer> circulation = test(graph, low, capacity, cost);
    Assert.assertTrue(getFlowCost(circulation, cost) == 4);
    for (Edge edge : ListSequence.fromList(graph.getEdges())) {
      Assert.assertTrue(MapSequence.fromMap(circulation).get(edge) == 1);
    }
  }

  public void test_test2() throws Exception {
    String graphString = "4 4  0 1  1 2  2 3  3 0";
    Graph graph = GraphIO.scanGraph(new Scanner(graphString));
    Map<Edge, Integer> low = MapSequence.fromMap(new HashMap<Edge, Integer>());
    setEdgesMap(low, graph.getNode(0), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(low, graph.getNode(1), ListSequence.fromListAndArray(new ArrayList<Integer>(), 2));
    setEdgesMap(low, graph.getNode(2), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(low, graph.getNode(3), ListSequence.fromListAndArray(new ArrayList<Integer>(), 2));
    Map<Edge, Integer> capacity = MapSequence.fromMap(new HashMap<Edge, Integer>());
    setEdgesMap(capacity, graph.getNode(0), ListSequence.fromListAndArray(new ArrayList<Integer>(), 10));
    setEdgesMap(capacity, graph.getNode(1), ListSequence.fromListAndArray(new ArrayList<Integer>(), 10));
    setEdgesMap(capacity, graph.getNode(2), ListSequence.fromListAndArray(new ArrayList<Integer>(), 10));
    setEdgesMap(capacity, graph.getNode(3), ListSequence.fromListAndArray(new ArrayList<Integer>(), 10));
    Map<Edge, Integer> cost = MapSequence.fromMap(new HashMap<Edge, Integer>());
    setEdgesMap(cost, graph.getNode(0), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(cost, graph.getNode(1), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(cost, graph.getNode(2), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    setEdgesMap(cost, graph.getNode(3), ListSequence.fromListAndArray(new ArrayList<Integer>(), 1));
    Map<Edge, Integer> circulation = test(graph, low, capacity, cost);
    Assert.assertTrue(getFlowCost(circulation, cost) == 8);
    for (Edge edge : ListSequence.fromList(graph.getEdges())) {
      Assert.assertTrue(MapSequence.fromMap(circulation).get(edge) == 2);
    }
  }

  private Map<Edge, Integer> test(Graph graph, Map<Edge, Integer> low, Map<Edge, Integer> capacity, Map<Edge, Integer> cost) {
    int numNodes = graph.getNumNodes();
    int numEdges = ListSequence.fromList(graph.getEdges()).count();
    Map<Edge, Integer> circulation = MinCostCirculation.getCirculation(graph, low, capacity, cost);
    FlowChecker.checkCirculation(graph, low, capacity, circulation);
    Assert.assertTrue(numNodes == graph.getNumNodes());
    Assert.assertTrue(numEdges == ListSequence.fromList(graph.getEdges()).count());
    return circulation;
  }

  private void setEdgesMap(Map<Edge, Integer> edgesMap, Node source, List<Integer> values) {
    List<Edge> edges = source.getOutEdges();
    for (int i = 0; i < ListSequence.fromList(edges).count(); i++) {
      MapSequence.fromMap(edgesMap).put(ListSequence.fromList(edges).getElement(i), ListSequence.fromList(values).getElement(i));
    }
  }

  private int getFlowCost(Map<Edge, Integer> flow, Map<Edge, Integer> cost) {
    int flowCost = 0;
    for (Edge edge : SetSequence.fromSet(MapSequence.fromMap(flow).keySet())) {
      flowCost += MapSequence.fromMap(cost).get(edge) * MapSequence.fromMap(flow).get(edge);
    }
    return flowCost;
  }
}
