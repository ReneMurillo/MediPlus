package sv.com.masterdevelopment.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.masterdevelopment.models.entities.Paciente;

public interface IPacienteDao extends CrudRepository<Paciente, Long>{

}
