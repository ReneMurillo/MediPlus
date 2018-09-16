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

import sv.com.masterdevelopment.models.entities.TipoSangre;
import sv.com.masterdevelopment.models.services.ITipoSangreService;

@Controller
@SessionAttributes("tipossangre")
public class TipossangreController {

	@Autowired
	private ITipoSangreService tipoSangreService;
	
	@RequestMapping(value="/listartipos", method=RequestMethod.GET)
	public String listartipos(Model model) {
		model.addAttribute("titulo","listado de tipos de sangre");
		model.addAttribute("tipossangre", tipoSangreService.findAll());
		return "listartipos";
	}
	
	@RequestMapping(value="/formtipos")
	public String crear(Map<String, Object> model) {
		TipoSangre tipoSangre = new TipoSangre();
		model.put("tipossangre", tipoSangre);
		model.put("titulo", "Formulario de tipos de sangre");
		return "formtipos";
	}
	
	@RequestMapping(value="/formtipos", method=RequestMethod.POST)
	public String guardar(@Valid TipoSangre tipoSangre, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formtipos";
		}
		tipoSangreService.save(tipoSangre);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Tipo de sangre creado con exito");
		return "redirect:listartipos";
	}
	
	@RequestMapping(value="/formtipos/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		TipoSangre tipoSangre = null;
		if (id > 0) {
			tipoSangre = tipoSangreService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del tipo no puede ser cero");
			return "redirect:/listartipos";
		}
		model.put("tipossangre", tipoSangre);
		model.put("titulo", "Editar Tipo de sangre");
		
		return "formtipos";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			tipoSangreService.delete(id);
		}
		flash.addFlashAttribute("success","Tipo de sangre eliminado con éxito");
		return "redirect:/listartipos";
	}
}
