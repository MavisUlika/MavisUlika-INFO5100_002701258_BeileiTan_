import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.print.Book;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdditionalBook {

    public static void main(String[] args) {
        System.out.println("-----------Parse Files From Additional new xml.file-----------");
        writeXML1("BookShelf.xml");
        File additionalBook = new File("BookShelf.xml");
        Main.DOM(additionalBook);
        System.out.println("-----------Parse Files From Additional new json.file-----------");
        writeJSON("BookShelf.json");
        String testJson = "BookShelf.json";
        Main.readJSON(testJson);
    }

    // This is method write to /.xml file
    public static void writeXML1(String xmlFile) {
        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            //use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            //root element --> uses exist root rather than creating new root
            Element rootElement = doc.getDocumentElement();

            Collection<Book> books = new ArrayList<Book>();
            books.add(new Book());

            //Book element
            Element newBook = doc.createElement("Book");

            //setting attribute to element
            Attr attr = doc.createAttribute("title");
            attr.setValue("id04");
            newBook.setAttributeNode(attr);

            //publishedYear Element
            Element publishedYear = doc.createElement("publishedYear");
            publishedYear.appendChild(doc.createTextNode(String.valueOf(2002)));
            newBook.appendChild(publishedYear);

            //numberOfPages Element
            Element numberOfPages = doc.createElement("numberOfPages");
            numberOfPages.appendChild(doc.createTextNode(String.valueOf(230)));
            newBook.appendChild(numberOfPages);

            //authors
            Element author = doc.createElement("author");
            author.appendChild(doc.createTextNode("d1"));
            newBook.appendChild(author);

            Element author1 = doc.createElement("author");
            author1.appendChild(doc.createTextNode("d2"));
            newBook.appendChild(author1);

            Element author2 = doc.createElement("author");
            author2.appendChild(doc.createTextNode("d3"));
            newBook.appendChild(author2);

            rootElement.appendChild(newBook);

            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(xmlFile));
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    // This is method write to /.json file
    public static void writeJSON(String jsonFile){
        //Parse JSON file
        try {
            String cotents = new String(Files.readAllBytes(Paths.get(jsonFile)));
            JSONObject jsonObject = new JSONObject(cotents);
            JSONArray jsonArray = jsonObject.getJSONArray("Book");
            JSONArray author = new JSONArray();
            author.put("d1");
            author.put("d2");
            author.put("d3");
            JSONObject newObject = new JSONObject()
                    .put("title", "id04")
                    .put("publishedYear", 2002)
                    .put("numberOfPages", 230)
                    .put("author", author);
            JSONArray newArray = jsonArray.put(newObject);
            JSONObject newBook = jsonObject.put("Book", newArray);
            Files.write(Paths.get(jsonFile), newBook.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
