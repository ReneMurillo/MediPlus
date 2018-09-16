package sv.com.masterdevelopment.models.services;

import java.util.List;

import sv.com.masterdevelopment.models.entities.TelefonoPaciente;

public interface ITelefonoPacienteService {

public List<TelefonoPaciente> findAll();
	
	public void save(TelefonoPaciente telefonoPaciente);
	
	public TelefonoPaciente findOne(Long id);
	
	public void delete(Long id);
}
