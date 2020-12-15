package com.example.demo.controller.business;

import org.springframework.stereotype.Component;

import com.example.demo.model.Item;

@Component("itemBusinessService")
public class ItemBusinessService {

	public Item retrieveHardCodedItem() {
		return new Item(2, "Couch", 20.0, 50);
	}

}
