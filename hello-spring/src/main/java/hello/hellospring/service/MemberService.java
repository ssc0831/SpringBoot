package hello.hellospring.service;

import org.springframework.stereotype.Service;

import hello.hellospring.model.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(String name) {
        Member member = new Member();
        member.setName(name);
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
