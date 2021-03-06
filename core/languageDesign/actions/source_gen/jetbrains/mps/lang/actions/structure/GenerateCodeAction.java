package jetbrains.mps.lang.actions.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GenerateCodeAction extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.actions.structure.GenerateCodeAction";
  public static final String DESCRIPTION = "description";
  public static final String IS_APPLICABLE = "isApplicable";
  public static final String GET_ACTION_U_I = "getActionUI";
  public static final String EXECUTE_SMART_ACTION = "executeSmartAction";
  public static final String SMART_ACTION_PARAMETER = "smartActionParameter";

  public GenerateCodeAction(SNode node) {
    super(node);
  }

  public String getDescription() {
    return this.getProperty(GenerateCodeAction.DESCRIPTION);
  }

  public void setDescription(String value) {
    this.setProperty(GenerateCodeAction.DESCRIPTION, value);
  }

  public IsSmartActionApplicableFunction getIsApplicable() {
    return (IsSmartActionApplicableFunction) this.getChild(IsSmartActionApplicableFunction.class, GenerateCodeAction.IS_APPLICABLE);
  }

  public void setIsApplicable(IsSmartActionApplicableFunction node) {
    super.setChild(GenerateCodeAction.IS_APPLICABLE, node);
  }

  public GetActionUIFunction getGetActionUI() {
    return (GetActionUIFunction) this.getChild(GetActionUIFunction.class, GenerateCodeAction.GET_ACTION_U_I);
  }

  public void setGetActionUI(GetActionUIFunction node) {
    super.setChild(GenerateCodeAction.GET_ACTION_U_I, node);
  }

  public ExecuteSmartActionFunction getExecuteSmartAction() {
    return (ExecuteSmartActionFunction) this.getChild(ExecuteSmartActionFunction.class, GenerateCodeAction.EXECUTE_SMART_ACTION);
  }

  public void setExecuteSmartAction(ExecuteSmartActionFunction node) {
    super.setChild(GenerateCodeAction.EXECUTE_SMART_ACTION, node);
  }

  public int getSmartActionParametersCount() {
    return this.getChildCount(GenerateCodeAction.SMART_ACTION_PARAMETER);
  }

  public Iterator<SmartActionParameter> smartActionParameters() {
    return this.children(SmartActionParameter.class, GenerateCodeAction.SMART_ACTION_PARAMETER);
  }

  public List<SmartActionParameter> getSmartActionParameters() {
    return this.getChildren(SmartActionParameter.class, GenerateCodeAction.SMART_ACTION_PARAMETER);
  }

  public void addSmartActionParameter(SmartActionParameter node) {
    this.addChild(GenerateCodeAction.SMART_ACTION_PARAMETER, node);
  }

  public void insertSmartActionParameter(SmartActionParameter prev, SmartActionParameter node) {
    this.insertChild(prev, GenerateCodeAction.SMART_ACTION_PARAMETER, node);
  }

  public static GenerateCodeAction newInstance(SModel sm, boolean init) {
    return (GenerateCodeAction) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.actions.structure.GenerateCodeAction", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GenerateCodeAction newInstance(SModel sm) {
    return GenerateCodeAction.newInstance(sm, false);
  }
}
