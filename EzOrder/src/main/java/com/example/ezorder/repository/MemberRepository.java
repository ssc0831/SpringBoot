package com.example.ezorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezorder.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByMemberName(String memberName);

}
