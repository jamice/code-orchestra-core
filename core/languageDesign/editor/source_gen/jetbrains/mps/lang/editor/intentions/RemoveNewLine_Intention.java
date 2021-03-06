package jetbrains.mps.lang.editor.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.editor.behavior.EditorCellModel_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.editor.behavior.IStyleContainer_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class RemoveNewLine_Intention extends BaseIntention implements Intention {
  public RemoveNewLine_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.editor.structure.EditorCellModel";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Remove New Line";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return EditorCellModel_Behavior.call_isNewLine_1237383076236(node);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNodeOperations.deleteNode(ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.IndentLayoutNewLineStyleClassItem"))).first());
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.editor.intentions";
  }
}
