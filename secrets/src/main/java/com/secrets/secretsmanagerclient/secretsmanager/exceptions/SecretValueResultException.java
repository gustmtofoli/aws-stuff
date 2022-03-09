package com.secrets.secretsmanagerclient.secretsmanager.exceptions;

public class SecretValueResultException extends RuntimeException {
    private static final String MESSAGE = "Error when getting secret ";

    public SecretValueResultException(String secretName, Exception e) {
        super(MESSAGE + "[" + secretName + "]: " + e);
    }
}
