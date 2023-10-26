package executor.service.service.plugin;

import com.fasterxml.jackson.databind.ObjectMapper;
import executor.service.exception.FileReadException;

import java.io.IOException;
import java.io.InputStream;

public class FileSourcesReader {

    private FileSourcesReader() {
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readFile(String filename, Class<T> valueType) {
        try (InputStream inputStream = ProxySourcesClient.class
                .getClassLoader()
                .getResourceAsStream(filename)) {
            if (inputStream != null) {
                return objectMapper.readValue(inputStream, valueType);
            }
        } catch (IOException e) {
            throw new FileReadException(e.getMessage(), e);
        }
        throw new FileReadException(
                String.format("File not found: %s", filename));
    }
}
