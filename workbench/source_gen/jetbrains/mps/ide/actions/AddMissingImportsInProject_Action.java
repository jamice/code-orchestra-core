package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.MissingDependenciesFixer;
import java.awt.Frame;
import jetbrains.mps.reloading.ClassLoaderManager;
import com.intellij.openapi.progress.EmptyProgressIndicator;

public class AddMissingImportsInProject_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(AddMissingImportsInProject_Action.class);

  public AddMissingImportsInProject_Action() {
    super("Add Missing Imports", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "AddMissingImportsInProject", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSDataKeys.MPS_PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      for (IModule module : ListSequence.fromList(((MPSProject) MapSequence.fromMap(_params).get("project")).getModules())) {
        if (module.isPackaged()) {
          continue;
        }
        for (SModelDescriptor model : ListSequence.fromList(module.getOwnModelDescriptors())) {
          if (!(SModelStereotype.isUserModel(model))) {
            continue;
          }
          if (!(model instanceof EditableSModelDescriptor)) {
            continue;
          }

          new MissingDependenciesFixer(((Frame) MapSequence.fromMap(_params).get("frame")), model).fix(false);
          module.invalidateCaches();
        }
      }
      ClassLoaderManager.getInstance().reloadAll(new EmptyProgressIndicator());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "AddMissingImportsInProject", t);
      }
    }
  }
}
