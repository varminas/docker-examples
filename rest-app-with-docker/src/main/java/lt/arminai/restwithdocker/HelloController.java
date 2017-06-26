package lt.arminai.restwithdocker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vytautas on 17.6.26.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String home() {
        return "Hellow from Docker app";
    }
}
