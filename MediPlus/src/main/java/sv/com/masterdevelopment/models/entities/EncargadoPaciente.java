package sv.com.masterdevelopment.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="encargadospacientes")
public class EncargadoPaciente {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "encargados_Seq")
	@SequenceGenerator(name = "encargados_Seq", sequenceName = "ENCARGADOS_SEQ")
	private Long id;
	
	@Column(name="primernombre")
	@NotEmpty
	private String firstName;
	
	@Column(name="segundonombre")
	@NotEmpty
	private String secondName;
	
	@Column(name="primerapellido")
	@NotEmpty
	private String firstLastName;
	
	@Column(name="segundoapellido")
	@NotEmpty
	private String secondLastName;
	
	@Column(name="dui")
	@NotEmpty
	private String dui;
	
	@Column(name="direccion")
	@NotEmpty
	private String direccion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstLastName() {
		return firstLastName;
	}

	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Column(name="parentesco")
	@NotEmpty
	private String parentesco;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Paciente paciente;
}
