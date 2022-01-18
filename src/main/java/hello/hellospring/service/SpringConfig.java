package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

   /* private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
*/
    //Jpa 연결로 변경
/*    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    //스프링 데이터 JPA로 변경
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
/*
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/
    /*
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //Jdbc 연결로 변경
        //return new JdbcMemberRepository(dataSource);
        //JdbcTemplate 연결로 변경
        //return new JdbcTemplateMemberRepository(dataSource);
        //Jpa 연결로 변경
        return new JpaMemberRepository(em);
    }*/
}
