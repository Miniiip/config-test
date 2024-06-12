package example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// This will allow us to reinitialize this controller to get any new config
// values when the /refresh endpoint is POSTed to.
@RefreshScope
public class AppController {

    private final ApplicationPropertiesConfiguration appProperties;

//    @Value("${info.foo}")
//    private String fooProperty;

    @Value("${dev.message}")
    private String messageDev;

    @Value("${prod.message}")
    private String messageProd;

    public AppController(ApplicationPropertiesConfiguration appProperties) {
        this.appProperties = appProperties;
    }

    @RequestMapping("/")
    public String hello() {
        return "Using [" + appProperties.getFoo() + "] from config server";
    }

    @RequestMapping("/dev")
    public String helloDev() {
        return messageDev;
    }

    @RequestMapping("/prod")
    public String helloProd() {
        return messageProd;
    }
}
