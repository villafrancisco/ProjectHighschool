package com.highschool.highschool.repositorio;

import java.util.List;

import com.highschool.highschool.negocio.Score;



public interface ScoreRepository {
    

	void update(Score score);
	void insert(Score score);
	void delete(Score score);
	
	
	Score findOne(int pk_score);
	List<Score> findAll(String fk_pupil);
	List<Score> findAll();
	List<Score> findBySubject(int pk_subject);
	List<Score> findBestAVG2020();
	List<Score> scoresFebruary();
	
	
	
	
	
 
}
