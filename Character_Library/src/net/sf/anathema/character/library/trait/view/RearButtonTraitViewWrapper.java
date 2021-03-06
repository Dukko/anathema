package net.sf.anathema.character.library.trait.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import net.disy.commons.swing.layout.grid.GridDialogLayout;
import net.disy.commons.swing.layout.grid.GridDialogLayoutData;
import net.sf.anathema.character.library.intvalue.IRemovableTraitView;

public class RearButtonTraitViewWrapper<K extends ITraitView< ? >> extends AbstractTraitViewWrapper<K> implements
    IRemovableTraitView<K> {

  private final JButton button;
  private JPanel traitViewPanel;
  private JPanel innerViewPanel;

  public RearButtonTraitViewWrapper(K view, Icon buttonIcon) {
    super(view);
    this.button = new JButton(buttonIcon);
    button.setPreferredSize(new Dimension(buttonIcon.getIconWidth() + 4, buttonIcon.getIconHeight() + 4));
  }

  @Override
  public void addComponents(JPanel panel) {
    this.traitViewPanel = panel;
    this.innerViewPanel = new JPanel(new GridDialogLayout(2, false));
    getInnerView().addComponents(innerViewPanel);
    panel.add(innerViewPanel, GridDialogLayoutData.FILL_HORIZONTAL);
    panel.add(button, GridDialogLayoutData.RIGHT);
    panel.revalidate();
  }

  @Override
  public void setButtonEnabled(boolean enabled) {
    button.setEnabled(enabled);
  }

  @Override
  public void addButtonListener(ActionListener listener) {
    button.addActionListener(listener);
  }

  @Override
  public void delete() {
    getInnerView().delete();
    traitViewPanel.remove(innerViewPanel);
    traitViewPanel.remove(button);
    traitViewPanel.revalidate();
  }
}