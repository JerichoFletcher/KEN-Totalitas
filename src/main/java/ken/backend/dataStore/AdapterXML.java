package ken.backend.dataStore;

import com.google.gson.Gson;
import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.inventory.InventoryHolder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class AdapterXML implements AdapterData{
    public <T> T get(URI uri, Class<T> clazz) throws IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(uri.getPath()));
            Element root = document.getDocumentElement();
            Map<Integer, Barang> map = new HashMap<>();
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int id = Integer.parseInt(element.getAttribute("id"));
                    String namaBarang = element.getElementsByTagName("namaBarang").item(0).getTextContent();
                    int stok = Integer.parseInt(element.getElementsByTagName("stok").item(0).getTextContent());
                    int hargaBarang = Integer.parseInt(element.getElementsByTagName("hargaBarang").item(0).getTextContent());
                    int hargaBeliBarang = Integer.parseInt(element.getElementsByTagName("hargaBeliBarang").item(0).getTextContent());
                    String kategori = element.getElementsByTagName("kategori").item(0).getTextContent();
                    String gambar = element.getElementsByTagName("gambar").item(0).getTextContent();
                    Barang barang = new Barang(namaBarang, stok, hargaBarang, hargaBeliBarang, kategori, gambar, id);
                    map.put(id, barang);
                }
            }

            InventoryHolder.instance().setListBarang(map);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        return null;


    }
    public <T> void write(URI uri,T obj) throws IOException{}


}
