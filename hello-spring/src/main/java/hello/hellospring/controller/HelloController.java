package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.hellospring.service.MemberService;

@Controller
public class HelloController {
    private final MemberService memberService;

    public HelloController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/members")
    public String createMember(@RequestParam String name) {
        memberService.createMember(name);
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String getAllMembers(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "members";
    }
}
