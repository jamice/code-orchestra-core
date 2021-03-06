package jetbrains.mps.lang.textGen.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.textGen.behavior.LanguageTextGenDeclaration_Behavior;
import jetbrains.mps.smodel.action.ChildSubstituteActionsHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;

public class QueriesGenerated {
  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_1237983685138(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getSourceNode()), "jetbrains.mps.lang.textGen.structure.CollectionAppendPart");
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1234362700251(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      Calculable calc = new Calculable() {
        public Object calculate() {
          List<SNode> langTextGenComponents = SNodeOperations.getAncestors(_context.getParentNode(), "jetbrains.mps.lang.textGen.structure.LanguageTextGenDeclaration", false);
          SNode langTextGen = ListSequence.fromList(langTextGenComponents).first();
          if (langTextGen != null) {
            return LanguageTextGenDeclaration_Behavior.call_getParameters_1234799367488(langTextGen);
          } else {
            return ListSequence.fromList(new ArrayList<SNode>());
          }
        }
      };
      Iterable queryResult = (Iterable) calc.calculate();
      if (queryResult != null) {
        for (Object item : queryResult) {
          List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions((SNode) item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
          ListSequence.fromList(result).addSequence(ListSequence.fromList(defaultActions));
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_ConstantStringAppendPart_1237476086426(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.textGen.structure.ConstantStringAppendPart");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode result = SNodeFactoryOperations.createNewNode(model, "jetbrains.mps.lang.textGen.structure.ConstantStringAppendPart", _context.getCurrentTargetNode());
            SPropertyOperations.set(result, "value", NameUtil.stripQuotes(pattern, "\"", "\""));
            return result;
          }

          public boolean hasSubstitute() {
            return true;
          }

          public boolean canSubstitute_internal(String pattern, boolean strictly) {
            return pattern.equals("\"");
          }

          public String getMatchingText(String pattern) {
            return pattern;
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_1237983637152(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SPropertyOperations.set(SNodeOperations.cast(SNodeOperations.getParent(_context.getSourceNode()), "jetbrains.mps.lang.textGen.structure.CollectionAppendPart"), "withSeparator", "" + true);
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return " ";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }
}
