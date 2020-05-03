package com.application.start.config.cors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${angular.url}")
    private String originURL;
    private Logger appLogs=Logger.getLogger(getClass().getName());

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        appLogs.info("Allow Origin: "+originURL);
        registry.addMapping("/**")
                .allowedOrigins(originURL)
                .allowedMethods("GET","PUT","POST","DELETE");
    }
}
