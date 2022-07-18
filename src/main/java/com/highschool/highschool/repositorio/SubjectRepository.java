package com.highschool.highschool.repositorio;

import java.util.List;
import java.util.Map;

import com.highschool.highschool.negocio.Subject;

public interface SubjectRepository {
    List<Subject> findAllSubject();

    List<Map<String, Object>> bestSubjectCalification2005();

    List<Map<String, Object>> maxNumberPupils();

    List<Subject> find2021_04();
    List<Map<String,Object>> maxTest();
    
}
