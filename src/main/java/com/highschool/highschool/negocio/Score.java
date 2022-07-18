package com.highschool.highschool.negocio;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Score implements Comparable<Score>{
	
	private int pk_score;
	
	@DateTimeFormat(iso = ISO.DATE)
	private Date date;
	private Pupil pupil;
	private Subject subject;
	private Calification calification;
	
	public Score(int pk_score, Pupil pupil, Subject subject, Calification calification, Date date) {
	    super();
	    this.pk_score = pk_score;
	    this.date = date;
	    this.pupil = pupil;
	    this.subject = subject;
	    this.calification = calification;
	}
	
	
	public Score(int pk_score) {
	    super();
	    this.pk_score = pk_score;
	}


	public Score() {
	    super();
	}


	public int getPk_score() {
	    return pk_score;
	}
	public void setPk_score(int pk_score) {
	    this.pk_score = pk_score;
	}
	public Date getDate() {
	    return date;
	}
	public void setDate(Date date) {
	    this.date = date;
	}
	public Pupil getPupil() {
	    return pupil;
	}
	public void setPupil(Pupil pupil) {
	    this.pupil = pupil;
	}
	public Subject getSubject() {
	    return subject;
	}
	public void setSubject(Subject subject) {
	    this.subject = subject;
	}
	public Calification getCalification() {
	    return calification;
	}
	public void setCalification(Calification calification) {
	    this.calification = calification;
	}
	@Override
	public String toString() {
	    return "Score [pk_score=" + pk_score + ", date=" + date + ", pupil=" + pupil + ", subject=" + subject
		    + ", calification=" + calification + "]";
	}


	@Override
	public int compareTo(Score o) {
	    return (this.getCalification().getPk_grade()>o.getCalification().getPk_grade()) ? 1 :0;
	    
	}
	
	
	
	
	
	
	

}
