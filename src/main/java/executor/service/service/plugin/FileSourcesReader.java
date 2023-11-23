package executor.service.service.plugin;

import com.fasterxml.jackson.databind.ObjectMapper;
import executor.service.exception.FileReadException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public final class FileSourcesReader {

    private final ObjectMapper objectMapper;

    public FileSourcesReader() {
        this.objectMapper = new ObjectMapper();
    }

    public <T> Queue<T> readAllFromFile(
            String filename,
            Class<T> type) {
        try {
            InputStream inputStream =
                    ClassLoader.getSystemResourceAsStream(filename);
            return new LinkedBlockingQueue<>(objectMapper.readValue(
                    inputStream,
                    objectMapper.getTypeFactory()
                                .constructCollectionType(List.class, type)));
        } catch (IOException e) {
            throw new FileReadException(String.format("File not found: %s", filename));
        }
    }

    public <T> T readFile(
            final String filename,
            final Class<T> valueType) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(
                filename)) {
            if (inputStream != null) {
                return objectMapper.readValue(inputStream, valueType);
            }
        } catch (IOException e) {
            throw new FileReadException(e.getMessage(), e);
        }
        throw new FileReadException(String.format("File not found: %s", filename));
    }
}
