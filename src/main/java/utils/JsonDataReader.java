package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDataReader {
    private static final String file =
            "src/test/resources/DataUserTest.json";

    public static List<UserData> readTestData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(file), new TypeReference<List<UserData>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }
}
