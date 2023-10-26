package com.example.oceandb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oceandb.model.Ocean;

public interface OceanDB_Repository
	extends JpaRepository<Ocean, Long> {

}
