import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("-----------Parse Files From xml.file-----------");
        File xmlFile = new File("BookShelf.xml");
        DOM(xmlFile);
        System.out.println("-----------Parse Files From Json.file-----------");
        String jsonFile = "BookShelf.json";
        readJSON(jsonFile);
    }
    // This is method to parse /.xml file
    public static void DOM(File xmlFile) {
        //Get the Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Get Document
            Document document = builder.parse(xmlFile);

            //Normalize the xml structure
            document.getDocumentElement().normalize();

            //Get all the element by the tag name
            NodeList bookList = document.getElementsByTagName("Book");

            for (int i = 0; i < bookList.getLength(); i++) {
                Node book = bookList.item(i);

                if (book.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) book;
                    System.out.println("Book Title: " + bookElement.getAttribute("title"));
                    System.out.println("Book Published Year: " + bookElement.getElementsByTagName("publishedYear").item(0).getTextContent());
                    System.out.println("Book Number Of Pages: " + bookElement.getElementsByTagName("numberOfPages").item(0).getTextContent());
                    NodeList bookAuthor = bookElement.getElementsByTagName("author");
                    List<String> author = new ArrayList<>();
                    for (int j = 0; j < bookAuthor.getLength(); j++) {
                        author.add(bookAuthor.item(j).getTextContent());
                    }
                    System.out.println("Book Authors: " + author);
                    System.out.println();
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    // This is method to parse /.json file
    public static void readJSON(String jsonFile) {
        //Parse JSON file
        try {
            String cotents = new String(Files.readAllBytes(Paths.get(jsonFile)));
            JSONObject jsonObject = new JSONObject(cotents);
            JSONArray jsonArray = jsonObject.getJSONArray("Book");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                //System.out.println(object);
                String title = object.getString("title");
                int publishedYear = object.getInt("publishedYear");
                int numberOfPages = object.getInt("numberOfPages");
                System.out.println("Book Title: " + title);
                System.out.println("Book Published Year: " + publishedYear);
                System.out.println("Book Number Of Pages: "+ numberOfPages);
                JSONArray authors = object.getJSONArray("author");
                List<String> author_list = new ArrayList<>();
                for(int j = 0; j < authors.length(); j++){
                    author_list.add(authors.getString(j));
                }
                System.out.println("Book Authors: " + author_list);
                System.out.println();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}