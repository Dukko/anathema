package net.sf.anathema.charmentry.model;

import net.sf.anathema.character.generic.impl.magic.persistence.ICharmCache;
import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.charmentry.model.data.IConfigurableCharmData;
import net.sf.anathema.charmentry.presenter.model.ICharmPrerequisitesEntryModel;
import net.sf.anathema.charmentry.presenter.model.IPrerequisitesModel;
import net.sf.anathema.lib.control.IChangeListener;
import net.sf.anathema.lib.exception.PersistenceException;
import net.sf.anathema.lib.gui.wizard.workflow.CheckInputListener;
import net.sf.anathema.lib.util.SimpleBlock;
import org.jmock.example.announcer.Announcer;

import java.util.ArrayList;
import java.util.List;

public class CharmPrerequisitesEntryModel implements ICharmPrerequisitesEntryModel {

  private final IConfigurableCharmData charmData;
  private final ICharmCache cache;
  private final Announcer<IChangeListener> control = Announcer.to(IChangeListener.class);

  public CharmPrerequisitesEntryModel(
      IHeaderDataModel headerModel,
      IPrerequisitesModel prerequisiteModel,
      IConfigurableCharmData charmData,
      ICharmCache cache) {
    this.charmData = charmData;
    this.cache = cache;
    CheckInputListener changeListener = new CheckInputListener(new SimpleBlock() {
      @Override
      public void execute() {
        control.announce().changeOccurred();
      }
    });
    headerModel.addModelListener(changeListener);
    prerequisiteModel.addModelListener(changeListener);
  }

  @Override
  public void addModelListener(IChangeListener inputListener) {
    control.addListener(inputListener);
  }

  @Override
  public ICharm[] getAvailableCharms() throws PersistenceException {
    if (charmData.getCharacterType() == null
        || charmData.getPrimaryTraitType() == null) {
      return new ICharm[0];
    }
    ICharm[] charms = cache.getCharms(charmData.getCharacterType());
    List<ICharm> filterList = new ArrayList<ICharm>();
    for (ICharm charm : charms) {
      if (charm.getPrimaryTraitType() == charmData.getPrimaryTraitType()) {
        filterList.add(charm);
      }
    }
    return filterList.toArray(new ICharm[filterList.size()]);
  }

  @Override
  public void setPrerequisiteCharms(ICharm[] charms) {
    charmData.setParentCharms(charms);
  }

  @Override
  public void setRequiresExcellency(boolean required) {
    charmData.setExcellencyRequired(required);
  }
}