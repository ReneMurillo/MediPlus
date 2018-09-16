package sv.com.masterdevelopment.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import sv.com.masterdevelopment.models.entities.Paciente;
import sv.com.masterdevelopment.models.entities.TipoSangre;
import sv.com.masterdevelopment.models.services.IPacienteService;



@Controller
@SessionAttributes("paciente")
public class PacienteController {

	@Autowired
	private IPacienteService pacienteService;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de pacientes");
		model.addAttribute("pacientes", pacienteService.findAll());
		return "listar";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		Paciente paciente = new Paciente();
		List<TipoSangre> tipossangre = new ArrayList<TipoSangre>();
		model.put("paciente", paciente);
		model.put("titulo", "Formulario de paciente");
		model.put("tipossangre", tipossangre);
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid Paciente paciente, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		pacienteService.save(paciente);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Paciente creado con exito");
		return "redirect:listar";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Paciente paciente = null;
		if (id > 0) {
			paciente = pacienteService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del cliente no puede ser cero");
			return "redirect:/listar";
		}
		model.put("paciente", paciente);
		model.put("titulo", "Editar Paciente");
		
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			pacienteService.delete(id);
		}
		flash.addFlashAttribute("success","Paciente eliminado con exito");
		return "redirect:/listar";
	}
	
	@RequestMapping(value="/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flashl) {
		Paciente paciente = pacienteService.findOne(id);
		if (paciente == null) {
			flashl.addFlashAttribute("error", "El paciente no existe en la base de datos");
			return "redirect:/listar";
		}

		model.put("paciente", paciente);
		model.put("titulo", "Editar Paciente");
		return "ver";
	}

}
