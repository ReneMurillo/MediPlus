package sv.com.masterdevelopment.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.masterdevelopment.models.dao.ITipoTelefonoDao;
import sv.com.masterdevelopment.models.entities.TipoTelefono;

@Service
public class TipoTelefonoServiceImpl implements ITipoTelefonoService{

	@Autowired
	private ITipoTelefonoDao tipoTelefonoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<TipoTelefono> findAll() {		
		return (List<TipoTelefono>) tipoTelefonoDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public TipoTelefono findOne(Long id) {		
		return tipoTelefonoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(TipoTelefono tipoTelefono) {
		tipoTelefonoDao.save(tipoTelefono);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		tipoTelefonoDao.deleteById(id);
	}
}
