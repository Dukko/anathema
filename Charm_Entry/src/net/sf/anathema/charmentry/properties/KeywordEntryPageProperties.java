package net.sf.anathema.charmentry.properties;

import net.sf.anathema.framework.presenter.resources.BasicUi;
import net.sf.anathema.framework.view.IdentificateSelectCellRenderer;
import net.sf.anathema.lib.message.BasicMessage;
import net.sf.anathema.lib.message.IBasicMessage;
import net.sf.anathema.lib.resources.IResources;

import javax.swing.Icon;
import javax.swing.ListCellRenderer;

public class KeywordEntryPageProperties implements IKeywordEntryPageProperties {

  private final IResources resources;
  private final IBasicMessage defaultMessage;
  private final BasicUi ui;

  public KeywordEntryPageProperties(IResources resources) {
    this.resources = resources;
    this.ui = new BasicUi(resources);
    defaultMessage = new BasicMessage(resources.getString("CharmEntry.Keywords.Message.Default")); //$NON-NLS-1$
  }

  @Override
  public IBasicMessage getDefaultMessage() {
    return defaultMessage;
  }

  @Override
  public String getPageTitle() {
    return resources.getString("CharmEntry.Keywords.Title"); //$NON-NLS-1$
  }

  @Override
  public Icon getAddIcon() {
    return ui.getAddIcon();
  }

  @Override
  public String getKeywordLabel() {
    return resources.getString("CharmEntry.Keywords.Keyword"); //$NON-NLS-1$
  }

  @Override
  public Icon getRemoveIcon() {
    return ui.getRemoveIcon();
  }

  @Override
  public ListCellRenderer getKeywordRenderer() {
    return new IdentificateSelectCellRenderer("Keyword.", resources); //$NON-NLS-1$
  }
}
