package com.lwen.pandora;

import com.lwen.pandora.constant.StatusConstant;
import com.lwen.pandora.dao.FunctionPointRepository;
import com.lwen.pandora.dao.UserRepository;
import com.lwen.pandora.entity.FunctionPoint;
import com.lwen.pandora.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PandoraApplicationTests {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FunctionPointRepository functionPointRepository;

    @Test
    public void contextLoads() {
        System.out.println(userRepository.getOne(1));
    }

    @Test
    public void testPermission() {
        HashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        functionPointRepository.findAllByStatus(StatusConstant.NORMAL).stream()
                .map(functionPoint -> functionPoint.getRole().stream().map(Role::getName).collect(Collectors.toList()).toString())
                .forEach(System.out::println);
        System.out.println(filterChainDefinitionMap);
    }

}

