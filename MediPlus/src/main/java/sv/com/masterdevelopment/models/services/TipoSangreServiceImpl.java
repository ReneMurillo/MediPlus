package sv.com.masterdevelopment.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.masterdevelopment.models.dao.ITipoSangreDao;
import sv.com.masterdevelopment.models.entities.TipoSangre;



@Service
public class TipoSangreServiceImpl implements ITipoSangreService{

	@Autowired
	private ITipoSangreDao tipoSangreDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<TipoSangre> findAll() {		
		return (List<TipoSangre>) tipoSangreDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public TipoSangre findOne(Long id) {		
		return tipoSangreDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(TipoSangre tipoSangre) {
		tipoSangreDao.save(tipoSangre);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		tipoSangreDao.deleteById(id);
	}
}
