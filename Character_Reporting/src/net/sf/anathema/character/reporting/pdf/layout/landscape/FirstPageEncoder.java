package net.sf.anathema.character.reporting.pdf.layout.landscape;

import net.sf.anathema.character.reporting.pdf.content.ReportSession;
import net.sf.anathema.character.reporting.pdf.layout.Sheet;
import net.sf.anathema.character.reporting.pdf.layout.SheetPage;
import net.sf.anathema.character.reporting.pdf.layout.field.LayoutField;
import net.sf.anathema.character.reporting.pdf.rendering.graphics.SheetGraphics;
import net.sf.anathema.character.reporting.pdf.rendering.page.PageEncoder;

import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.ABILITIES_WITH_SPECIALS_TWO_COLUMN;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.ANIMA;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.ATTRIBUTES;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.BACKGROUNDS;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.ESSENCE_SIMPLE;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.EXPERIENCE;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.GREAT_CURSE;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.INTIMACIES_EXTENDED;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.LANGUAGES;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.NOTES;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.PERSONAL_INFO;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.POSSESSIONS;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.SOCIAL_COMBAT;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.VIRTUES;
import static net.sf.anathema.character.reporting.pdf.rendering.EncoderIds.WILLPOWER_SIMPLE;

public class FirstPageEncoder implements PageEncoder {

  private static final int ATTRIBUTE_HEIGHT = 117;
  private static final int FIRST_ROW_HEIGHT = 51;
  private static final int VIRTUE_HEIGHT = 72;
  private static final int SOCIAL_COMBAT_HEIGHT = 115;

  @Override
  public void encode(Sheet sheet, SheetGraphics graphics, ReportSession session) {
    SheetPage page = sheet.startLandscapePage(graphics, session);
    LayoutField personalInfo =
            page.place(PERSONAL_INFO).atStartOf(page).withHeight(FIRST_ROW_HEIGHT).andColumnSpan(2).now();
    LayoutField willpower = page.place(WILLPOWER_SIMPLE).rightOf(personalInfo).withSameHeight().now();
    LayoutField attributes = page.place(ATTRIBUTES).below(personalInfo).withHeight(ATTRIBUTE_HEIGHT).now();
    LayoutField possession = page.place(POSSESSIONS).rightOf(attributes).withSameHeight().now();
    LayoutField languages = page.place(LANGUAGES).rightOf(possession).withSameHeight().now();
    LayoutField abilities =
            page.place(ABILITIES_WITH_SPECIALS_TWO_COLUMN).below(attributes).withHeight(305).andColumnSpan(3).now();
    LayoutField notes = page.place(NOTES).below(abilities).fillToBottomOfPage().andColumnSpan(2).now();
    LayoutField experience = page.place(EXPERIENCE).rightOf(notes).fillToBottomOfPage().now();

    LayoutField essence = page.place(ESSENCE_SIMPLE).rightOf(willpower).withHeight(FIRST_ROW_HEIGHT).now();
    LayoutField anima = page.place(ANIMA).rightOf(languages).withSameHeight().now();
    LayoutField backgrounds = page.place(BACKGROUNDS).below(anima).fillToBottomOfPage().now();

    LayoutField virtues = page.place(VIRTUES).rightOf(essence).withHeight(VIRTUE_HEIGHT).now();
    LayoutField greatCurse = page.place(GREAT_CURSE).below(virtues).alignBottomTo(languages).now();
    LayoutField social = page.place(SOCIAL_COMBAT).below(greatCurse).withHeight(SOCIAL_COMBAT_HEIGHT).now();
    LayoutField intimacies = page.place(INTIMACIES_EXTENDED, NOTES).below(social).fillToBottomOfPage().now();
  }
}
