package com.highschool.highschool.repositorio;

import java.util.List;
import java.util.Map;

import com.highschool.highschool.negocio.Pupil;

public interface PupilRepository {
	
	void update(Pupil pupil,String pk_id);
	void insert(Pupil pupil);
	void delete(Pupil pupil);
	
	List<Pupil> findAll();
	Pupil findOne(String pk_id);
	List<Pupil> findbirth2004History();
	List<Map<String, Object>> maxFailure();
	
	

}
