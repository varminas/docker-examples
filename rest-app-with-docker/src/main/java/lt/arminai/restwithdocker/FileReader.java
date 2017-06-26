package lt.arminai.restwithdocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by vytautas on 17.6.26.
 */
@Component
public class FileReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);

    public String readFile(String fileName) {

        LOGGER.info("Reading file: {}", fileName);
        //read file into stream, try-with-resources
        StringBuilder stringBuilder = new StringBuilder("");
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(s -> stringBuilder.append(s).append("\n"));
        }
        catch (NoSuchFileException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
