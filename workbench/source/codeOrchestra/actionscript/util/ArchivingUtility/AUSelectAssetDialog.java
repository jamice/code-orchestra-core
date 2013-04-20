/*
 * Copyright 2003-2011 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package codeOrchestra.actionscript.util.ArchivingUtility;

import codeOrchestra.actionscript.util.ArchivingUtility.SelectItemDialog.AUSelectItemDialog;
import jetbrains.mps.project.IModule;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AUSelectAssetDialog extends AUSelectItemDialog<String> {
  public AUSelectAssetDialog(Frame owner, String title, String runCheckedButtonCaption, List<String> items, Set<String> selectedItemIds) throws HeadlessException {
    super(owner, title, runCheckedButtonCaption, items, selectedItemIds);
  }

  @Override
  public String[] createColumns() {
    return new String[]{"","module name"};
  }

  @Override
  public Object getValueAt(int row, int column) {
    String asset = getItems().get(row);
    if (column == 0) {
      return getSelectedItemIds().contains(asset);
    } else if (column == 1) {
      return asset;
    }
    return null;
  }
  @Override
  public void setValueAt(Object aValue, int row, int column) {
    String id = getItems().get(row);
    if ((Boolean) aValue) {
      getSelectedItemIds().add(id);
    } else {
      getSelectedItemIds().remove(id);
    }
  }
}