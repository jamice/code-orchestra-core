package jetbrains.mps.lang.textGen.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class SetUniqueNameInFile_Intention extends BaseIntention implements Intention {
  public SetUniqueNameInFile_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.textGen.structure.ReferenceAppendPart";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return true;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return (SPropertyOperations.getBoolean(node, "uniqNameInFile") ?
      "Unset" :
      "Set" + " Unique Name in File"
    );
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SPropertyOperations.set(node, "uniqNameInFile", "" + !(SPropertyOperations.getBoolean(node, "uniqNameInFile")));
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.textGen.intentions";
  }
}
