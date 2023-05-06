//import java.io.*;
//import java.util.*;
//
//// adapter interface untuk parsing data dari file ke dalam bentuk Map<String, Object>
//interface DataAdapter {
//    Map<String, Object> loadData(String filename) throws IOException;
//}
//
//// JSON adapter untuk parsing data dari file JSON ke dalam bentuk Map<String, Object>
//class JsonDataAdapter implements DataAdapter {
//    private JsonParser parser;
//
//    public JsonDataAdapter() {
//        this.parser = new JsonParser();
//    }
//
//    public Map<String, Object> loadData(String filename) throws IOException {
//        FileReader reader = new FileReader(filename);
//        JsonElement json = parser.parse(reader);
//        reader.close();
//        return jsonToMap(json);
//    }
//
//    private Map<String, Object> jsonToMap(JsonElement json) {
//        Map<String, Object> map = new HashMap<>();
//        for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
//            String key = entry.getKey();
//            JsonElement value = entry.getValue();
//            if (value.isJsonPrimitive()) {
//                map.put(key, value.getAsString());
//            } else if (value.isJsonArray()) {
//                List<Object> list = new ArrayList<>();
//                for (JsonElement element : value.getAsJsonArray()) {
//                    list.add(jsonToMap(element));
//                }
//                map.put(key, list);
//            } else {
//                map.put(key, jsonToMap(value));
//            }
//        }
//        return map;
//    }
//}
//
//// XML adapter untuk parsing data dari file XML ke dalam bentuk Map<String, Object>
//class XmlDataAdapter implements DataAdapter {
//    private DocumentBuilder builder;
//
//    public XmlDataAdapter() throws ParserConfigurationException {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        this.builder = factory.newDocumentBuilder();
//    }
//
//    public Map<String, Object> loadData(String filename) throws IOException, SAXException {
//        Document document = builder.parse(new File(filename));
//        Element root = document.getDocumentElement();
//        return xmlToMap(root);
//    }
//
//    private Map<String, Object> xmlToMap(Element element) {
//        Map<String, Object> map = new HashMap<>();
//        NodeList children = element.getChildNodes();
//        if (children.getLength() == 0 && element.getAttributes().getLength() == 0) {
//            map.put(element.getNodeName(), "");
//        } else if (children.getLength() == 1 && children.item(0) instanceof Text) {
//            map.put(element.getNodeName(), children.item(0).getNodeValue());
//        } else {
//            for (int i = 0; i < children.getLength(); i++) {
//                Node child = children.item(i);
//                if (child instanceof Element) {
//                    Map<String, Object> childMap = xmlToMap((Element) child);
//                    if (map.containsKey(child.getNodeName())) {
//                        Object obj = map.get(child.getNodeName());
//                        if (obj instanceof List<?>) {
//                            ((List<Object>) obj).add(childMap);
//                        } else {
//                            List<Object> list = new ArrayList<>();
//                            list.add(obj);
//                            list.add(childMap);
//                            map.put(child.getNodeName(), list);
//                        }
//                    } else {
//                        map.put(child.getNodeName(), childMap);
//                    }
//                } else if (child instanceof Text) {
//                    String value = child.getNodeValue().trim();
//                    if (!value.isEmpty()) {
//                        map.put(element.getNodeName(), value);
//                    }
//                }
//            }
//            NamedNodeMap attributes = element.getAttributes();
//            for (int i = 0; i < attributes.getLength(); i++) {
//                Attr attribute = (Attr) attributes.item(i);
//                map.put(attribute.getName(), attribute.getValue());
//            }
//        }
//        return map;
//    }
//}
//
//// data store yang berfungsi sebagai penghubung antara aplikasi dan file data
//class DataStore {
//    private String filename;
//    private DataAdapter adapter;
//
//    public DataStore(String filename, DataAdapter adapter) {
//        this.filename = filename;
//        this.adapter = adapter;
//    }
//
//    public Map<String, Object> loadData() throws IOException, SAXException {
//        return adapter.loadData(filename);
//    }
//
//    public void saveData(Map<String, Object> data) throws IOException {
//        FileOutputStream fos = new FileOutputStream(filename);
//        if (filename.endsWith(".json")) {
//            writeJsonData(data, fos);
//        } else if (filename.endsWith(".xml")) {
//            writeXmlData(data, fos);
//        } else if (filename.endsWith(".obj")) {
//            writeObjData(data, fos);
//        } else {
//            throw new UnsupportedOperationException("Unsupported file format");
//        }
//        fos.close();
//    }
//
//    private void writeJsonData(Map<String, Object> data, OutputStream os) throws IOException {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(data);
//        os.write(json.getBytes());
//    }
//
//    private void writeXmlData(Map<String, Object> data, OutputStream os) throws IOException {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.newDocument();
//            Element root = document.createElement("data");
//            for (Map.Entry<String, Object> entry : data.entrySet()) {
//                String key = entry.getKey();
//                Object value = entry.getValue();
//                if (value instanceof List<?>) {
//                    for (Object obj : (List<?>) value) {
//                        Element child = mapToXml(obj, key, document);
//                        root.appendChild(child);
//                    }
//                } else {
//                    Element child = mapToXml(value, key, document);
//                    root.appendChild(child);
//                }
//            }
//            document.appendChild(root);
//
//            TransformerFactory tf = TransformerFactory.newInstance();
//            Transformer transformer = tf.newTransformer();
//            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            transformer.transform(new DOMSource(document), new StreamResult(os));
//        } catch (ParserConfigurationException | TransformerException e) {
//            throw new IOException(e);
//        }
//    }
//
//    private Element mapToXml(Object obj, String name, Document document) {
//        Element element = document.createElement(name);
//        if (obj instanceof Map<?, ?>) {
//            for (Map.Entry<?, ?> entry : ((Map<?, ?>) obj).entrySet()) {
//                String key = entry.getKey().toString();
//                Object value = entry.getValue();
//                if (value instanceof List<?>) {
//                    for (Object child : (List<?>) value) {
//                        Element childElement = mapToXml(child, key, document);
//                        element.appendChild(childElement);
//                    }
//                } else {
//                    Element childElement = mapToXml(value, key, document);
//                    element.appendChild(childElement);
//                }
//            }
//        } else {
//            Text text = document.createTextNode(obj.toString());
//            element.appendChild(text);
//        }
//        return element;
//    }
//
//    private void writeObjData(Map<String, Object> data, OutputStream os) throws IOException {
//        ObjectOutputStream oos = new ObjectOutputStream(os);
//        oos.writeObject(data);
//    }
//
//    public String getFilename() {
//        return filename;
//    }
//
//    public void setFilename(String filename) {
//        this.filename = filename;
//    }
//
//    public void setAdapter(DataAdapter adapter) {
//        this.adapter = adapter;
//    }
//}
//
//// contoh penggunaan data store
//public class Main {
//    public static void main(String[] args) throws IOException, SAXException {
//        DataStore customerStore = new DataStore("customer.json", new JsonDataAdapter());
//        Map<String, Object> customerData = customerStore.loadData();
//        System.out.println(customerData);
//
//        customerData.put("name", "John Doe");
//        customerData.put("age", 30);
//        customerStore.saveData(customerData);
//
//        customerStore.setAdapter(new XmlDataAdapter());
//        customerData = customerStore.loadData();
//        System.out.println(customerData);
//
//        customerData.put("name", "Jane Doe");
//        customerData.put("age", 25);
//        customerStore.saveData(customerData);
//
//        customerStore.setAdapter(new ObjectDataAdapter());
//        customerData = customerStore.loadData();
//        System.out.println(customerData);
//
//        customerData.put("name", "Jack Doe");
//        customerData.put("age", 40);
//        customerStore.saveData(customerData);
//    }
//}