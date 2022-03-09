package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.secrets.secretsmanagerclient.secretsmanager.SecretsManager;

@RestController
@RequestMapping(path="/demo", produces=MediaType.APPLICATION_JSON_VALUE)
public class DemoController {
	
	@RequestMapping(method = RequestMethod.GET, path="/getsecret")
	public void demoTest() throws JsonMappingException, JsonProcessingException {
		SecretsManager secretsManager = new SecretsManager();
		secretsManager.getSecretAsHashMap("test");
	}

}
