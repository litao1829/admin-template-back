package com.litao.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码加密配置，没有直接指定具体的加密算法（如：new BCryptPasswordEncoder()）
 * 而是通过 PasswordEncoderFactories.createDelegatingPasswordEncoder()创建
 * createDelegatingPasswordEncoder 是 SpringSecurity 默认支持的加密算法
 * 加密后的格式为：{encodingId}password
 * 其中，encodingId 为对应的加密算法，默认使用的是 BCryptPasswordEncoder 加密算法
 *
 * @author mqxu
 */
@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

