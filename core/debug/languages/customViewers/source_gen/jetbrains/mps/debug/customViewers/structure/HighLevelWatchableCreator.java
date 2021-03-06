package jetbrains.mps.debug.customViewers.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.AbstractCreator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class HighLevelWatchableCreator extends AbstractCreator {
  public static final String concept = "jetbrains.mps.debug.customViewers.structure.HighLevelWatchableCreator";
  public static final String WATCHABLE = "watchable";
  public static final String VALUE = "value";

  public HighLevelWatchableCreator(SNode node) {
    super(node);
  }

  public CustomWatchable getWatchable() {
    return (CustomWatchable) this.getReferent(CustomWatchable.class, HighLevelWatchableCreator.WATCHABLE);
  }

  public void setWatchable(CustomWatchable node) {
    super.setReferent(HighLevelWatchableCreator.WATCHABLE, node);
  }

  public Expression getValue() {
    return (Expression) this.getChild(Expression.class, HighLevelWatchableCreator.VALUE);
  }

  public void setValue(Expression node) {
    super.setChild(HighLevelWatchableCreator.VALUE, node);
  }

  public static HighLevelWatchableCreator newInstance(SModel sm, boolean init) {
    return (HighLevelWatchableCreator) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.debug.customViewers.structure.HighLevelWatchableCreator", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static HighLevelWatchableCreator newInstance(SModel sm) {
    return HighLevelWatchableCreator.newInstance(sm, false);
  }
}
