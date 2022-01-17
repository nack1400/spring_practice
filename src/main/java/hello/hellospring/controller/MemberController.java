package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

  private final MemberService memberService;

  //@Autowired = 스프링 컨테이너에 있는 빈과 연결을 시켜줌
  //그러나 memberService가 스프링 빈으로 등록되어 있지 않음
  //그래서 @Service @Repository 등의 애노테이션을 설정해줌
  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

}
