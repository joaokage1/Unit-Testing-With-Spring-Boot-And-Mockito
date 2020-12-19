package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.business.ItemBusinessService;
import com.example.demo.model.Item;

@RestController
public class ItemController {

	@Autowired
	ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item dummyData() {
		return new Item(2, "Couch", 20.0, 50);
	}

	@GetMapping("/dummy-item-from-business-service")
	public Item dummyDataFromService() {
		return this.businessService.retrieveHardCodedItem();
	}

	@GetMapping("/all-items")
	public List<Item> retrieveAllItems() {
		return this.businessService.retrieveAllItems();
	}
}
