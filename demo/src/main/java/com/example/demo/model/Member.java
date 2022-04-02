package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
@ToString
public class Member {
	@Id
//	@SequenceGenerator(
//			name="member_sequence",
//			sequenceName="member_sequence",
//			allocationSize=1
//			)
	@GeneratedValue
//	(
//			strategy=GenerationType.SEQUENCE,
//			generator="member_sequence"
//			)

	private int id;
	private String name;
	private String pwd;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birth;
	private String email;
//	@OneToMany(targetEntity = MemberDetail.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "member_id", referencedColumnName = "id")
//	@JoinTable(name = "member_detail", joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id")
//	,inverseJoinColumns =  @JoinColumn(name = "member_id"))
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cashdropConfMasterFromRank", cascade = { CascadeType.MERGE,
//			CascadeType.PERSIST, CascadeType.REMOVE })
//	@OrderBy("id ASC")
//	private List<MemberDetail> memberDetail;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "detailFromMember", cascade = { CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REMOVE })
//	@JoinColumn(name = "member",referencedColumnName="id")
	
//	@OneToMany(mappedBy="id", 
//    cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
	@OrderBy("id ASC")
//	@JsonIgnore
	private List<MemberDetail> detailFromMember=new ArrayList<>();

	public Member() {
	}

	public Member(String name, String pwd, int id, Date birth, String email) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.id = id;
		this.birth = birth;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
	}



	public List<MemberDetail> getDetailFromMember() {
		return detailFromMember;
	}

	public void setDetailFromMember(List<MemberDetail> detailFromMember) {
		this.detailFromMember = detailFromMember;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", pwd=" + pwd + ", birth=" + birth + ", email=" + email + "]";
	}

}
