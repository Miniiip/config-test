package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class AppController {

    @Autowired
    private final ApplicationPropertiesConfiguration appProperties;

    public AppController(ApplicationPropertiesConfiguration appProperties) {
        this.appProperties = appProperties;
    }

    @RequestMapping("/")
    public String hello() {
        return "On utilise [" + appProperties.getFoo() + "] depuis le config server sur le client";
    }

}
