package jetbrains.mps.lang.editor.editorTest.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SideTranformWrapper extends BaseConcept implements IBaseTestBlock {
  public static final String concept = "jetbrains.mps.lang.editor.editorTest.structure.SideTranformWrapper";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String RIGHT_OPEN = "rightOpen";
  public static final String CHILD = "child";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public SideTranformWrapper(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(SideTranformWrapper.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(SideTranformWrapper.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(SideTranformWrapper.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(SideTranformWrapper.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(SideTranformWrapper.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(SideTranformWrapper.VIRTUAL_PACKAGE, value);
  }

  public boolean getRightOpen() {
    return this.getBooleanProperty(SideTranformWrapper.RIGHT_OPEN);
  }

  public void setRightOpen(boolean value) {
    this.setBooleanProperty(SideTranformWrapper.RIGHT_OPEN, value);
  }

  public IBaseTestBlock getChild() {
    return (IBaseTestBlock) this.getChild(IBaseTestBlock.class, SideTranformWrapper.CHILD);
  }

  public void setChild(IBaseTestBlock node) {
    super.setChild(SideTranformWrapper.CHILD, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(SideTranformWrapper.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, SideTranformWrapper.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, SideTranformWrapper.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(SideTranformWrapper.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, SideTranformWrapper.SMODEL_ATTRIBUTE, node);
  }

  public static SideTranformWrapper newInstance(SModel sm, boolean init) {
    return (SideTranformWrapper) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.editorTest.structure.SideTranformWrapper", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SideTranformWrapper newInstance(SModel sm) {
    return SideTranformWrapper.newInstance(sm, false);
  }
}
