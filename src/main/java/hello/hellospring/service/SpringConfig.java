package hello.hellospring.service;

import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

   /* private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
*/
    //Jpa 연결로 변경
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //Jdbc 연결로 변경
        //return new JdbcMemberRepository(dataSource);
        //JdbcTemplate 연결로 변경
        //return new JdbcTemplateMemberRepository(dataSource);
        //Jpa 연결로 변경
        return new JpaMemberRepository(em);
    }
}
