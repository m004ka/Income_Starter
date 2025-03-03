package org.m004ka.config;

import org.m004ka.service.IncomeService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(IncomeProperties.class)
public class IncomeServiceAutoConfiguration {

    @Bean
    public IncomeService incomeService(IncomeProperties properties) {
        return new IncomeService(properties.getLink());
    }

}
