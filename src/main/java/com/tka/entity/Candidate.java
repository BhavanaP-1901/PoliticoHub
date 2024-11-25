package com.tka.entity;

public class Candidate {
	
	private int c_id;
	private String c_name;
	private String party;
	private String state;
	private String assembly;
	private String gender;
	private int age;
	
	public Candidate() {
		super();
	}

	public Candidate(int c_id, String c_name, String party, String state, String assembly, String gender, int age) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.party = party;
		this.state = state;
		this.assembly = assembly;
		this.gender = gender;
		this.age = age;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAssembly() {
		return assembly;
	}

	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Candidate [c_id=" + c_id + ", c_name=" + c_name + ", party=" + party + ", state=" + state
				+ ", assembly=" + assembly + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
	
}