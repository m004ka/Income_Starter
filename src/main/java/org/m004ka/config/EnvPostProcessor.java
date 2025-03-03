package org.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class EnvPostProcessor implements EnvironmentPostProcessor {
    private final YamlPropertySourceLoader propertySourceLoader;

    public EnvPostProcessor() {
        propertySourceLoader = new YamlPropertySourceLoader(); // Yaml..Loader зачитает для нас конфигурацию из default.yaml
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        var resource = new ClassPathResource("default.yaml"); // определяем default.yaml как локальный ресурс
        PropertySource<?> propertySource = null;
        try {

            propertySource = propertySourceLoader.load("loan", resource).get(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        environment.getPropertySources().addLast(propertySource);
    }
}