package jetbrains.mps.baseLanguage.datesInternal.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import java.util.Map;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BaseReferenceConstraintsDescriptor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.base.BaseReferenceScopeProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsContext;
import jetbrains.mps.baseLanguage.search.ClassifierVisibleStaticMembersScope;
import jetbrains.mps.generator.JavaModelUtil_new;
import org.joda.time.Period;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import org.joda.time.DateTimeFieldType;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import org.joda.time.format.PeriodFormatterBuilder;
import jetbrains.mps.baseLanguage.search.ClassifierVisibleMembersScope;

public class DateTimeProperty_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_hi7gxv_a0a1a0a0a1a0b0a1a0 = new SNodePointer("r:00000000-0000-4000-0000-011c895903db(jetbrains.mps.baseLanguage.datesInternal.constraints)", "1213104855643");
  private static SNodePointer breakingNode_hi7gxv_a0a1a0a0a1a0b0a2a0 = new SNodePointer("r:00000000-0000-4000-0000-011c895903db(jetbrains.mps.baseLanguage.datesInternal.constraints)", "1213104855656");
  private static SNodePointer breakingNode_hi7gxv_a0a1a0a0a1a0b0a3a0 = new SNodePointer("r:00000000-0000-4000-0000-011c895903db(jetbrains.mps.baseLanguage.datesInternal.constraints)", "48671598476606830");

  public DateTimeProperty_Constraints() {
    super("jetbrains.mps.baseLanguage.datesInternal.structure.DateTimeProperty");
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("jodaPeriodType", new BaseReferenceConstraintsDescriptor("jodaPeriodType", this) {
      @Override
      public boolean hasOwnScopeProvider() {
        return true;
      }

      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return new BaseReferenceScopeProvider() {
          @Override
          public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            return new ClassifierVisibleStaticMembersScope(JavaModelUtil_new.findClassifier(Period.class), _context.getEnclosingNode(), IClassifiersSearchScope.STATIC_METHOD);
          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_hi7gxv_a0a1a0a0a1a0b0a1a0;
          }
        };
      }
    });
    references.put("jodaDateTimeFieldType", new BaseReferenceConstraintsDescriptor("jodaDateTimeFieldType", this) {
      @Override
      public boolean hasOwnScopeProvider() {
        return true;
      }

      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return new BaseReferenceScopeProvider() {
          @Override
          public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            return new ClassifierVisibleStaticMembersScope(JavaModelUtil_new.findClassifier(DateTimeFieldType.class), _context.getEnclosingNode(), IClassifiersSearchScope.STATIC_METHOD);
          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_hi7gxv_a0a1a0a0a1a0b0a2a0;
          }
        };
      }
    });
    references.put("periodFormatMethod", new BaseReferenceConstraintsDescriptor("periodFormatMethod", this) {
      @Override
      public boolean hasOwnScopeProvider() {
        return true;
      }

      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return new BaseReferenceScopeProvider() {
          @Override
          public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            SNode ct = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ClassifierType", null);
            SLinkOperations.setTarget(ct, "classifier", (SNode) JavaModelUtil_new.findClassifier(PeriodFormatterBuilder.class), false);
            return new ClassifierVisibleMembersScope(ct, _context.getEnclosingNode(), IClassifiersSearchScope.INSTANCE_METHOD);
          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_hi7gxv_a0a1a0a0a1a0b0a3a0;
          }
        };
      }
    });
    return references;
  }
}
