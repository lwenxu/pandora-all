package com.lwen.pandora.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("pandora.dev")
@Data
public class DevConfig {
    /*开发阶段无需进行身份认证访问后台rest API*/
    private Boolean showApi = false;
    private Boolean appDebug = false;
}
