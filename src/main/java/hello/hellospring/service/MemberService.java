package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    //현재 테스트 파일과 다른 객체를 쓰고 있으므로, 외부에서 받아온 객체를 사용하도록 수정.
    private final MemberRepository memberRepository; /*= new MemoryMemberRepository();*/

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*회원가입*/
    public Long join(Member member) {
            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /*전체회원조회*/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /*회원조회*/
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
