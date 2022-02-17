package controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import secretsmanager.SecretsManager;

@RestController
@RequestMapping(path="/demo", produces=APPLICATION_JSON_VALUE)
public class DemoController {
	
	@RequestMapping(method = GET, path="/getsecret")
	public void demoTest() throws JsonMappingException, JsonProcessingException {
		SecretsManager secretsManager = new SecretsManager();
		secretsManager.getSecretAsHashMap("test");
	}

}
