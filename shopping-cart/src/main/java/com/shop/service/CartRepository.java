package com.shop.service;

import java.util.function.Consumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.model.Item;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface CartRepository extends JpaRepository<Item, Integer> {
	
	public Item findById(int id);

	@Modifying
	@Query("delete from Item i where i.id = ?1")
	public void deleteById(int id);
}
