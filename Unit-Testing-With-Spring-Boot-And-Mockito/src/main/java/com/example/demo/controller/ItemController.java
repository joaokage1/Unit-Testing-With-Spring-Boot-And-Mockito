package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;

@RestController
public class ItemController {

	@GetMapping("/dummy-item")
	public Item dummyData() {
		return new Item(1, "Ball", 10.0, 100);
	}
}
