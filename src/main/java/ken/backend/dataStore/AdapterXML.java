package ken.backend.dataStore;

import ken.backend.kelas.barang.Barang;
import ken.backend.controller.holder.InventoryHolder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class AdapterXML implements AdapterData{
    public <T> T get(URI uri, Class<T> clazz) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        T obj = (T) unmarshaller.unmarshal(new File(uri.getPath()));
        return obj;


    }
    public <T> void write(URI uri,T obj) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(obj, stringWriter);

        String xml = stringWriter.toString();
//        System.out.println(xml);
        FileWriter fileWriter = new FileWriter(uri.getPath());
        fileWriter.write(xml);
        fileWriter.close();






    }
}
