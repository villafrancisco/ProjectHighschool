package com.highschool.highschool.repositorio.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.highschool.highschool.negocio.Subject;
import com.highschool.highschool.repositorio.SubjectRepository;

@Repository
public class SubjectRepositoryJDBC implements SubjectRepository {

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public List<Subject> findAllSubject() {

	return plantilla.query("select * from subject",
		(rs, rowNum) -> new Subject(rs.getInt("pk_subject"), rs.getString("name")));
    }

    @Override
    public List<Map<String, Object>> bestSubjectCalification2005() {
	
	
	return plantilla.queryForList("SELECT subconsulta1.asignatura, subconsulta1.notamedia "
		+ "FROM ( "
		+ "    SELECT sb.name AS asignatura, AVG(ca.pk_grade) AS notamedia "
		+ "    FROM score sc "
		+ "    JOIN calification ca ON sc.fk_calification = ca.pk_grade"
		+ "    JOIN pupil p ON sc.fk_pupil = p.pk_id "
		+ "    JOIN subject sb ON sc.fk_subject = sb.pk_subject "
		+ "    WHERE p.birth_year = 2005 "
		+ "    GROUP BY sb.pk_subject "
		+ ") AS subconsulta1 "
		+ "WHERE subconsulta1.notamedia = ( "
		+ "    SELECT MIN(subconsulta2.notamedia) "
		+ "    FROM ("
		+ "         SELECT AVG(sc.fk_calification) AS notamedia "
		+ "         FROM score sc "
		+ "         JOIN pupil p ON sc.fk_pupil = p.pk_id  "
		+ "         WHERE p.birth_year = 2005 "
		+ "         GROUP BY sc.fk_subject "
		+ "    ) AS subconsulta2)");
	
    }

    @Override
    public List<Map<String, Object>> maxNumberPupils() {
	return plantilla.queryForList("SELECT subconsulta1.asignatura, subconsulta1.examenes "
		+ "FROM ("
		+ "       SELECT sb.name AS asignatura, COUNT(sc.fk_pupil) AS examenes "
		+ "    FROM score sc "
		+ "    JOIN subject sb ON sc.fk_subject = sb.pk_subject "
		+ "    GROUP BY sb.pk_subject "
		+ ") AS subconsulta1 "
		+ "WHERE subconsulta1.examenes = ("
		+ "    SELECT MAX(subconsulta2.examenes) "
		+ "    FROM ("
		+ "        SELECT COUNT(pk_score) AS examenes "
		+ "        FROM score "
		+ "        GROUP BY fk_subject "
		+ "        ) AS subconsulta2"
		+ "    )");
    }

    @Override
    public List<Subject> find2021_04() {
	return plantilla.query("SELECT * FROM score AS sc INNER JOIN subject AS s ON sc.fk_subject=s.pk_subject WHERE YEAR(sc.date) = 2021 AND MONTH(sc.date)=4 group by pk_subject",
		(rs,rowNum)-> new Subject(rs.getInt("pk_subject"), rs.getString("name")));
    }

    @Override
    public List<Map<String, Object>> maxTest() {
	return plantilla.queryForList("SELECT su.*, COUNT(1) AS numero_tests FROM score AS s"
		+ "	INNER JOIN subject AS su ON su.pk_subject=s.fk_subject	GROUP BY s.fk_subject "
		+ "HAVING numero_tests=(SELECT MAX(subconsulta1.test) from "
		+ "(SELECT *, COUNT(1) AS test FROM score AS s GROUP BY s.fk_subject) AS subconsulta1)");
    }

}
