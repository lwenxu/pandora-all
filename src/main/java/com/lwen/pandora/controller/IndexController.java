package com.lwen.pandora.controller;

import com.lwen.pandora.dao.UserRepository;
import com.lwen.pandora.entity.User;
import com.lwen.pandora.enums.ResultVOEnum;
import com.lwen.pandora.util.ResultVOUtils;
import com.lwen.pandora.vo.ResultVO;
import com.lwen.pandora.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> user() {
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public ResultVO login(UserVO user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        if (!subject.isAuthenticated()){
            try {
                subject.login(usernamePasswordToken);
            } catch (UnknownAccountException | IncorrectCredentialsException e) {
                return ResultVOUtils.failed(ResultVOEnum.USERNAME_PASSWORD_AUTH_ERROR);
            } catch (ExpiredCredentialsException e) {
                return ResultVOUtils.failed(ResultVOEnum.AUTH_EXPIRED_ERROR);
            } catch (DisabledAccountException e) {
                return ResultVOUtils.failed(ResultVOEnum.USER_LOCKED_ERROR);
            } catch (AuthenticationException e) {
                return ResultVOUtils.failed(ResultVOEnum.LOGIN_ERROR);
            }
        }
        return ResultVOUtils.success();
    }
}
