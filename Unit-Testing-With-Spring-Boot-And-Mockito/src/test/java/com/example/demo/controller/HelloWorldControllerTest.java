package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloWorldBasicTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello-world")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult response = this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals("Hello World", response.getResponse().getContentAsString());

	}

}
