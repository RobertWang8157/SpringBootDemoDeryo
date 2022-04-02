package com.example.demo.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.model.Member;

@Service
//@Component
//@EnableTransactionManagement
//@Transactional(readOnly =false)

public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public Member save(Member member) {

		return memberRepository.save(member);
	}
@Transactional//(readOnly =false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
//@Transactional(rollbackFor=Exception.class) //指定回滚,遇到异常Exception时回滚

//	@Transactional(isolation = Isolation.SERIALIZABLE)
	public List<Member> saveAll(List<Member> members) throws Exception {
		List<Member> insMember = memberRepository.saveAll(members);
//		if (true) {
////			throw new MyException("FAIL!!!!");
//			throw new Exception("FAIL!!!!");
//		}
		System.out.println("is transaction open? "+TransactionSynchronizationManager.isActualTransactionActive());
		if(true) {
			throw new Exception();
		}
		System.out.println("is transaction open? "+TransactionSynchronizationManager.isActualTransactionActive());

		return insMember;
	}
	@Transactional
	public List<Member> getMembers() {
//		List<Member> members = new ArrayList<Member>();
//		members.add(new Member("test", "test", "test", LocalDate.of(1987, Month.APRIL, 13), "test"));
//		return members;
		return memberRepository.findAll();
	}

	public Member findByMemberName(String name) {

		return memberRepository.findByName(name);

	}
//	@CustomAnnotation
	public Member findById(int id) {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(id);
		return memberRepository.findAllById(ids).size() >= 1 ? memberRepository.findAllById(ids).get(0) : null;

	}
}
