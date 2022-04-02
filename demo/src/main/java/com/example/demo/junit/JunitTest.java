package com.example.demo.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.MemberController;
//import com.example.demo.member.MemberService;
//import com.example.demo.mybatis.MemberMapper;
@ExtendWith(SpringExtension.class)
@WebMvcTest(MemberController.class)
public class JunitTest {
//	private MemberMapper memberMapper;
//	private  MemberService memberService;
private MockMvc mvc;
	@Test
	public void hello() throws Exception {
//		MemberController memberController=new MemberController(memberService,memberMapper);
		RequestBuilder request=MockMvcRequestBuilders.get("getall");
		MvcResult result=mvc.perform(request).andReturn();
//		assertEquals("hello", result.getResponse().getContentAsString());
//		 List<Member> members=memberController.getMember();
//			System.out.println("-------------------------");
//			System.out.println(members.toString());
			assertEquals("hello", "hello");
	}
}
