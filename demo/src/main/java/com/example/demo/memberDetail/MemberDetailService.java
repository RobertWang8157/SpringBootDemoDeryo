package com.example.demo.memberDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MemberDetail;

@Service
public class MemberDetailService {
	@Autowired
	private MemberDetailRepository memberDetailRepository;
	
	public List<MemberDetail> geAlltMemberDetails() {

		return memberDetailRepository.findAll();
	}
}
