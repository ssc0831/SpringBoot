package hello.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 추가적인 회원 관련 메서드를 선언할 수 있음
}
