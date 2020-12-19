package com.example.demo.controller.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.data.ItemRepository;
import com.example.demo.model.Item;

@Component("itemBusinessService")
public class ItemBusinessService {

	@Autowired
	private ItemRepository repository;

	public Item retrieveHardCodedItem() {
		return new Item(2, "Couch", 20.0, 50);
	}

	public List<Item> retrieveAllItems() {
		List<Item> items = this.repository.findAll();
		for (Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}

}
