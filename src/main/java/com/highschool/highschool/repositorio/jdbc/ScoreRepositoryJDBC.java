package com.highschool.highschool.repositorio.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.highschool.highschool.negocio.Score;
import com.highschool.highschool.repositorio.ScoreRepository;
import com.highschool.highschool.repositorio.jdbc.mapper.ScoreMapper;
import com.highschool.highschool.repositorio.jdbc.mapper.bestAVG2020MapperExtractor;

@Repository
public class ScoreRepositoryJDBC implements ScoreRepository {

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public void update(Score score) {
	plantilla.update("update score set fk_subject=?, fk_calification=?, date=? where pk_score=?",
		score.getSubject().getPk_subject(), score.getCalification().getPk_grade(), score.getDate(),
		score.getPk_score());

    }

    @Override
    public void insert(Score score) {
	plantilla.update("insert into score (fk_pupil,fk_subject,fk_calification,date) values (?,?,?,?)",
		score.getPupil().getPk_id(), score.getSubject().getPk_subject(), score.getCalification().getPk_grade(),
		score.getDate());

    }

    @Override
    public void delete(Score score) {
	plantilla.update("delete from score where pk_score =?", score.getPk_score());

    }

    @Override
    public List<Score> findAll(String fk_pupil) {
	return plantilla.query(
		"select *, su.name as name_subject from pupil as p INNER JOIN score as s ON p.pk_id=s.fk_pupil"
			+ "						INNER JOIN subject as su ON s.fk_subject=su.pk_subject"
			+ "						INNER JOIN calification AS c ON s.fk_calification=c.pk_grade"
			+ "						where s.fk_pupil=?",
		new ScoreMapper(), fk_pupil);
    }

    @Override
    public Score findOne(int pk_score) {
	return plantilla.queryForObject(
		"select *, su.name as name_subject from score as s INNER JOIN pupil as p ON p.pk_id=s.fk_pupil"
			+ "						INNER JOIN subject as su ON s.fk_subject=su.pk_subject"
			+ "						INNER JOIN calification AS c ON s.fk_calification=c.pk_grade"
			+ "						where pk_score=?",
		new ScoreMapper(), pk_score);
    }

    @Override
    public List<Score> findAll() {
	return plantilla
		.query("select *, su.name as name_subject from pupil as p INNER JOIN score as s ON p.pk_id=s.fk_pupil"
			+ "						INNER JOIN subject as su ON s.fk_subject=su.pk_subject"
			+ "						INNER JOIN calification AS c ON s.fk_calification=c.pk_grade"
			+ "						", new ScoreMapper());
    }

    @Override
    public List<Score> findBySubject(int pk_subject) {
	return plantilla.query(
		"select *, su.name as name_subject from pupil as p INNER JOIN score as s ON p.pk_id=s.fk_pupil"
			+ "						INNER JOIN subject as su ON s.fk_subject=su.pk_subject"
			+ "						INNER JOIN calification AS c ON s.fk_calification=c.pk_grade"
			+ " 						where su.pk_subject=?",
		new ScoreMapper(), pk_subject);
    }

    @Override
    public List<Score> findBestAVG2020() {
	return plantilla
		.query("SELECT *,su.name as name_subject, p.name AS nombre, AVG(sc.fk_calification) AS notamedia "
			+ " FROM score as sc INNER JOIN pupil p ON sc.fk_pupil = p.pk_id "
			+ " INNER JOIN subject as su ON su.pk_subject=sc.fk_subject "
			+ " INNER JOIN calification as ca ON ca.pk_grade=sc.fk_calification "
			+ " WHERE YEAR(sc.date) = 2020 " + " GROUP BY sc.fk_pupil", new bestAVG2020MapperExtractor());

    }

    @Override
    public List<Score> scoresFebruary() {
	return plantilla.query(
		"SELECT  *, su.name as name_subject FROM score as s  INNER JOIN pupil as p ON p.pk_id=s.fk_pupil "
			+ "		INNER JOIN subject as su ON s.fk_subject=su.pk_subject "
			+ "		INNER JOIN calification AS c ON s.fk_calification=c.pk_grade WHERE MONTH(date) = 2"
			+ " ORDER BY fk_subject, fk_calification DESC ",
		new ScoreMapper());
    }

}
