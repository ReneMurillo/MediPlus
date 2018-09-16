package sv.com.masterdevelopment.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.masterdevelopment.models.dao.IPacienteDao;
import sv.com.masterdevelopment.models.entities.Paciente;


@Service
public class PacienteServiceImpl implements IPacienteService{
	@Autowired
	private IPacienteDao pacienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Paciente> findAll() {		
		return (List<Paciente>) pacienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Paciente findOne(Long id) {		
		return pacienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Paciente paciente) {
		pacienteDao.save(paciente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		pacienteDao.deleteById(id);
	}
}
