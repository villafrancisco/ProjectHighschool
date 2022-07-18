package com.highschool.highschool.repositorio.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.highschool.highschool.negocio.Pupil;
import com.highschool.highschool.repositorio.PupilRepository;
import com.highschool.highschool.repositorio.jdbc.mapper.PupilMapper;


@Repository
public class PupilRepositoryJDBC implements PupilRepository {

	@Autowired
	private JdbcTemplate plantilla;
	
	@Override
	public void update(Pupil pupil, String pk_id) {
		plantilla.update("update pupil set pk_id=?, name=? , birth_year=? where pk_id=?",pupil.getPk_id(),pupil.getName(),pupil.getBirth_year(),pk_id);
	}

	@Override
	public void insert(Pupil pupil) {
		 plantilla.update("insert into pupil (pk_id,name,birth_year) values (?,?,?)",pupil.getPk_id(),pupil.getName(),pupil.getBirth_year());
		
	}

	@Override
	public void delete(Pupil pupil) {
		plantilla.update("delete from pupil where pk_id =?",pupil.getPk_id());
		
	}

	@Override
	public List<Pupil> findAll() {
		return plantilla.query("select * from pupil", new PupilMapper());
	}

	@Override
	public Pupil findOne(String pk_id) {
		return plantilla.queryForObject("select * from pupil where pk_id=?",new PupilMapper(),pk_id);
	}

	@Override
	public List<Pupil> findbirth2004History() {
	    return plantilla.query("SELECT * FROM score AS s  INNER JOIN pupil as p ON s.fk_pupil=p.pk_id "
	    	+ " INNER JOIN subject AS su ON s.fk_calification=su.pk_subject "
	    	+ "WHERE p.birth_year=2004 AND su.name='Historia'",new PupilMapper());
	    
	   
	    
	    
	}

	@Override
	public List<Map<String, Object>> maxFailure() {
	    return plantilla.queryForList("SELECT p.name as nombre, COUNT(1) AS numero_suspensos FROM score AS s "
	    	+ "INNER JOIN calification AS c ON s.fk_calification=c.pk_grade "
	    	+ "INNER JOIN pupil AS p ON p.pk_id=s.fk_pupil "
	    	+ "INNER JOIN subject AS su ON su.pk_subject=s.fk_subject "
	    	+ "WHERE c.alias='Insuficiente' GROUP BY s.fk_pupil "
	    	+ "HAVING numero_suspensos=(SELECT max(subconsulta1.numero_suspensos) AS suspensos FROM "
	    	+ "			(SELECT COUNT(1) numero_suspensos FROM score AS s "
	    	+ "					INNER JOIN calification AS c ON s.fk_calification=c.pk_grade "
	    	+ "					WHERE c.alias='Insuficiente' GROUP BY s.fk_pupil) AS subconsulta1)");
	}

	
	
	
	
}
