package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.model.Wish;
import com.example.demo.repository.WishRepository;

@Service
public class WishService {
	@Autowired
	private WishRepository wishRepository;

	public Wish save(Wish wish) {
		return wishRepository.save(wish);
	}

	public List<Wish> saveAll(List<Wish> wishes) throws Exception {
		List<Wish> insWish = wishRepository.saveAll(wishes);
		return insWish;
	}
	
	public List<Wish> getAll() {
		return wishRepository.findAll();
	}
}
