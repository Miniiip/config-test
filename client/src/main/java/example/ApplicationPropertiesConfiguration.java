package example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("config-client-test")
@RefreshScope
public class ApplicationPropertiesConfiguration
{
    private String foo;

//    private List<Long> someList;

    public String getFoo()
    {
        return foo;
    }

    public void setFoo(String foo)
    {
        this.foo = foo;
    }

//    public List<Long> getSomeList() {
//        return someList;
//    }
//
//    public void setSomeList(List<Long> someList) {
//        this.someList = someList;
//    }
}