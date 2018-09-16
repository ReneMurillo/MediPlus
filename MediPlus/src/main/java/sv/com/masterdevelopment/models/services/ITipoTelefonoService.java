package sv.com.masterdevelopment.models.services;

import java.util.List;

import sv.com.masterdevelopment.models.entities.TipoTelefono;

public interface ITipoTelefonoService {

public List<TipoTelefono> findAll();
	
	public void save(TipoTelefono tipoTelefono);
	
	public TipoTelefono findOne(Long id);
	
	public void delete(Long id);
}
