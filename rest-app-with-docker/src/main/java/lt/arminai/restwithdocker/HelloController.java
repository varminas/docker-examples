package lt.arminai.restwithdocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vytautas on 17.6.26.
 */
@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private FileReader fileReader;

    @Value("${base-file-directory}")
    private String baseDir;

    @RequestMapping("/")
    public String home() {
        LOGGER.info("Received request home()");

        return "Hello from Docker app";
    }

    @RequestMapping("/read/{fileName}")
    public String readFile(@PathVariable("fileName") String fileName) {
        LOGGER.info("read {}", fileName);

        return fileReader.readFile(baseDir + "/"+ fileName);
    }
}
