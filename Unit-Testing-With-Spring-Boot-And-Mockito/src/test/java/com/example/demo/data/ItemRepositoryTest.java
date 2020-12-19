package com.example.demo.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Item;

@DataJpaTest
class ItemRepositoryTest {

	@Autowired
	ItemRepository repository;

	@Test
	void findAlltest() {
		List<Item> items = this.repository.findAll();
		assertEquals(3, items.size());
	}

}
