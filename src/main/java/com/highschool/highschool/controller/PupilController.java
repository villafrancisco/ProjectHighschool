package com.highschool.highschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.highschool.highschool.negocio.Pupil;
import com.highschool.highschool.servicio.HightScoolService;

@Controller
@RequestMapping("/pupils")
public class PupilController {
    @Autowired
    HightScoolService miservicio;

    @RequestMapping("/editar/{pk_id}")
    public String formularioEditar(Model model, @PathVariable String pk_id) {
	model.addAttribute("pupil", miservicio.findOnePupil(pk_id));
	return "pupils/editaralumno";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String update(Model model, Pupil pupil, @RequestParam String id) {

	miservicio.updatePupil(pupil, id);
	return "redirect:/pupils";

    }

    @RequestMapping("/nuevo")
    public String formularioNuevo(Model model) {
	return "pupils/nuevoalumno";
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST)
    public String insertar(Model model, Pupil pupil) {
	miservicio.insertPupil(pupil);
	return "redirect:/pupils";
    }

    @RequestMapping("/borrar/{pk_id}")
    public String delete(Model model, @PathVariable String pk_id) {
	Pupil pupil = new Pupil();
	pupil.setPk_id(pk_id);
	miservicio.deletePupil(pupil);
	return "redirect:/pupils";

    }

    @RequestMapping()
    public String showPupils(Model model) {
	model.addAttribute("lista", miservicio.findAllPupils());

	return "pupils/lista";
    }

}
