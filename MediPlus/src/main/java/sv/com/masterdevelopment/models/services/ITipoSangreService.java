package sv.com.masterdevelopment.models.services;

import java.util.List;


import sv.com.masterdevelopment.models.entities.TipoSangre;

public interface ITipoSangreService {

	public List<TipoSangre> findAll();
	
	public void save(TipoSangre tipoSangre);
	
	public TipoSangre findOne(Long id);
	
	public void delete(Long id);
}
