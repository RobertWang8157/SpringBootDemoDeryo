package com.example.demo.junit;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.MemberController;
import com.example.demo.member.MemberService;
import com.example.demo.model.Member;

@SpringBootTest
public class SpringUnitTest {
	
//	@Autowired
//	private MemberService memeberService;
	@Autowired
	private MemberController memberController;
	@Test
	public void test() {
		
		List<Member> memberList=	memberController.getMember();
		
		for(Member memeber:memberList) {
			System.out.println("*****************");
			System.out.println(memeber.getName());
		}
		
	}

}
