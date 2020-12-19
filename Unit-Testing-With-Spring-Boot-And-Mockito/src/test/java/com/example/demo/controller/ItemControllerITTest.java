package com.example.demo.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerITTest {

	@Autowired
	private TestRestTemplate template;

	@Test
	public void contextLoads() throws JSONException {

		String response = this.template.getForObject("/all-items", String.class);
		JSONAssert.assertEquals("[" + "{id:10001},{id:10002},{id:10003}" + "]", response, false);
	}
}
