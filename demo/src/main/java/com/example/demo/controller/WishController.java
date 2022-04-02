package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Wish;
import com.example.demo.service.WishService;

@RestController
@RequestMapping(path = "wish")
public class WishController {
	private Logger logger = LoggerFactory.getLogger(WishController.class);
	private final WishService wishService;
	public WishController(WishService wishService) {
		this.wishService = wishService;

	}
	@RequestMapping(value = "/getAll")
	public List<Wish> getAll() throws Exception {		
		return wishService.getAll();

	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<Wish> add(@RequestBody List<Wish> wishes) throws Exception {	
		return wishService.saveAll(wishes);

	}
}
