package com.example.demo03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo03.model.JpaMember;

public interface MemberRepository extends JpaRepository<JpaMember, Long> {

}
