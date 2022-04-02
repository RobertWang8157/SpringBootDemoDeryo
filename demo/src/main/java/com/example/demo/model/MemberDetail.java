package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "member_detail")
public class MemberDetail {
	@Id
	@GeneratedValue
	private int id;
//	@Column(name = "member_id")
////	@ManyToOne(fetch = FetchType.LAZY)
//	private int memberId;
	@Column(name = "event_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date eventDate;
	@Column(name = "warmup_s")
	private int warmupS;
	@Column(name = "work_s")
	private int workS;
	@Column(name = "break_s")
	private int breakS;
	@Column(name = "ready_s")
	private int readyS;
	@Column(name = "remain_s")
	private int remainS;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MEMBER_ID")
	private Member detailFromMember;
	
	public MemberDetail() {}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int getMemberId() {
//		return memberId;
//	}
//
//	public void setMemberId(int memberId) {
//		this.memberId = memberId;
//	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public int getWarmupS() {
		return warmupS;
	}

	public void setWarmupS(int warmupS) {
		this.warmupS = warmupS;
	}

	public int getWorkS() {
		return workS;
	}

	public void setWorkS(int workS) {
		this.workS = workS;
	}

	public int getBreakS() {
		return breakS;
	}

	public void setBreakS(int breakS) {
		this.breakS = breakS;
	}

	public int getReadyS() {
		return readyS;
	}

	public void setReadyS(int readyS) {
		this.readyS = readyS;
	}

	public int getRemainS() {
		return remainS;
	}

	public void setRemainS(int remainS) {
		this.remainS = remainS;
	}


	public Member getDetailFromMember() {
		return detailFromMember;
	}

	public void setDetailFromMember(Member detailFromMember) {
		this.detailFromMember = detailFromMember;
	}

//	@Override
//	public String toString() {
//		return "MemberDetail [id=" + id + ", memberId=" + memberId + ", eventDate=" + eventDate + ", warmupS=" + warmupS
//				+ ", workS=" + workS + ", breakS=" + breakS + ", readyS=" + readyS + ", remainS=" + remainS + "]";
//	}

}
