package com.example.demo.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.demo.model.Member;

@Mapper
public interface MemberMapper {
@Select("select * from userdb.member  ")
	List<Member> findAll();
@Insert("INSERT INTO userdb.member(id,name,pwd,email,birth)VALUES(null,#{name},#{pwd},#{email},#{birth})")
//@SelectKey(statement=" SELECT LAST_INSERT_ID()", keyProperty="id",before=false,resultType = Integer.class)
void insert(Member member) ;
	
	

}
