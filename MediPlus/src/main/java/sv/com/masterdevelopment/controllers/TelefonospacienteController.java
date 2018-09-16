package sv.com.masterdevelopment.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.masterdevelopment.models.entities.Paciente;
import sv.com.masterdevelopment.models.entities.TelefonoPaciente;
import sv.com.masterdevelopment.models.services.ITelefonoPacienteService;

@Controller
@SessionAttributes("telefonos_paciente")
public class TelefonospacienteController {

	@Autowired
	private ITelefonoPacienteService telefonoPacienteService;
	
	@RequestMapping(value="/listartelpacientes", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de teléfonos");
		model.addAttribute("telefonospacientes", telefonoPacienteService.findAll());
		return "listartelpacientes";
	}
	
	@RequestMapping(value="/formtelpacientes")
	public String crear(Map<String, Object> model) {
		TelefonoPaciente telefonoPaciente = new TelefonoPaciente();
		model.put("telefonopaciente", telefonoPaciente);
		model.put("titulo", "Formulario de registro de teléfonos del paciente");
		return "formtelpacientes";
	}
	
	@RequestMapping(value="/formtelpacientes", method=RequestMethod.POST)
	public String guardar(@Valid TelefonoPaciente telefonoPaciente, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formtelpacientes";
		}
		telefonoPacienteService.save(telefonoPaciente);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Teléfono del paciente registrado con éxito");
		return "redirect:listartelpacientes";
	}
}
