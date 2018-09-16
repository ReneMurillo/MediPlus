package sv.com.masterdevelopment.controllers;

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

import sv.com.masterdevelopment.models.entities.TipoTelefono;
import sv.com.masterdevelopment.models.services.ITipoTelefonoService;

@Controller
@SessionAttributes("tipos_telefonos")
public class TipostelefonoController {

	@Autowired
	private ITipoTelefonoService tipoTelefonoService;
	
	@RequestMapping(value="/listartipostel", method=RequestMethod.GET)
	public String listartipostel(Model model) {
		model.addAttribute("titulo","listado de tipos de teléfono");
		model.addAttribute("tipos_telefonos", tipoTelefonoService.findAll());
		return "listartipostel";
	}
	
	@RequestMapping(value="/formtipostel")
	public String crear(Map<String, Object> model) {
		TipoTelefono tipoTelefono = new TipoTelefono();
		model.put("tipos_telefonos", tipoTelefono);
		model.put("titulo", "Formulario de tipos de teléfono");
		return "formtipostel";
	}
	
	@RequestMapping(value="/formtipostel", method=RequestMethod.POST)
	public String guardar(@Valid TipoTelefono tipoTelefono, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formtipostel";
		}
		tipoTelefonoService.save(tipoTelefono);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Tipo de teléfono creado con éxito");
		return "redirect:listartipostel";
	}
	
	@RequestMapping(value="/formtipostel/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		TipoTelefono tipoTelefono = null;
		if (id > 0) {
			tipoTelefono = tipoTelefonoService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del tipo no puede ser cero");
			return "redirect:/listartipos";
		}
		model.put("tipos_telefonos", tipoTelefono);
		model.put("titulo", "Editar Tipo de teléfono");
		
		return "formtipostel";
	}
	
	@RequestMapping(value="/deletetipotel/{id}")
	public String deletetipotel(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			tipoTelefonoService.delete(id);
		}
		flash.addFlashAttribute("success","Tipo de teléfono eliminado con éxito");
		return "redirect:/listartipostel";
	}
}
