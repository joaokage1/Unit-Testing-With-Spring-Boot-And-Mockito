package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void dummyItemBasicTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = this.mockMvc.perform(requestBuilder).andExpect(status().is(200))
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10.0,\"quantity\":100}")).andReturn();

		JSONAssert.assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10.0,\"quantity\":100}",
				result.getResponse().getContentAsString(), false);
	}

}
