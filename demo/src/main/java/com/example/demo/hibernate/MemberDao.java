package com.example.demo.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Member;

@Repository
@Transactional
public class MemberDao {
	@Autowired
	private SessionFactory factory;

	
	public void saveMember(Member member) {
		getSession().save(member);
	}
	
	@SuppressWarnings("deprecation")
	public List<Member> getMember(){
		
		return getSession().createCriteria(Member.class).list();
	}
	private Session getSession() {
		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}
		return session;

	}
}
