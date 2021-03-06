package jetbrains.mps.graphLayout.graphLayout;

/*Generated by MPS */

import jetbrains.mps.graphLayout.graph.GraphCopier;
import jetbrains.mps.graphLayout.graph.GraphCopierFactory;
import jetbrains.mps.graphLayout.util.DefaultFilter;
import jetbrains.mps.graphLayout.graph.INode;
import jetbrains.mps.graphLayout.util.Filter;
import jetbrains.mps.graphLayout.graph.Node;
import jetbrains.mps.graphLayout.graph.IEdge;
import jetbrains.mps.graphLayout.graph.Edge;
import jetbrains.mps.graphLayout.intGeom2D.Dimension;
import jetbrains.mps.graphLayout.graph.Graph;
import java.util.Set;

public class LayoutInfoCopier {
  private ILayoutInfo myLayoutInfo;
  private LayoutInfo myInfoCopy;
  private GraphCopier myCopier;

  public LayoutInfoCopier(ILayoutInfo layoutInfo) {
    myCopier = GraphCopierFactory.getCopier(layoutInfo.getGraph());
    myLayoutInfo = layoutInfo;
    myInfoCopy = new LayoutInfo(myCopier.getCopy());
  }

  public LayoutInfo copy() {
    return copySubgraph(new DefaultFilter<INode>());
  }

  public LayoutInfo copySubgraph(Filter<INode> nodeFilter) {
    myCopier.copySubgraph(nodeFilter);
    for (INode node : myLayoutInfo.getNodesWithSize()) {
      if (nodeFilter.accept(node)) {
        Node copyNode = myCopier.getNodeCopy(node);
        myInfoCopy.setNodeSize(copyNode, myLayoutInfo.getNodeSize(node));
      }
    }
    for (IEdge edge : myLayoutInfo.getLabeledEdges()) {
      Edge copyEdge = myCopier.getEdgeCopy(edge);
      Dimension edgeSize = myLayoutInfo.getLabelSize(edge);
      if (copyEdge != null && edgeSize != null) {
        myInfoCopy.setLabelSize(copyEdge, edgeSize);
      }
    }
    return myInfoCopy;
  }

  public LayoutInfo getLayoutInfoCopy() {
    return myInfoCopy;
  }

  public Graph getGraphCopy() {
    return myInfoCopy.getGraph();
  }

  public Node getNodeCopy(INode node) {
    return myCopier.getNodeCopy(node);
  }

  public Edge getEdgeCopy(IEdge edge) {
    return myCopier.getEdgeCopy(edge);
  }

  public Set<INode> getCopiedNodes() {
    return myCopier.getCopiedNodes();
  }

  public Set<IEdge> getCopiedEdges() {
    return myCopier.getCopiedEdges();
  }

  public GraphCopier getGraphCopier() {
    return myCopier;
  }

  public GraphLayout restoreLayout(GraphLayout copyLayout) {
    return myCopier.restoreLayout(copyLayout);
  }
}
