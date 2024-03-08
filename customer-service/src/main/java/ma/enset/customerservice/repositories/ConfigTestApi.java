package ma.enset.customerservice.repositories;


import lombok.RequiredArgsConstructor;
import ma.enset.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/config")
@RequiredArgsConstructor
@RefreshScope
public class ConfigTestApi {
    @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p2}")
    private int p2;
    @Value("${customer.params.x}")
    private int x;
    @Value("${customer.params.y}")
    private int y;

    private final GlobalConfig globalConfig;
    @GetMapping()
    public Map<String, Integer> getConfigMap(){
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);
    }
    @GetMapping("global-config")
    public GlobalConfig getGlobalConfig(){
        return globalConfig;
    }
}
