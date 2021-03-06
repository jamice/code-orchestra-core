package jetbrains.mps.nanoc.plugin;

/*Generated by MPS */

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;

public class SourceNanocConfiguration_Factory extends ConfigurationFactory {
  public SourceNanocConfiguration_Factory(ConfigurationType type) {
    super(type);
  }

  public RunConfiguration createTemplateConfiguration(Project p) {
    return new SourceNanocConfiguration_Configuration(p, this, "TemplateName");
  }

  public String getName() {
    return "Nanoc Source File";
  }
}
