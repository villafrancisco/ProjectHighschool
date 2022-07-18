package com.highschool.highschool.repositorio.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.highschool.highschool.negocio.Calification;
import com.highschool.highschool.repositorio.CalificationRepository;
import com.highschool.highschool.repositorio.jdbc.mapper.CalificationMapper;

@Repository
public class CalificationRepositoryJDBC implements CalificationRepository {

    @Autowired
    private JdbcTemplate plantilla;
    
    @Override
    public List<Calification> findAllCalification() {
	return plantilla.query("select * from calification", new CalificationMapper()); 
    }
    
    
    

}
