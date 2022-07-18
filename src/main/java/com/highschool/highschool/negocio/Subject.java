package com.highschool.highschool.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subject {
	
	private int pk_subject;
	private String name;
	
	List<Score> scores=new ArrayList<Score>();
	
	public Subject(int subject, String name) {
		super();
		this.pk_subject = subject;
		this.name = name;
	}
	
	
	public Subject(int pk_subject, String name, List<Score> scores) {
	    super();
	    this.pk_subject = pk_subject;
	    this.name = name;
	    this.scores = scores;
	}
	
	
	


	public Subject(int pk_subject) {
	    super();
	    this.pk_subject = pk_subject;
	}


	public Subject() {
	    super();
	}


	
	public int getPk_subject() {
	    return pk_subject;
	}


	public void setPk_subject(int pk_subject) {
	    this.pk_subject = pk_subject;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Score> getScores() {
	    return scores;
	}


	public void setScores(List<Score> scores) {
	    this.scores = scores;
	}


	@Override
	public int hashCode() {
		return Objects.hash(pk_subject);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return pk_subject == other.pk_subject;
	}
	@Override
	public String toString() {
		return "Subject [subject=" + pk_subject + ", name=" + name + "]";
	}
	
	

}
