package ken.gui;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UnduhDetil implements Runnable{
    private  int id;
    private List<String> listOfName;
    private ArrayList<Integer> listOfAmount;
    private float total;
    UnduhDetil(List<String> listOfName, ArrayList<Integer> listOfAMount, float total, int id){
        this.listOfName = listOfName;
        this.listOfAmount = listOfAMount;
        this.total = total;
        this.id = id;
    }

    @Override
    public void run(){
        try{
            File myFont = new File("./asset/OpenSans-Light.ttf");
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            PDFont font = PDType0Font.load(document, myFont);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            int fontSize = 12;
            contentStream.setFont(font, 12);

//            String[] data = {"apple", "banana", "cherry", "durian", "elderberry"};
            int x = 100;
            int y = 700;
            int lineHeight = 20;
            for (int i = 0; i < listOfName.size(); i++) {
                contentStream.beginText();
                contentStream.newLineAtOffset(x, y - i*lineHeight);
                contentStream.showText(listOfName.get(i) + "    " + listOfAmount.get(i) + 'x');
                contentStream.endText();
            }
            contentStream.beginText();
            contentStream.newLineAtOffset(x, y - listOfName.size()*lineHeight);
            contentStream.showText("" + total);
            contentStream.endText();
            contentStream.close();
            document.save("./test/Bill " + id);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception here
        }
    }
}
