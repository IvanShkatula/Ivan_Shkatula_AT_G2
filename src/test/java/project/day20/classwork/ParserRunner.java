package project.day20.classwork;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParserRunner {

    static JsonParser jsonParser = new JsonParser();
    static GSONParser gsonParser = new GSONParser();
    static JacksonParser jacksonParser = new JacksonParser();
   static ToJson toJson = new ToJson();
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

//            jsonParser.parseJSON();
            gsonParser.parserGSON();
//            jacksonParser.parserJackson();

     //  toJson.fromGSON();


        }


}
