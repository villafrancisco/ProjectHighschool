package com.highschool.highschool.repositorio.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.highschool.highschool.negocio.Calification;
import com.highschool.highschool.negocio.Pupil;
import com.highschool.highschool.negocio.Score;
import com.highschool.highschool.negocio.Subject;

public class bestAVG2020MapperExtractor implements ResultSetExtractor<List<Score>> {

    @Override
    public List<Score> extractData(ResultSet rs) throws SQLException, DataAccessException {
	
	List<Score> bestScores=new ArrayList<Score>();
	
	while (rs.next()) {

		Score score = new Score(rs.getInt("pk_score"),new Pupil(rs.getString("fk_pupil"),rs.getString("name"),rs.getInt("birth_year")),
			new Subject(rs.getInt("fk_subject"),rs.getString("name_subject")),
			new Calification(rs.getInt("fk_calification"),rs.getString("alias")),
			rs.getDate("date"));
		bestScores.add(score);
	}
	 return bestScores.stream()
		.filter((score)->score.getCalification().getPk_grade()>=Collections.max(bestScores).getCalification().getPk_grade())
		.collect(Collectors.toList());
	 
	
	 
		
		
    }

}
