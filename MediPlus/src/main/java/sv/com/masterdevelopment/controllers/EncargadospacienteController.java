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

import sv.com.masterdevelopment.models.entities.EncargadoPaciente;
import sv.com.masterdevelopment.models.entities.Paciente;
import sv.com.masterdevelopment.models.services.IEncargadoPacienteService;

@Controller
@SessionAttributes("encargadopaciente")
public class EncargadospacienteController {

	@Autowired
	private IEncargadoPacienteService encargadoPacienteService;
	
	@RequestMapping(value="/listarencargados", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de encargados pacientes");
		model.addAttribute("encargadospacientes", encargadoPacienteService.findAll());
		return "listarencargados";
	}
	
	@RequestMapping(value="/formencargados")
	public String crearEncargado(Map<String, Object> model) {
		EncargadoPaciente encargadoPaciente = new EncargadoPaciente();
		model.put("encargadoPaciente", encargadoPaciente);
		model.put("titulo", "Formulario de encargado del paciente");
		return "formencargados";
	}
	
	@RequestMapping(value="/formencargados", method=RequestMethod.POST)
	public String guardar(@Valid EncargadoPaciente encargadoPaciente, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formencargados";
		}
		encargadoPacienteService.save(encargadoPaciente);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Encargado del paciente creado con exito");
		return "redirect:listarencargados";
	}
	
	@RequestMapping(value="/formencargados/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		EncargadoPaciente encargadoPaciente = null;
		if (id > 0) {
			encargadoPaciente = encargadoPacienteService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del cliente no puede ser cero");
			return "redirect:/listarencargados";
		}
		model.put("encargadoPaciente", encargadoPaciente);
		model.put("titulo", "Editar encargado del paciente");
		
		return "formencargados";
	}
	
	@RequestMapping(value="/eliminarencargado/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			encargadoPacienteService.delete(id);
		}
		flash.addFlashAttribute("success","Encargado del paciente eliminado con éxito");
		return "redirect:/listarencargados";
	}
}
