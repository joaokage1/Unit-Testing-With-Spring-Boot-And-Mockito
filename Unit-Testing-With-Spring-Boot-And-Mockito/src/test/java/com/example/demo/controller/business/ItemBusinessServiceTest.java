package com.example.demo.controller.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.data.ItemRepository;
import com.example.demo.model.Item;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

	@InjectMocks
	ItemBusinessService service;

	@Mock
	ItemRepository repository;

	@Test
	public void findAllTest() {
		when(this.repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Couch", 20.0, 50)));

		List<Item> items = this.service.retrieveAllItems();
		assertEquals(1, items.size());
		assertEquals(1000, items.get(0).getValue());
	}

}
