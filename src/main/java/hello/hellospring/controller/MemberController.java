package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    //GetMapping: 주소창에 입력하여 들어옴. 주로 조회시 사용.
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    //PostMapping : data를 전달할 때 사용
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        System.out.println("member:: " + member.getName());
        memberService.join(member);
        return "redirect:/";
    }
}
