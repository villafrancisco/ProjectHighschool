package com.highschool.highschool.repositorio.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.highschool.highschool.negocio.Calification;
import com.highschool.highschool.negocio.Pupil;
import com.highschool.highschool.negocio.Score;
import com.highschool.highschool.negocio.Subject;

public class ScoreMapper implements RowMapper<Score> {

    @Override
    public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
	return new Score(rs.getInt("pk_score"),new Pupil(rs.getString("fk_pupil"),rs.getString("name"),rs.getInt("birth_year")),
		new Subject(rs.getInt("fk_subject"),rs.getString("name_subject")),
		new Calification(rs.getInt("fk_calification"),rs.getString("alias")),
		rs.getDate("date"));
	
	
    }

}
