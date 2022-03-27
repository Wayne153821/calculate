package com.size.entity;

public class Grade {
	private Integer id;
	private Integer score;
	private String time;
	public Grade() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Grade(Integer score, String time) {
		super();
		this.score = score;
		this.time = time;
	}
	public Grade(Integer id, Integer score, String time) {
		super();
		this.id = id;
		this.score = score;
		this.time = time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getTime() {
		return time;
	}
	public void setITime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Grade [id=" + id + ", 成绩：" + score + ", 做题时间：" + time + "]";
	}
	
}
