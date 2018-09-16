package sv.com.masterdevelopment.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tipos_telefonos")
public class TipoTelefono {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "tipoTelefono_Seq")
	@SequenceGenerator(name = "tipoTelefono_Seq", sequenceName = "TIPOTELEFONO_SEQ")
	private Long id;
	
	@Column(name="nombre_tipo")
	private String Nombre;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<TelefonoPaciente> telefonoPaciente;

	public List<TelefonoPaciente> getTelefonoPaciente() {
		return telefonoPaciente;
	}

	public void setTelefonoPaciente(List<TelefonoPaciente> telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	
	
}
