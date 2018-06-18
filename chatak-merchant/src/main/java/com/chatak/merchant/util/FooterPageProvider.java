package com.chatak.merchant.util;

import java.awt.Color;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.chatak.pg.util.Constants;
import com.chatak.pg.util.Properties;

import be.quodlibet.boxable.page.PageProvider;
import be.quodlibet.boxable.utils.PDStreamUtils;

public class FooterPageProvider implements PageProvider<PDPage> {

  private final PDDocument document;

  private final PDRectangle size;

  private int currentPageIndex = -1;

  public static final String FOOTER = Properties.getProperty("footer.copyright.pdf");

  float fontSize =Constants.INDEX_TEN;
  float x =Constants.INT_THIRTY;
  float y =Constants.CARD_NUMBER_MIN_LENGTH;
  PDFont font = PDType1Font.TIMES_ROMAN;


  public FooterPageProvider(final PDDocument document, final PDRectangle size) {
    this.document = document;
    this.size = size;
  }

  @Override
  public PDPage createPage() {
    currentPageIndex = document.getNumberOfPages();
    return getCurrentPage();
  }

  @Override
  public PDPage nextPage() {
    if (currentPageIndex == -1) {
      currentPageIndex = document.getNumberOfPages();

    } else {
      currentPageIndex++;
    }
    writeFooter(getCurrentPage());
    return getCurrentPage();
  }

  private PDPage getCurrentPage() {
    if (currentPageIndex >= document.getNumberOfPages()) {
      final PDPage newPage = new PDPage(size);
      document.addPage(newPage);
      return newPage;
    }
    return document.getPage(currentPageIndex);
  }

  private void writeFooter(PDPage page) {
    try {
			PDPageContentStream stream = new PDPageContentStream(document, page);
			PDStreamUtils.rect(stream, Constants.INT_THIRTY, Constants.INDEX_EIGHTEEN,
					page.getMediaBox().getWidth() - Constants.INT_FIFTY, Constants.INDEX_ONE, Color.BLACK);
			PDStreamUtils.write(stream, FOOTER, font, fontSize, x, y, Color.BLACK);
			PDStreamUtils.write(stream, String.valueOf(currentPageIndex + 1), font, fontSize,
					page.getMediaBox().getWidth() - Constants.INT_THIRTY, y, Color.BLACK);
      stream.close();
    } catch (Exception e) {
    }
  }

  @Override
  public PDPage previousPage() {
    currentPageIndex--;
    if (currentPageIndex < 0) {
      currentPageIndex = 0;
    }

    return getCurrentPage();
  }

  @Override
  public PDDocument getDocument() {
    return document;
  }

}
