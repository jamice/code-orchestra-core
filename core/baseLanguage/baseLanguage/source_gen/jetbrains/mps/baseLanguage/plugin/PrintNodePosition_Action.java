package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.traceInfo.DebugInfo;
import jetbrains.mps.generator.traceInfo.TraceInfoCache;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.traceInfo.PositionInfo;

public class PrintNodePosition_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(PrintNodePosition_Action.class);

  public PrintNodePosition_Action() {
    super("Print Node Line", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "PrintNodePosition", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
      }
      MapSequence.fromMap(_params).put("node", node);
    }
    if (MapSequence.fromMap(_params).get("node") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("model", event.getData(MPSDataKeys.CONTEXT_MODEL));
    if (MapSequence.fromMap(_params).get("model") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      DebugInfo result = TraceInfoCache.getInstance().get(((SModelDescriptor) MapSequence.fromMap(_params).get("model")));
      if (result != null) {
        PositionInfo positionInfo = result.getPositionForNode(((SNode) MapSequence.fromMap(_params).get("node")).getSNodeId().toString());
        System.out.println(positionInfo);
      }
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "PrintNodePosition", t);
    }
  }
}
