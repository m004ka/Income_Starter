package org.m004ka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "loan")
@Data
public class IncomeProperties {
    private String link;
}
