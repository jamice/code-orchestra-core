package codeOrchestra.flex.processors.variableDeclaration;

import jetbrains.mps.smodel.SNode;
import org.apache.flex.compiler.internal.tree.as.BaseVariableNode;
import org.apache.flex.compiler.internal.tree.as.VariableNode;

/**
 * @author Anton.I.Neverov
 */
public class FieldDeclarationProcessor extends VariableDeclarationWithCommentProcessor {

  public FieldDeclarationProcessor(SNode node) {
    super(node);
  }

  @Override
  protected BaseVariableNode createVariableNode() {
    return new VariableNode(nameNode);
  }

}