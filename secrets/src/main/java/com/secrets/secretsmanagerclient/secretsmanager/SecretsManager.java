package com.secrets.secretsmanagerclient.secretsmanager;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.secrets.secretsmanagerclient.secretsmanager.exceptions.AWSSecretManagerClientException;
import com.secrets.secretsmanagerclient.secretsmanager.exceptions.SecretValueResultException;
import com.secrets.secretsmanagerclient.secretsmanager.exceptions.SecretValueResultNullException;

@Component
@RequiredArgsConstructor
@Slf4j
public class SecretsManager {
	
	public HashMap<String, String> getSecretAsHashMap(String secretName) throws JsonMappingException, JsonProcessingException {
		return new ObjectMapper().readValue(getSecretValueResult(secretName).getSecretString(), HashMap.class);
	}
	
	public String getSecretAsString(String secretName) {
		return getSecretValueResult(secretName).getSecretString();
	}
	
	private GetSecretValueResult getSecretValueResult(String secretName) {
		AWSSecretsManager secretsManagerClient = getClient();
		GetSecretValueResult secretValueResult = null;
		try {
			secretValueResult = secretsManagerClient.getSecretValue(new GetSecretValueRequest().withSecretId(secretName));
		}
		catch (Exception e) {
			throw new SecretValueResultException(secretName, e);
		}
		return valueResultNotNull(secretValueResult);
	}

	private GetSecretValueResult valueResultNotNull(GetSecretValueResult valueResult) {
		if (valueResult == null)
			throw new SecretValueResultNullException();
		return valueResult;
	}

	private AWSSecretsManager getClient() {
		AWSSecretsManager client = null;
		try {
			client = AWSSecretsManagerClientBuilder.standard().build();
		}
		catch(Exception e) {
			throw new AWSSecretManagerClientException(e);
		}
		return client;
	}

}
