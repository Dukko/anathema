package net.sf.anathema.character.lunar;

import org.dom4j.Element;

import net.sf.anathema.character.generic.framework.xml.additional.IAdditionalTemplateParser;
import net.sf.anathema.character.generic.template.additional.IAdditionalTemplate;
import net.sf.anathema.character.lunar.heartsblood.HeartsBloodTemplate;

public class LunarHeartsBloodParser implements IAdditionalTemplateParser {

  @Override
  public IAdditionalTemplate parse(Element element) {
    return new HeartsBloodTemplate();
  }
}