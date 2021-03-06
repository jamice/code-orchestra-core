package jetbrains.mps.vcs.integration;

/*Generated by MPS */

import com.intellij.openapi.diff.impl.mergeTool.MergeRequestImpl;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.diff.ActionButtonPresentation;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diff.SimpleContent;
import jetbrains.mps.vcs.ModelMergeRequestConstants;
import com.intellij.openapi.ui.DialogWrapper;
import jetbrains.mps.vcs.ModelUtils;

public class ModelMergeRequest extends MergeRequestImpl {
  private final VirtualFile myFile;

  /*package*/ ModelMergeRequest(String leftText, String rightText, String originalContent, @NotNull VirtualFile file, Project project, ActionButtonPresentation okActionButtonPresentation, ActionButtonPresentation cancelActionButtonPresentation) {
    super(leftText, originalContent, rightText, project, okActionButtonPresentation, cancelActionButtonPresentation);
    ApplicationManager.getApplication().saveAll();
    myFile = file;
  }

  @NotNull
  public VirtualFile getFile() {
    return myFile;
  }

  public void resolved(final byte[] result) {
    ((SimpleContent) getContents()[ModelMergeRequestConstants.ORIGINAL]).setBOM(result);
    setResult(DialogWrapper.OK_EXIT_CODE);
    ModelUtils.replaceWithNewModelFromBytes(myFile, result);
  }
}
