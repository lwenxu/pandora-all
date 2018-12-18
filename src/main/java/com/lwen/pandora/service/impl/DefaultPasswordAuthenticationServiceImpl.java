package com.lwen.pandora.service.impl;

import com.lwen.pandora.service.PasswordAuthenticationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConditionalOnMissingBean(PasswordAuthenticationService.class)
public class DefaultPasswordAuthenticationServiceImpl implements PasswordAuthenticationService {
    @Override
    public String passwordEncrypt(String password, Map<String, String> options) {
        return password;
    }
}
