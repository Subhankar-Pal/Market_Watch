package com.stocksearch.stocksearch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocksearch.stocksearch.entities.Admin;


@Repository
public interface LoginDao extends JpaRepository<Admin,Integer> { 
	Admin findByUsername(String username);
}
