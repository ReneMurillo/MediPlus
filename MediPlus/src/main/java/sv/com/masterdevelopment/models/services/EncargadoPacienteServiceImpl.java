package sv.com.masterdevelopment.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.masterdevelopment.models.dao.IEncargadoPacienteDao;
import sv.com.masterdevelopment.models.entities.EncargadoPaciente;

@Service
public class EncargadoPacienteServiceImpl implements IEncargadoPacienteService{

	@Autowired
	private IEncargadoPacienteDao encargadoPacienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<EncargadoPaciente> findAll() {		
		return (List<EncargadoPaciente>) encargadoPacienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public EncargadoPaciente findOne(Long id) {		
		return encargadoPacienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(EncargadoPaciente paciente) {
		encargadoPacienteDao.save(paciente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		encargadoPacienteDao.deleteById(id);
	}
	
}
