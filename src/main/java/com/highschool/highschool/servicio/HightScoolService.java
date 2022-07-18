package com.highschool.highschool.servicio;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highschool.highschool.negocio.Calification;
import com.highschool.highschool.negocio.Pupil;
import com.highschool.highschool.negocio.Score;
import com.highschool.highschool.negocio.Subject;
import com.highschool.highschool.repositorio.CalificationRepository;
import com.highschool.highschool.repositorio.PupilRepository;
import com.highschool.highschool.repositorio.ScoreRepository;
import com.highschool.highschool.repositorio.SubjectRepository;

@Service
public class HightScoolService {
    @Autowired
    private PupilRepository pupilRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CalificationRepository calificationRepository;

    public void updatePupil(Pupil pupil, String pk_id) {
	pupilRepository.update(pupil, pk_id);
    }

    public void insertPupil(Pupil pupil) {
	pupilRepository.insert(pupil);
    }

    public void deletePupil(Pupil pupil) {
	pupilRepository.delete(pupil);
    }

    public List<Pupil> findAllPupils() {
	return pupilRepository.findAll();
    }

    public Pupil findOnePupil(String pk_id) {
	return pupilRepository.findOne(pk_id);
    }

    public void updateScore(Score score) {
	scoreRepository.update(score);
    }

    public void insertScore(Score score) {
	scoreRepository.insert(score);
    }

    public void deleteScore(Score score) {
	scoreRepository.delete(score);
    }

    public List<Score> findScores(String fk_pupil) {
	return scoreRepository.findAll(fk_pupil);
    }

    public List<Score> findAllScores() {
	return scoreRepository.findAll();
    }

    public Score findOneScore(int pk_score) {
	return scoreRepository.findOne(pk_score);
    }

    public List<Subject> findAllSubject() {
	return subjectRepository.findAllSubject();
    }

    public List<Calification> findAllCalification() {
	return calificationRepository.findAllCalification();
    }

    public List<Score> findScoreBySubject(int pk_subject) {
	return scoreRepository.findBySubject(pk_subject);
    }

    public List<Score> findBestAVG2020() {
	return scoreRepository.findBestAVG2020();
    }

    public List<Map<String, Object>> bestSubjectCalification2005() {
	return subjectRepository.bestSubjectCalification2005();
    }

    public List<Score> scoresFebruary() {
	return scoreRepository.scoresFebruary();
    }

    public List<Map<String, Object>> maxNumberPupils() {
	return subjectRepository.maxNumberPupils();
    }

    public List<Pupil> findbirth2004History() {
	return pupilRepository.findbirth2004History();
    }

    public List<Subject> find2021_04() {
	return subjectRepository.find2021_04();

    }

    public List<Map<String, Object>> maxFailure() {
	return pupilRepository.maxFailure();
    }
    public List<Map<String, Object>> maxTest() {
	return subjectRepository.maxTest();
    }

}
