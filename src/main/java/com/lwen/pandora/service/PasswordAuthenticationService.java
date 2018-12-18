package com.lwen.pandora.service;

import com.lwen.pandora.exception.InvalidParamsException;

import java.util.Map;

public interface PasswordAuthenticationService {
    String passwordEncrypt(String password, Map<String, String> options) throws InvalidParamsException;
}
