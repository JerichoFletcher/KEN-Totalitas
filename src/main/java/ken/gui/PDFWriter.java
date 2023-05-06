package ken.gui;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFWriter {
    PDFWriter(){
        try{
            File myFont = new File("/home/arieljovananda/Downloads/OpenSans-Light.ttf");
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            PDFont font = PDType0Font.load(document, myFont);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            int fontSize = 12;
            contentStream.setFont(font, 12);

            String[] data = {"apple", "banana", "cherry", "durian", "elderberry"};
            int x = 100;
            int y = 700;
            int lineHeight = 20;
            for (int i = 0; i < data.length; i++) {
                contentStream.beginText();
                contentStream.newLineAtOffset(x, y - i*lineHeight);
                contentStream.showText(data[i]);
                contentStream.endText();
            }
            contentStream.close();
            document.save("/home/arieljovananda/Documents/output.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception here
        }
    }

}
