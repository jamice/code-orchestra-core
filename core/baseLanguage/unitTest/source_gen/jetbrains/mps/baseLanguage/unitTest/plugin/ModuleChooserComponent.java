package jetbrains.mps.baseLanguage.unitTest.plugin;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.runConfigurations.runtime.BaseChooserComponent;
import java.util.List;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import jetbrains.mps.workbench.dialogs.choosers.CommonChoosers;
import java.util.Collections;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.project.GlobalScope;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelDescriptor;

public class ModuleChooserComponent extends BaseChooserComponent {
  private final List<ModuleReference> myCheckedModules = ListSequence.fromList(new ArrayList<ModuleReference>());

  public ModuleChooserComponent() {
    super();
    this.init(new ActionListener() {
      public void actionPerformed(ActionEvent p0) {
        ModuleChooserComponent.this.collectModules();
        StringBuilder result = new StringBuilder();
        ModuleReference ref = CommonChoosers.showDialogModuleChooser(ModuleChooserComponent.this, "", ModuleChooserComponent.this.myCheckedModules, Collections.EMPTY_LIST);
        if (ref != null) {
          result.append(ref.getModuleFqName());
          ModuleChooserComponent.this.setText(result.toString());
        }
      }
    });
  }

  private void collectModules() {
    ListSequence.fromList(this.myCheckedModules).clear();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        List<SNode> nodes = ListSequence.fromListWithValues(new ArrayList<SNode>(), FindUsagesManager.getInstance().findInstances(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.unitTest.structure.ITestCase"), GlobalScope.getInstance(), new FindUsagesManager.ProgressAdapter(new EmptyProgressIndicator()), false));
        for (SNode node : nodes) {
          SModel model = SNodeOperations.getModel(node);
          SModelDescriptor md = model.getModelDescriptor();
          ModuleReference module = md.getModule().getModuleReference();
          if (ListSequence.fromList(ModuleChooserComponent.this.myCheckedModules).contains(module)) {
            continue;
          }
          ListSequence.fromList(ModuleChooserComponent.this.myCheckedModules).addElement(module);
        }
      }
    });
  }
}
