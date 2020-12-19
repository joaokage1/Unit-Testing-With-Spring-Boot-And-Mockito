package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.business.ItemBusinessService;
import com.example.demo.model.Item;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	private static final String OBJECT_TO_RETURN = "{\"id\":2,\"name\":\"Couch\",\"price\":20.0,\"quantity\":50}";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemBusinessService service;

	@Test
	void dummyItemBasicTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = this.mockMvc.perform(requestBuilder).andExpect(status().is(200))
				.andExpect(content().json(OBJECT_TO_RETURN)).andReturn();

		JSONAssert.assertEquals(OBJECT_TO_RETURN, result.getResponse().getContentAsString(), false);
	}

	@Test
	void dummyItemFromBusinessTest() throws Exception {

		when(this.service.retrieveHardCodedItem()).thenReturn(new Item(2, "Couch", 20.0, 50));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item-from-business-service")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = this.mockMvc.perform(requestBuilder).andExpect(status().is(200))
				.andExpect(content().json(OBJECT_TO_RETURN)).andReturn();

		JSONAssert.assertEquals(OBJECT_TO_RETURN, result.getResponse().getContentAsString(), false);
	}

	@Test
	void retrieveAllitemsTest() throws Exception {
		ArrayList<Item> allItems = new ArrayList<>();
		allItems.add(new Item(2, "Couch", 20.0, 50));
		when(this.service.retrieveAllItems()).thenReturn(allItems);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/all-items")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = this.mockMvc.perform(requestBuilder).andExpect(status().is(200))
				.andExpect(content().json("[" + OBJECT_TO_RETURN + "]")).andReturn();

		JSONAssert.assertEquals("[" + OBJECT_TO_RETURN + "]", result.getResponse().getContentAsString(), false);
	}

}
