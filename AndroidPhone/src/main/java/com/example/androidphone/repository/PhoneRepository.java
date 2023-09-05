package com.example.androidphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.androidphone.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone,Long>{

}
