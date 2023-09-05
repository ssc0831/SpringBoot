package com.example.android.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.android.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone,Long>{

}
