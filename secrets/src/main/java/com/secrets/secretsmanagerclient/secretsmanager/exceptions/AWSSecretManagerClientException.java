package com.secrets.secretsmanagerclient.secretsmanager.exceptions;

public class AWSSecretManagerClientException extends RuntimeException {
    private static final String MESSAGE = "error when getting aws secrets client: ";

    public AWSSecretManagerClientException(Exception e) {
        super(MESSAGE + e);
    }
}