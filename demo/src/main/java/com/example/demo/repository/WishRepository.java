package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Wish;

public interface WishRepository extends JpaRepository<Wish,Integer>{

}
