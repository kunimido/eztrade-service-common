package com.github.kunimido.eztrade.service.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfiguration {
    @Bean
    public Docket embeddedServletContainerFactory() {
        final Docket result = new Docket(DocumentationType.SWAGGER_2);
        return result;
    }
}