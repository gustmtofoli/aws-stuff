package secretsmanager;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SecretsManager {
	
	public SecretsManager() {}
	
	public HashMap<String, String> getSecretAsHashMap(String secretName) throws JsonMappingException, JsonProcessingException {
		return new ObjectMapper().readValue(getSecretValueResult(secretName).getSecretString(), HashMap.class);
	}
	
	public String getSecretAsString(String secretName) {
		return getSecretValueResult(secretName).getSecretString();
	}
	
	private GetSecretValueResult getSecretValueResult(String secretName) {
		return getClient().getSecretValue(new GetSecretValueRequest().withSecretId(secretName));
	}
	
	private AWSSecretsManager getClient() {
		return AWSSecretsManagerClientBuilder.standard().build();
	}

}
