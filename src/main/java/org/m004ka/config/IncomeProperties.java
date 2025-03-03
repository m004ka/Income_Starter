package org.example.config;

import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("loan")
@Data
public class IncomeProperties {
    private String link;
}
