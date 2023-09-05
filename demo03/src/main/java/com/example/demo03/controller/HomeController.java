package com.example.demo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo03.model.JpaMember;
import com.example.demo03.repository.MemberRepository;
import com.example.demo03.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final MemberService memberService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	// Insert Form
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	// Insert
	@PostMapping("/join")
	public String join(JpaMember member) {
		memberService.insert(member);
		return "redirect:list";
	}
	
	// list
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("members", memberService.list());
		return "list";
	}
	
	// 상세보기
	@GetMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.view(id));
		return "view";
	}
	
	// 삭제
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public Long delete(@PathVariable Long id){
		memberService.delete(id);
		return id;
	}
	
	// 수정 폼
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model) {
	model.addAttribute("member", memberService.view(id));
	return "/update";
	}
	
	// 수정
	@PutMapping("/update")
	@ResponseBody
	public String update(@RequestBody JpaMember member) {
		System.out.println("id : "+member.getId());
		System.out.println("email : "+member.getEmail());
		System.out.println("addr : "+member.getAddr());
		System.out.println("memo : "+member.getMemo());
		memberService.update(member);
		return "success";
	}
	
}
