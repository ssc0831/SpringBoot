package com.example.demo01.controller;

import javax.servlet.http.HttpSession;

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

import com.example.demo01.dto.BoardDTO;
import com.example.demo01.dto.MemberDTO;
import com.example.demo01.service.BoardService;
import com.example.demo01.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	private BoardService bservice;
	@Autowired
	private MemberService mservice;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}

	@PostMapping("/insert")
	public String insert(BoardDTO board) {
		bservice.insert(board);
		return "redirect:list";
	}
	@GetMapping("/list")
	public String list(Model  model) {
		model.addAttribute("boards", bservice.list());
		model.addAttribute("count", bservice.getCount());
		return "list";
	}
	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model  model) {
		model.addAttribute("board", bservice.findByNum(num));
	
		return "view";
	}
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public int delete(@PathVariable int num) {
		bservice.delete(num);
		return num;
	}
	//수정폼
	@GetMapping("update/{num}")
    public String update(@PathVariable int num, Model model) {
		model.addAttribute("board", bservice.findByNum(num));
		return "update";
	}
	//수정
	@PutMapping("update")
	@ResponseBody
	public int update(@RequestBody BoardDTO board) {
		 bservice.update(board);
		return board.getNum();
	}
	@GetMapping("join")
	public void join() {

	}
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestBody MemberDTO member) {
		//id 존재 유효성 검사
		int cnt = mservice.idCheck(member.getId());
		if(cnt!=0) return "fail";
		mservice.join(member);
		return "success";
	}
	
	//로그인 폼
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	//로그인
	@PostMapping("login")
	@ResponseBody
	public String login(@RequestBody MemberDTO member, HttpSession session) {
	 MemberDTO m = mservice.loginCheck(member.getId());
	 if (m==null) { // 회원이 아님
		return "no";
	}if (m.getPass().equals(member.getPass())) {// 회원 맞음(비번 맞음)
		session.setAttribute("sMember", m);
		return "success";
	}else {// 비번 오류
		return "error";
	}
}
	// loginSubmit
	@PostMapping("loginSubmit")
	public String loginSubmit(MemberDTO member, HttpSession session) {
		MemberDTO m = mservice.loginCheck(member.getId());
		if (m==null) { // 회원이 아님
			return "no";
		}if (m.getPass().equals(member.getPass())) {// 회원 맞음(비번 맞음)
			return "success";
		}else {// 비번 오류
			return "error";
		}
	}
	
	// 로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "member/login";
	}
}
