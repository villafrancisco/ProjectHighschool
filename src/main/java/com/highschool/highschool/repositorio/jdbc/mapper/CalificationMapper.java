package com.highschool.highschool.repositorio.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.highschool.highschool.negocio.Calification;

public class CalificationMapper implements RowMapper<Calification> {

    @Override
    public Calification mapRow(ResultSet rs, int rowNum) throws SQLException {
	return new Calification(rs.getInt("pk_grade"),rs.getString("alias"));
    }

}
