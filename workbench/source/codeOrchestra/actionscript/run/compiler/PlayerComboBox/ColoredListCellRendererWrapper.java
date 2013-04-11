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
package codeOrchestra.actionscript.run.compiler.PlayerComboBox;
/*
 * Copyright 2000-2012 JetBrains s.r.o.
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

import com.intellij.ui.ColoredListCellRenderer;
import com.intellij.ui.SimpleColoredText;
import com.intellij.ui.SimpleTextAttributes;
import org.jetbrains.annotations.NotNull;

import javax.swing.JList;

/**
 * Typed version of {@link com.intellij.ui.ColoredListCellRenderer}.
 */
public abstract class ColoredListCellRendererWrapper<T> extends ColoredListCellRenderer {
  @Override
  protected final void customizeCellRenderer(JList list, Object value, int index, boolean selected, boolean hasFocus) {
    @SuppressWarnings("unchecked") final T t = (T)value;
    doCustomize(list, t, index, selected, hasFocus);
  }

  protected abstract void doCustomize(JList list, T value, int index, boolean selected, boolean hasFocus);

  public void append(@NotNull SimpleColoredText text) {
    int length = text.getTexts().size();
    for (int i = 0; i < length; i++) {
      String fragment = text.getTexts().get(i);
      SimpleTextAttributes attributes = text.getAttributes().get(i);
      append(fragment, attributes);
    }
  }
}