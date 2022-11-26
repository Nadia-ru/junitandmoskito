package com.gitlab.nadiatrf;

import com.gitlab.nadiatrf.config.WebAppInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

public class Application {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Application.class);

        logger.info("Info Message Logged !!!");
    }
}
