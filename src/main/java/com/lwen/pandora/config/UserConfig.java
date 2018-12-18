package com.lwen.pandora.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
@ConfigurationProperties("pandora.user")
@Data
public class UserConfig implements Serializable {
    private String encryptType;
}
