package com.lwen.pandora.service.impl;

import com.lwen.pandora.exception.InvalidParamsException;
import com.lwen.pandora.service.PasswordAuthenticationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConditionalOnProperty(prefix = "pandora.user", name = "encryptType", value = "HASH")
public class MD5PasswordAuthenticationServiceImpl implements PasswordAuthenticationService {

    @Override
    public String passwordEncrypt(String password, Map<String, String> options) throws InvalidParamsException {
        if (!options.containsKey("salt")) {
            throw new InvalidParamsException();
        }
        return password;
    }
}
