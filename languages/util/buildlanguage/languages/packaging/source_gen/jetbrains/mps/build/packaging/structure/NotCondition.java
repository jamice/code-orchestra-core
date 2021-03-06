package jetbrains.mps.build.packaging.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NotCondition extends BaseConcept implements ICondition {
  public static final String concept = "jetbrains.mps.build.packaging.structure.NotCondition";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String CONDITION = "condition";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public NotCondition(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(NotCondition.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(NotCondition.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(NotCondition.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(NotCondition.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(NotCondition.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(NotCondition.VIRTUAL_PACKAGE, value);
  }

  public ICondition getCondition() {
    return (ICondition) this.getChild(ICondition.class, NotCondition.CONDITION);
  }

  public void setCondition(ICondition node) {
    super.setChild(NotCondition.CONDITION, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(NotCondition.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, NotCondition.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, NotCondition.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(NotCondition.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, NotCondition.SMODEL_ATTRIBUTE, node);
  }

  public static NotCondition newInstance(SModel sm, boolean init) {
    return (NotCondition) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.NotCondition", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NotCondition newInstance(SModel sm) {
    return NotCondition.newInstance(sm, false);
  }
}
