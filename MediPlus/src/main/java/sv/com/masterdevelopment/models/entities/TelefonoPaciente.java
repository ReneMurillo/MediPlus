package sv.com.masterdevelopment.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="telefonos_pacientes")
public class TelefonoPaciente {

	@Id
	@Column(name="numero")
	private String numero;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Paciente paciente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TipoTelefono tipoTelefono;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public TipoTelefono getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(TipoTelefono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	
}
