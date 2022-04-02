package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hibernate.MemberDao;
import com.example.demo.jwt.AuthenticationRequest;
import com.example.demo.jwt.AuthenticationResponse;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.member.MemberService;
import com.example.demo.model.Member;
import com.example.demo.model.MemberDetail;
import com.example.demo.mybatis.MemberMapper;

@RestController
//@EnableTransactionManagement

@RequestMapping(path = "member")
public class MemberController {
	private final MemberService memberService;
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
//	@Autowired
	@Resource
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

//	@Autowired
	public MemberController(MemberService memberService, MemberMapper memberMapper) {
		this.memberService = memberService;
		this.memberMapper = memberMapper;

	}

//	public MemberController(MemberMapper memberMapper) {
//		this.memberService = new MemberService();
//		this.memberMapper = memberMapper;
//	}
	private MemberMapper memberMapper;
	@Autowired
	public MemberDao memberDao;
	@Transactional
	@RequestMapping(value = "/getall")
//	@GetMapping("getAll")
	public List<Member> getMember() {
		//return memberService.getMembers();
	logger.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	return memberDao.getMember();
		//return null;

//		return memberMapper.findAll();
	}

//	@PostMapping("add")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<Member> add(@RequestBody List<Member> members) throws Exception {
		
		for(Member member:members) {
			
			for(MemberDetail detail:member.getDetailFromMember()) {
				detail.setDetailFromMember(member);				
			}
		}
		return memberService.saveAll(members);
//		memberMapper.insert(members.get(0));
//		return memberMapper.findAll();
	}

//	@GetMapping("get/{id}")
	@RequestMapping(value = "/get/{id}")

	public Member getById(@PathVariable("id") int id) {

		return Optional.ofNullable(memberService.findById(id)).orElseThrow();
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationManager(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Incorrect username and password!");
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
