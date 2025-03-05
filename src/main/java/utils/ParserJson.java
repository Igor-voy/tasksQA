package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ParserJson {
    public static String getTextJson(String nameField) {
        String filePath = "src//test//resources//DataTest.json";

        String textJson = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File(filePath));
            textJson = rootNode.get(nameField).asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textJson;
    }
}
