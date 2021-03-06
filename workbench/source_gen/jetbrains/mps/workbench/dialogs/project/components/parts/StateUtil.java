package jetbrains.mps.workbench.dialogs.project.components.parts;

/*Generated by MPS */

import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.MPSModuleRepository;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.util.Computable;

public class StateUtil {
  public static final int normal = 0;

  public StateUtil() {
  }

  public static boolean isAvailable(final SModelReference modelReference) {
    return SModelRepository.getInstance().getModelDescriptor(modelReference) != null;
  }

  public static boolean isAvailable(ModuleReference moduleReference) {
    return MPSModuleRepository.getInstance().getModule(moduleReference) != null;
  }

  public static boolean isAvailable(String path) {
    VirtualFile file = VirtualFileUtils.getVirtualFile(path);
    if (file == null || !(file.exists())) {
      return false;
    }
    return true;
  }

  public static boolean isInScope(final IScope scope, final SModelReference modelReference) {
    SModelDescriptor model;
    if (scope != null) {
      model = ModelAccess.instance().runReadAction(new Computable<SModelDescriptor>() {
        public SModelDescriptor compute() {
          return scope.getModelDescriptor(modelReference);
        }
      });
      return model != null;
    }
    return true;
  }

  public static int compare(boolean isOk1, boolean isOk2) {
    if (isOk1 && !(isOk2)) {
      return 1;
    }
    if (isOk2 && !(isOk1)) {
      return -1;
    }
    return 0;
  }

  public static int compare(final SModelReference ref1, final SModelReference ref2, final IScope scope) {
    int result = compare(isAvailable(ref1), isAvailable(ref2));
    if (result != 0) {
      return result;
    }
    return compare(isInScope(scope, ref1), isInScope(scope, ref2));
  }

  public static int compare(ModuleReference moduleRef1, ModuleReference moduleRef2) {
    return compare(isAvailable(moduleRef1), isAvailable(moduleRef2));
  }

  public static int compare(String path1, String path2) {
    return compare(isAvailable(path1), isAvailable(path2));
  }
}
