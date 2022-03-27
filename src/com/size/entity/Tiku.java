package com.size.entity;

public class Tiku {
	private Integer id;
	private String problem;
	private Integer answer;
	public Tiku() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public Tiku(Integer answer) {
		super();
		this.answer = answer;
	}

	public Tiku(String problem) {
		super();
		this.problem = problem;
	}

	public Tiku(String problem, Integer answer) {
		super();
		this.problem = problem;
		this.answer = answer;
	}

	public Tiku(Integer id, String problem, Integer answer) {
		super();
		this.id = id;
		this.problem = problem;
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Integer getAnswer() {
		return answer;
	}

	public void setAnswer(Integer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Math [id=" + id + ", problem=" + problem + ", answer=" + answer + "]";
	}
	
	
	
}
