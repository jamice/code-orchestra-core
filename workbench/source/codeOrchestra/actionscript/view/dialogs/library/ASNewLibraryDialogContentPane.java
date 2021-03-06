package codeOrchestra.actionscript.view.dialogs.library;

import codeOrchestra.actionscript.view.utils.SolutionUtils;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Progressive;
import codeOrchestra.actionscript.stubs.SWCStubsRegistry;
import codeOrchestra.actionscript.view.utils.Languages;
import codeOrchestra.utils.StubSolutionUtils;
import jetbrains.mps.ide.NewModuleCheckUtil;
import jetbrains.mps.ide.common.PathField;
import jetbrains.mps.ide.ui.filechoosers.treefilechooser.TreeFileChooser;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.project.MPSExtentions;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.SModelRoot.ManagerNotFoundException;
import jetbrains.mps.project.Solution;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.project.structure.model.ModelRootManager;
import jetbrains.mps.project.structure.modules.Dependency;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.persistence.IModelRootManager;
import jetbrains.mps.stubs.BaseStubModelDescriptor;
import jetbrains.mps.stubs.BaseStubModelRootManager;
import jetbrains.mps.uiLanguage.runtime.events.Events;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.vfs.IFile;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.Property;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ASNewLibraryDialogContentPane extends JPanel {
  public ASNewLibraryDialogContentPane myThis;
  private JTextField nameFieldComponent;
  private PathField myPath0;
  private String mySwcFilePath;
  private boolean myCompileInMPS = true;
  private MPSProject myProject;
  private Solution myResult;
  private ASNewLibraryDialog myDialog;
  private JCheckBox copyLibraryCheckBox;

  public List<AutoBinding> myBindings = ListSequence.fromList(new ArrayList<AutoBinding>());

  private Events myEvents = new Events(null) {
    {
    }

    public void initialize() {
    }
  };
  private static final String PLAYERGLOBAL_SWC = "playerglobal_swc";

  public ASNewLibraryDialogContentPane() {
    this.myThis = this;
    ASNewLibraryDialogContentPane component = this;
    component.setLayout(new GridLayout(0, 2));
    component.add(this.createNameLabelComponent());
    component.add(this.createNameFieldComponent());
    component.add(this.createComponent0());
    component.add(this.createComponent1());
    component.add(this.createComponent2());
    this.myEvents.initialize();
    myThis.setSwcFilePath("");
    myThis.myPath0.setName("Path");
    myThis.myPath0.setMode(TreeFileChooser.MODE_FILES);
  }

  public Events getEvents() {
    return this.myEvents;
  }

  public void addNotify() {
    super.addNotify();
    this.bind();
  }

  public void removeNotify() {
    this.unbind();
    super.removeNotify();
  }

  private void bind() {
    {
      Object sourceObject = myThis;
      Property sourceProperty = BeanProperty.create("swcFilePath");
      Object targetObject = this.myPath0;
      Property targetProperty = BeanProperty.create("path");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      ListSequence.fromList(this.myBindings).addElement(binding);
    }
  }

  private void unbind() {
    for (AutoBinding binding : this.myBindings) {
      if (binding.isBound()) {
        binding.unbind();
      }
    }
  }

  private JLabel createNameLabelComponent() {
    JLabel component = new JLabel();
    component.setText("Library Name:");
    return component;
  }

  private JTextField createNameFieldComponent() {
    JTextField component = new JTextField();
    this.nameFieldComponent = component;
    return component;
  }

  private JLabel createComponent0() {
    JLabel component = new JLabel();
    component.setText("SWC File Path:");
    return component;
  }

  private PathField createComponent1() {
    PathField component = new PathField();
    this.myPath0 = component;
    return component;
  }

  private JCheckBox createComponent2() {
    JCheckBox component = new JCheckBox("Copy SWC file to module dir");
    component.setSelected(true);
    this.copyLibraryCheckBox = component;
    return component;
  }

  public String getSwcFilePath() {
    return this.mySwcFilePath;
  }

  public boolean getCompileInMPS() {
    return this.myCompileInMPS;
  }

  public MPSProject getProject() {
    return this.myProject;
  }

  public Solution getResult() {
    return this.myResult;
  }

  public ASNewLibraryDialog getDialog() {
    return this.myDialog;
  }

  public void setSwcFilePath(String newValue) {
    String oldValue = this.mySwcFilePath;
    this.mySwcFilePath = newValue;
    this.firePropertyChange("swcFilePath", oldValue, newValue);
  }

  public void setCompileInMPS(boolean newValue) {
    boolean oldValue = this.myCompileInMPS;
    this.myCompileInMPS = newValue;
    this.firePropertyChange("compileInMPS", oldValue, newValue);
  }

  public void setProject(MPSProject newValue) {
    MPSProject oldValue = this.myProject;
    this.myProject = newValue;
    this.firePropertyChange("project", oldValue, newValue);
  }

  public void setResult(Solution newValue) {
    Solution oldValue = this.myResult;
    this.myResult = newValue;
    this.firePropertyChange("result", oldValue, newValue);
  }

  public void setDialog(ASNewLibraryDialog newValue) {
    ASNewLibraryDialog oldValue = this.myDialog;
    this.myDialog = newValue;
    this.firePropertyChange("dialog", oldValue, newValue);
  }

  /*package*/ void onOk() {
    String libName = nameFieldComponent.getText();

    if (libName.isEmpty()) {
      myThis.getDialog().setErrorText("Enter the library name");
      return;
    }

    if (!SolutionUtils.isValidModuleName(libName)) {
      myThis.getDialog().setErrorText("Invalid library name");
      return;
    }

    if (MPSModuleRepository.getInstance().getModuleByUID(libName) != null) {
      myThis.getDialog().setErrorText("Duplicate library name: " + libName);
      return;
    }

    if (myThis.getSwcFilePath().length() == 0) {
      myThis.getDialog().setErrorText("Enter .swc (.ane) library path");
      return;
    }

    File swcFile = new File(myThis.getSwcFilePath());

    if (!(swcFile.exists())) {
      myThis.getDialog().setErrorText("SWC (ANE) file under the path specified doesn't exist");
      return;
    }

    String swcFileName = swcFile.getName();
    String swcFileNameLowerCase = swcFileName.toLowerCase();
    if (!(swcFileNameLowerCase.endsWith(".swc") || swcFileNameLowerCase.endsWith(".ane"))) {
      myThis.getDialog().setErrorText("SWC or ANE file expected");
      return;
    }

    String projectPath = FileUtil.getCanonicalPath(myThis.getProject().getProjectFile().getParentFile());
    String solutionDirPath = projectPath + File.separator + "modules" + File.separator + libName;

    String message = NewModuleCheckUtil.checkModuleDirectory(new File(solutionDirPath), MPSExtentions.DOT_SOLUTION, "Module");
    if (message != null) {
      myThis.getDialog().setErrorText(message);
      return;
    }

    final String descriptorPath = solutionDirPath + File.separator + libName + MPSExtentions.DOT_SOLUTION;

    myThis.getDialog().dispose();

    SolutionUtils.refreshModuleFiles(descriptorPath);

    final List<SModelDescriptor> modelDescriptors = new ArrayList<SModelDescriptor>();
    ModelAccess.instance().runWriteActionWithProgressSynchronously(new Progressive() {
      public void run(ProgressIndicator indicator) {
        indicator.setIndeterminate(true);
        myThis.setResult(myThis.createNewSolution(FileSystem.getInstance().getFileByPath(descriptorPath)));

        // RE-912
        for (final SModelDescriptor sModelDescriptor : myResult.getOwnModelDescriptors()) {
          if (sModelDescriptor instanceof BaseStubModelDescriptor) {
            BaseStubModelDescriptor stubModelDescriptor = (BaseStubModelDescriptor) sModelDescriptor;

            // RF-616
            if (stubModelDescriptor.getLoadingState() == ModelLoadingState.NOT_LOADED) {
              ModelRootManager swcManagerDesc = LanguageID.SWC_MANAGER;
              IModelRootManager modelRootManager = null;
              try {
                modelRootManager = BaseStubModelRootManager.create(swcManagerDesc.getModuleId(), swcManagerDesc.getClassName());
              } catch (ManagerNotFoundException e) {
                throw new RuntimeException("Can't locate the SWC stub model root manager " + swcManagerDesc);
              }
              stubModelDescriptor.setModelRootManager(modelRootManager);
            }

            modelDescriptors.add(sModelDescriptor);
          }
        }
      }
    }, "Creating", false, myThis.getProject().getProject());

    // RE-3181
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      @Override
      public void run() {
        try {
          SWCStubsRegistry.setAvoidIndexing(true);
          SModelOperations.validateLanguagesAndImportsNew(modelDescriptors, myResult);
        } finally {
          SWCStubsRegistry.setAvoidIndexing(false);
          StubSolutionUtils.invalidateStubSolutionCaches(myResult);
        }
      }
    }, getProject().getProject());
  }

  /*package*/ void onCancel() {
    myThis.getDialog().dispose();
  }

  /*package*/ Solution createNewSolution(final IFile solutionDescriptorFile) {
    MPSProject mpsProject = myThis.getProject();

    // Prepare files
    File dir = new File(solutionDescriptorFile.getAbsolutePath()).getParentFile();
    if (!(dir.exists())) {
      dir.mkdirs();
    }
    String solutionFileName = solutionDescriptorFile.getName();
    String solutionName = solutionFileName.substring(0, solutionFileName.length() - 4);

    // Create
    // RE-2448
    ModelRoot modelRoot = new ModelRoot();
    modelRoot.setPrefix("");
    modelRoot.setPath(solutionDescriptorFile.getParent().getAbsolutePath());
    final Solution solution = Solution.createStubSolution(solutionName, solutionDescriptorFile, mpsProject, modelRoot);

    SolutionDescriptor solutionDescriptor = solution.getModuleDescriptor();
    solutionDescriptor.setCompileInMPS(myThis.getCompileInMPS());

    // Add SWC file to the classpath
    ModelRoot stubModelEntry = new ModelRoot();
    if (copyLibraryCheckBox.isSelected()) {
      File swcFile = new File(myThis.getSwcFilePath());
      File targetSWCFile = new File(dir.getPath() + File.separator + swcFile.getName());
      FileUtil.copyFile(swcFile, targetSWCFile);
      stubModelEntry.setPath(targetSWCFile.getPath());
    } else {
      stubModelEntry.setPath(myThis.getSwcFilePath());
    }
    stubModelEntry.setManager(LanguageID.SWC_MANAGER);
    solutionDescriptor.getStubModelEntries().add(stubModelEntry);

    // Add languages refs
    solutionDescriptor.getUsedLanguages().add(ModuleReference.fromString(Languages.ACTION_SCRIPT_INTERNAL));
    solutionDescriptor.getUsedLanguages().add(ModuleReference.fromString(Languages.ACTION_SCRIPT_LOGGING));
    solutionDescriptor.getUsedLanguages().add(ModuleReference.fromString(Languages.ACTION_SCRIPT_ASSETS));

    // Add playerglobal reference
    Dependency playerGlobalDependency = new Dependency();
    playerGlobalDependency.setModuleRef(ModuleReference.fromString(PLAYERGLOBAL_SWC));
    solutionDescriptor.getDependencies().add(playerGlobalDependency);

    // Save the solution descriptor
    ModelAccess.instance().writeFilesInEDT(new Runnable() {
      public void run() {
        solution.save();
      }
    });
    mpsProject.addProjectModule(solution);

    return solution;
  }
}
