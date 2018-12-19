package com.lwen.pandora.controller;

import com.lwen.pandora.exception.UnauthorizedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @GetMapping("/unauthorized")
    public void unauthorized() {
        throw new UnauthorizedException();
    }

}
