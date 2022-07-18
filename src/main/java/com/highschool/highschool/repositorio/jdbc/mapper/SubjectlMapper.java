package com.highschool.highschool.repositorio.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.highschool.highschool.negocio.Subject;

public class SubjectlMapper implements RowMapper<Subject> {

    @Override
    public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
	return new Subject(rs.getInt("pk_subject"),rs.getString("name"));
    }

    

}
