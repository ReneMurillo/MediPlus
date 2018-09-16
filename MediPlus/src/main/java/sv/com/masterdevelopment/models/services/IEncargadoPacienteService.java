package sv.com.masterdevelopment.models.services;

import java.util.List;

import sv.com.masterdevelopment.models.entities.EncargadoPaciente;

public interface IEncargadoPacienteService {

	public List<EncargadoPaciente> findAll();
	
	public void save(EncargadoPaciente encargadoPaciente);
	
	public EncargadoPaciente findOne(Long id);
	
	public void delete(Long id);
}
