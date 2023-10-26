package com.example.oceandb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.oceandb.model.Ocean;
import com.example.oceandb.repository.OceanDB_Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OceanDB_Service {
	private final OceanDB_Repository oceanDB_Repository;
	
	// Insert
	public Ocean insert(Ocean ocean) {
		return oceanDB_Repository.save(ocean);
	}

	// list
	public List<Ocean> list(){
		return oceanDB_Repository.findAll();
	}
	
	// Delete
	public void delete(Long num) {
		oceanDB_Repository.deleteById(num);
	}
	
}
