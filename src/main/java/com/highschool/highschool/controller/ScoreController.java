package com.highschool.highschool.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.highschool.highschool.negocio.Calification;
import com.highschool.highschool.negocio.Pupil;
import com.highschool.highschool.negocio.Score;
import com.highschool.highschool.negocio.Subject;
import com.highschool.highschool.servicio.HightScoolService;

@Controller
@RequestMapping("/pupils/{pk_id}/scores")
public class ScoreController {

    @Autowired
    HightScoolService miservicio;

    @RequestMapping()
    public String showScores(Model model, @PathVariable String pk_id) {
	model.addAttribute("pupil", miservicio.findOnePupil(pk_id));
	model.addAttribute("lista", miservicio.findScores(pk_id));

	return "scores/lista";
    }

    @RequestMapping("editar/{pk_score}")
    public String formularioEditar(Model model, @PathVariable int pk_score) {
	model.addAttribute("pupils",miservicio.findAllPupils());
	model.addAttribute("score", miservicio.findOneScore(pk_score));
	model.addAttribute("subjects", miservicio.findAllSubject());
	model.addAttribute("califications", miservicio.findAllCalification());
	return "scores/editarnota";
    }

    @RequestMapping(value = "/editar/guardar", method = RequestMethod.POST)
    public String update(Model model, Score score, @PathVariable String pk_id, @RequestParam int pk_score,
	    @RequestParam int fk_subject, @RequestParam int fk_calification) {
	score.setPupil(new Pupil(pk_id));
	score.setSubject(new Subject(fk_subject));
	score.setCalification(new Calification(fk_calification));
	miservicio.updateScore(score);
	return "redirect:/pupils/" + pk_id + "/scores";
    }

    @RequestMapping("/nuevo")
    public String formularioNuevo(Model model, @PathVariable String pk_id) {
	model.addAttribute("pk_id", pk_id);
	model.addAttribute("pupils", miservicio.findAllPupils());
	model.addAttribute("subjects", miservicio.findAllSubject());
	model.addAttribute("califications", miservicio.findAllCalification());
	return "scores/nuevonota";
    }
    

    @RequestMapping(value = "/insertar", method = RequestMethod.POST)
    public String insertar(Model model, Score score, @PathVariable String pk_id, @RequestParam int fk_subject,
	    @RequestParam int fk_calification) {
	score.setPupil(new Pupil(pk_id));
	score.setSubject(new Subject(fk_subject));
	score.setCalification(new Calification(fk_calification));
	
	miservicio.insertScore(score);
	return "redirect:/pupils/" + pk_id + "/scores";
    }
    @RequestMapping("/scores/nuevo")
    public String formularioNuevofromScores(Model model) {
	model.addAttribute("pupils", miservicio.findAllPupils());
	model.addAttribute("subjects", miservicio.findAllSubject());
	model.addAttribute("califications", miservicio.findAllCalification());
	return "scores/nuevanotascores";
    }
    @RequestMapping(value = "/scores/insertar", method = RequestMethod.POST)
    public String insertarfromScores(Model model, Score score, @RequestParam Map<String,String> allParams) {
	score.setPupil(new Pupil(allParams.get("pk_id")));
	
	score.setSubject(new Subject(Integer.parseInt(allParams.get("fk_subject"))));
	score.setCalification(new Calification(Integer.parseInt(allParams.get("fk_calification"))));
	
	miservicio.insertScore(score);
	return "redirect:/scores";
    }

    @RequestMapping("/borrar/{pk_score}")
    public String delete(Model model, @PathVariable String pk_id, @PathVariable int pk_score) {
	miservicio.deleteScore(new Score(pk_score));
	return "redirect:/pupils/" + pk_id + "/scores";

    }
    
    @RequestMapping("/lista")
    public String showAllScoresAjax(Model model) {
	
	//model.addAttribute("lista", miservicio.findAllScores());
	//model.addAttribute("subjects", miservicio.findAllSubject());
	return "scores/listacompletaajax";
    }
    
   
    
   

}
