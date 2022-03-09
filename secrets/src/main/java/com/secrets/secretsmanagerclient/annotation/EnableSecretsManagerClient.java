package com.secrets.secretsmanagerclient.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.secrets.secretsmanagerclient.configuration.SecretsManagerClientConfiguration;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(SecretsManagerClientConfiguration.class)
public @interface EnableSecretsManagerClient {}
