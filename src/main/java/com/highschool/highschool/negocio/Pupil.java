package com.highschool.highschool.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class Pupil {

    private String pk_id;
    private String name;
    private int birth_year;

    private List<Score> scores = new ArrayList<Score>();

    public Pupil() {
	super();
    }

    public Pupil(String pk_id) {
	super();
	this.pk_id = pk_id;
    }

    public Pupil(String pk_id, String name, int birth_year) {
	super();
	this.pk_id = pk_id;
	this.name = name;
	this.birth_year = birth_year;
    }

    public Pupil(String pk_id, String name, int birth_year, List<Score> scores) {
	super();
	this.pk_id = pk_id;
	this.name = name;
	this.birth_year = birth_year;
	this.scores = scores;
    }

    public String getPk_id() {
	return pk_id;
    }

    public void setPk_id(String pk_id) {
	this.pk_id = pk_id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getBirth_year() {
	return birth_year;
    }

    public void setBirth_year(int birth_year) {
	this.birth_year = birth_year;
    }

    public List<Score> getScores() {
	return scores;
    }

    public void setScores(List<Score> scores) {
	this.scores = scores;
    }

    public void addScore(Score score) {
	this.scores.add(score);
    }

    @Override
    public int hashCode() {
	return Objects.hash(pk_id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Pupil other = (Pupil) obj;
	return Objects.equals(pk_id, other.pk_id);
    }

    @Override
    public String toString() {
	return "Pupil [pk_id=" + pk_id + ", name=" + name + ", birth_year=" + birth_year + "]";
    }

}
