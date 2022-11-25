package com.gitlab.nadiatrf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.gitlab.nadiatrf")
@EnableWebMvc
public class AppConfig {
}
