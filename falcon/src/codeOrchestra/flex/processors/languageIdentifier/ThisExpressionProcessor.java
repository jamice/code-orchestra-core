package codeOrchestra.flex.processors.languageIdentifier;

import codeOrchestra.flex.processors.SNodeProcessorException;
import jetbrains.mps.smodel.SNode;
import org.apache.flex.compiler.internal.tree.as.LanguageIdentifierNode;
import org.apache.flex.compiler.tree.as.IASNode;

/**
 * @author Anton.I.Neverov
 */
public class ThisExpressionProcessor extends LanguageIdentifierProcessor {

  public ThisExpressionProcessor(SNode node) {
    super(node);
  }

  @Override
  protected IASNode createNode() throws SNodeProcessorException {
    return LanguageIdentifierNode.buildThis();
  }

}
