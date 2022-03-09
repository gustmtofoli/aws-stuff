package com.secrets.secretsmanagerclient.configuration;

import com.secrets.secretsmanagerclient.secretsmanager.SecretsManager;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackageClasses = SecretsManager.class)
@Configuration
@PropertySource(value = "classpath:secretslib-application.yaml", factory = YamlPropertySourceFactory.class)
public class SecretsManagerClientConfiguration {
}
