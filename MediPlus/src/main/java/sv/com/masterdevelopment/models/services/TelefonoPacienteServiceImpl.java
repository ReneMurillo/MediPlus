package sv.com.masterdevelopment.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.masterdevelopment.models.dao.ITelefonoPacienteDao;
import sv.com.masterdevelopment.models.entities.TelefonoPaciente;

@Service
public class TelefonoPacienteServiceImpl implements ITelefonoPacienteService{

	@Autowired
	private ITelefonoPacienteDao telefonoPacienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<TelefonoPaciente> findAll() {		
		return (List<TelefonoPaciente>) telefonoPacienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public TelefonoPaciente findOne(Long id) {		
		return telefonoPacienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(TelefonoPaciente telefonoPaciente) {
		telefonoPacienteDao.save(telefonoPaciente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		telefonoPacienteDao.deleteById(id);
	}
}
