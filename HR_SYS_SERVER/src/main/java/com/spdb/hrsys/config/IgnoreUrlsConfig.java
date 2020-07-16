package com.spdb.hrsys.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "security.ignored")
public class IgnoreUrlsConfig {
    private List<String> urls =new ArrayList<>();
}
