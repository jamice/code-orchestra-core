package jetbrains.mps.lang.textGen.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExtensionDeclaration extends ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.textGen.structure.ExtensionDeclaration";

  public ExtensionDeclaration(SNode node) {
    super(node);
  }

  public static ExtensionDeclaration newInstance(SModel sm, boolean init) {
    return (ExtensionDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.textGen.structure.ExtensionDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExtensionDeclaration newInstance(SModel sm) {
    return ExtensionDeclaration.newInstance(sm, false);
  }
}
