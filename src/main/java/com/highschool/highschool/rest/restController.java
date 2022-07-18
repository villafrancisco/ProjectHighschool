package com.highschool.highschool.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highschool.highschool.negocio.Score;
import com.highschool.highschool.servicio.HightScoolService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:8080",methods= {RequestMethod.GET,RequestMethod.POST})
public class restController {
    
    @Autowired
    HightScoolService miservicio;
    
    @GetMapping("/scores")
    public List<Score> showScores() {
	return miservicio.findAllScores();
    }
    
    @GetMapping("/scores/filtro/{pk_subject}")
    public List<Score> showScoresBySubject(@PathVariable int pk_subject) {
    	return miservicio.findScoreBySubject(pk_subject);
       }


    
}
