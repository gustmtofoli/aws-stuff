package com.secrets.secretsmanagerclient.secretsmanager.exceptions;

public class SecretValueResultNullException extends RuntimeException {
    private static final String MESSAGE = "secret value is null";

    public SecretValueResultNullException() {
        super(MESSAGE);
    }
}