package com.highschool.highschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.highschool.highschool.servicio.HightScoolService;

@Controller
@RequestMapping()
public class MainHightSchoolController {
    
    @Autowired
    HightScoolService miservicio;
    
    @RequestMapping()
    public String index(Model model) {
	return "index";
    }

   
    
    @RequestMapping("/scores")
    public String showAllScores(Model model) {
	
	model.addAttribute("lista", miservicio.findAllScores());
	model.addAttribute("subjects", miservicio.findAllSubject());
	return "scores/listacompletaajax";
	//return "scores/listacompleta";
    }
    
    @RequestMapping("/stadistics")
    public String showStadictics(Model model) {

	model.addAttribute("pupilsBestAVG2020", miservicio.findBestAVG2020());
	
	model.addAttribute("bestSubjectCalification2005",miservicio.bestSubjectCalification2005());
	
	model.addAttribute("scoresFebruary",miservicio.scoresFebruary());
	
	model.addAttribute("maxNumberPupils",miservicio.maxNumberPupils());
	
	model.addAttribute("pupils2004History",miservicio.findbirth2004History());
	
	model.addAttribute("subjects2021_04",miservicio.find2021_04());
	
	model.addAttribute("maxFailure",miservicio.maxFailure());
	
	model.addAttribute("maxTest",miservicio.maxTest());
	
	return "stadistics/estadisticas";
    }

}
