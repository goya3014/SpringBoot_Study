package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //나머지 메서드는 JpaRepository가 자동으로 생성. findByName은 여기에 선언하여 JPQL이 자동으로 만들어줌.
    //JPQL : Select m from member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
