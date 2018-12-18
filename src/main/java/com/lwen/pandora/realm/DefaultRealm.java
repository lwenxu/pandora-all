package com.lwen.pandora.realm;

import com.lwen.pandora.dao.UserRepository;
import com.lwen.pandora.entity.FunctionPoint;
import com.lwen.pandora.entity.Role;
import com.lwen.pandora.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultRealm extends AuthorizingRealm {
    @Autowired
    UserRepository userRepository;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = userRepository.findUserByUsername(username);
        List<String> roles = user.getRole()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList());
        List<String> permissions = user.getRole()
                .stream()
                .map(Role::getFunctionPoints)
                .map(functionPoints -> functionPoints.stream().map(FunctionPoint::getName).collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        User user = userRepository.findUserByUsername((String) authenticationToken.getPrincipal());
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName());
        return authenticationInfo;
    }
}
