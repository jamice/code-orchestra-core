package jetbrains.mps.ide.actions;

/*Generated by MPS */

import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.Sequence;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import java.util.List;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class OverrideConceptMethodStrategy extends BaseMethodUpdateStrategy {
  public OverrideConceptMethodStrategy(Project project) {
    super(project);
  }

  public void updateMethod(SNode sourceMethod, SNode method) {
    super.updateMethod(sourceMethod, method);
    SNode sourceMethodConcept = SLinkOperations.getTarget(SNodeOperations.getAncestor(sourceMethod, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", false, false), "concept", false);
    if (SNodeOperations.isInstanceOf(sourceMethodConcept, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")) {
      sourceMethodConcept = null;
    }
    Iterable<SNode> paramList = ListSequence.fromList(SLinkOperations.getTargets(method, "parameter", true)).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return new OverrideConceptMethodStrategy.QuotationClass_3gioqg_a0a0a0a0d0a().createNode(it);
      }
    });
    SNode superCallExpr = new OverrideConceptMethodStrategy.QuotationClass_3gioqg_a0a4a0().createNode(sourceMethodConcept, Sequence.fromIterable(paramList).toListSequence(), sourceMethod);
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType")) {
      ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(method, "body", true), "statement", true)).addElement(new OverrideConceptMethodStrategy.QuotationClass_3gioqg_a0a0a0f0a().createNode(superCallExpr));
    } else {
      ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(method, "body", true), "statement", true)).addElement(getReturnStatement(superCallExpr));
    }
  }

  public String getTitle() {
    return "Override Method";
  }

  public JComponent createAdditionalOptionsComponent() {
    JPanel optPanel = new JPanel();
    optPanel.setLayout(new BoxLayout(optPanel, BoxLayout.Y_AXIS));
    optPanel.add(getReturnCheckBox());
    optPanel.add(getRemoveAttributes());
    return optPanel;
  }

  public static class QuotationClass_3gioqg_a0a0a0a0d0a {
    public QuotationClass_3gioqg_a0a0a0a0d0a() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ParameterReference", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("variableDeclaration", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_3gioqg_a0a4a0 {
    public QuotationClass_3gioqg_a0a4a0() {
    }

    public SNode createNode(Object parameter_8, Object parameter_9, Object parameter_10) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      SNode quotedNode_4 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DotExpression", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_5 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.behavior.structure.SuperNodeExpression", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_6 = quotedNode_2;
          quotedNode1_6.setReferent("superConcept", (SNode) parameter_8);
          quotedNode_1.addChild("operand", quotedNode1_6);
        }
        {
          quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_7 = quotedNode_3;
          quotedNode1_7.setReferent("baseMethodDeclaration", (SNode) parameter_10);
          {
            List<SNode> nodes = (List<SNode>) parameter_9;
            for (SNode child : nodes) {
              quotedNode_3.addChild("actualArgument", HUtil.copyIfNecessary(child));
            }
          }
          quotedNode_1.addChild("operation", quotedNode1_7);
        }
        result = quotedNode1_5;
      }
      return result;
    }
  }

  public static class QuotationClass_3gioqg_a0a0a0f0a {
    public QuotationClass_3gioqg_a0a0a0f0a() {
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ExpressionStatement", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("expression", HUtil.copyIfNecessary(quotedNode1_4));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }
}
