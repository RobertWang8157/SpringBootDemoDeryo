package com.example.demo.memberDetail;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.MemberService;
import com.example.demo.model.Member;
import com.example.demo.model.MemberDetail;

@RestController
@RequestMapping(path = "memberDetail")

public class MemberDetailController {
	
	private final MemberDetailService memberDetailService;

	public MemberDetailController(MemberDetailService memberDetailService) {
		this.memberDetailService=memberDetailService;
	}

	@RequestMapping(value = "/getall")
//	@GetMapping("getAll")
	public List<MemberDetail> getMember() {
//		return memberService.getMembers();
//		logger.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		return memberDao.getMember();

		return memberDetailService.geAlltMemberDetails();
	}
}
