package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({"org.example"})  // 会实例化两个 UserController
@ComponentScan({"org.example.dao", "org.example.service"})
public class SpringConfig {
}
