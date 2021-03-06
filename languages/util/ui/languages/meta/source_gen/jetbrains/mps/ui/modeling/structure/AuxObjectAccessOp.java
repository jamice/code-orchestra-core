package jetbrains.mps.ui.modeling.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.structure.IOperation;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AuxObjectAccessOp extends BaseConcept implements IOperation {
  public static final String concept = "jetbrains.mps.ui.modeling.structure.AuxObjectAccessOp";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String TEMPLATE = "template";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public AuxObjectAccessOp(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(AuxObjectAccessOp.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(AuxObjectAccessOp.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(AuxObjectAccessOp.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(AuxObjectAccessOp.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(AuxObjectAccessOp.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(AuxObjectAccessOp.VIRTUAL_PACKAGE, value);
  }

  public AuxObjectTemplate getTemplate() {
    return (AuxObjectTemplate) this.getReferent(AuxObjectTemplate.class, AuxObjectAccessOp.TEMPLATE);
  }

  public void setTemplate(AuxObjectTemplate node) {
    super.setReferent(AuxObjectAccessOp.TEMPLATE, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(AuxObjectAccessOp.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, AuxObjectAccessOp.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, AuxObjectAccessOp.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(AuxObjectAccessOp.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, AuxObjectAccessOp.SMODEL_ATTRIBUTE, node);
  }

  public static AuxObjectAccessOp newInstance(SModel sm, boolean init) {
    return (AuxObjectAccessOp) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ui.modeling.structure.AuxObjectAccessOp", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AuxObjectAccessOp newInstance(SModel sm) {
    return AuxObjectAccessOp.newInstance(sm, false);
  }
}
