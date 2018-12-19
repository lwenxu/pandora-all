package com.lwen.pandora.config;

import com.lwen.pandora.constant.StatusConstant;
import com.lwen.pandora.dao.FunctionPointRepository;
import com.lwen.pandora.entity.FunctionPoint;
import com.lwen.pandora.entity.Role;
import com.lwen.pandora.realm.DefaultRealm;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class ShiroConfig {

    @Autowired
    FunctionPointRepository functionPointRepository;
    @Autowired
    UserConfig userConfig;
    @Autowired
    DevConfig devConfig;

    /**
     * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
     * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
     * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * Hash加密函数，主要设置加密方式以及加密的次数等
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        String encryptTypeConfig = userConfig.getEncryptType();
        String encryptType = StringUtils.isNoneEmpty(encryptTypeConfig) ? encryptTypeConfig : "MD5";
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher(encryptType);
        hashedCredentialsMatcher.setHashIterations(20);
        return hashedCredentialsMatcher;
    }

    /**
     * defaultRealm，这是个自定义的认证类，继承自AuthorizingRealm，
     * 负责用户的认证和权限的处理，可以参考JdbcRealm的实现。
     * @return
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public Realm defaultRealm() {
        DefaultRealm realm = new DefaultRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //cookie对象;
    @Bean
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    //cookie管理对象;
    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCookie(rememberMeCookie());
        return manager;
    }

    /**
     * SecurityManager，权限管理，这个类组合了登陆，登出，权限，session的处理。
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(defaultRealm());
        return defaultWebSecurityManager;
    }

    /**
     * ShiroFilterFactoryBean，是个factorybean，为了生成ShiroFilter。
     * 它主要保持了三项数据，securityManager，filters，filterChainDefinitionManager。
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        List<FunctionPoint> functionPoints = functionPointRepository.findAllByStatus(StatusConstant.NORMAL);
        if (devConfig.getAppDebug() || devConfig.getShowApi()) {
            filterChainDefinitionMap.put("/", "anon");
            filterChainDefinitionMap.put("/api/v1/", "anon");
        }
        // find in db and insert maps
//        functionPoints.stream()
//                .map(functionPoint ->
//                        filterChainDefinitionMap.put(functionPoint.getUrl(),
//                                "roles[" + functionPoint.getRole().stream().map(Role::getName).collect(Collectors.toList()).toString()) + "]");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "authc");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/api/v1");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
