package com.highschool.highschool.repositorio.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.highschool.highschool.negocio.Pupil;

public class PupilMapper implements RowMapper<Pupil>{

	@Override
	public Pupil mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Pupil(rs.getString("pk_id"),rs.getString("name"),rs.getInt("birth_year"));
	}

	

}
