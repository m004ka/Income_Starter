package org.example.config;

import org.example.service.IncomeService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(IncomeProperties.class)
public class IncomeServiceAutoConfiguration {

    @Bean
    @ConditionalOnBean
    public IncomeService incomeService(IncomeProperties properties) {
        return new IncomeService(properties.getLink());
    }

}
