package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PreferencePageCommitBlock extends ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.PreferencePageCommitBlock";

  public PreferencePageCommitBlock(SNode node) {
    super(node);
  }

  public static PreferencePageCommitBlock newInstance(SModel sm, boolean init) {
    return (PreferencePageCommitBlock) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.PreferencePageCommitBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PreferencePageCommitBlock newInstance(SModel sm) {
    return PreferencePageCommitBlock.newInstance(sm, false);
  }
}
