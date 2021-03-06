package net.sf.anathema.character.model.charm;

import net.sf.anathema.character.generic.magic.ICharm;

public interface ICharmLearnListener {

  void charmLearned(ICharm charm);

  void charmForgotten(ICharm charm);

  void charmNotLearnable(ICharm charm);

  void charmNotUnlearnable(ICharm charm);

  void recalculateRequested();
}