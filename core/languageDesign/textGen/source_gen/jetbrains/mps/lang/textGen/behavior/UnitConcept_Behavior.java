package jetbrains.mps.lang.textGen.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class UnitConcept_Behavior {
  private static Class[] PARAMETERS_3822000666564591112 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String call_getUnitName_3822000666564591112(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.textGen.structure.UnitConcept"), "virtual_getUnitName_3822000666564591112", PARAMETERS_3822000666564591112);
  }

  public static String callSuper_getUnitName_3822000666564591112(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.textGen.structure.UnitConcept"), callerConceptFqName, "virtual_getUnitName_3822000666564591112", PARAMETERS_3822000666564591112);
  }
}
