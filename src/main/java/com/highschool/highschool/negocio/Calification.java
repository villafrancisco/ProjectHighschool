package com.highschool.highschool.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calification {
	
	private int pk_grade;
	private String alias;
	
	List<Score> scores=new ArrayList<Score>();
	public Calification(int pk_grade, String alias) {
		super();
		this.pk_grade = pk_grade;
		this.alias = alias;
	}
	
	
	public Calification(int pk_grade, String alias, List<Score> scores) {
	    super();
	    this.pk_grade = pk_grade;
	    this.alias = alias;
	    this.scores = scores;
	}
	


	public Calification() {
	    super();
	}


	public int getPk_grade() {
		return pk_grade;
	}
	public void setPk_grade(int pk_grade) {
		this.pk_grade = pk_grade;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public List<Score> getScores() {
	    return scores;
	}


	public void setScores(List<Score> scores) {
	    this.scores = scores;
	}


	public Calification(int pk_grade) {
	    super();
	    this.pk_grade = pk_grade;
	}


	@Override
	public int hashCode() {
		return Objects.hash(alias, pk_grade);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calification other = (Calification) obj;
		return Objects.equals(alias, other.alias) && pk_grade == other.pk_grade;
	}
	@Override
	public String toString() {
		return "Calification [pk_grade=" + pk_grade + ", alias=" + alias + "]";
	}
	

}
