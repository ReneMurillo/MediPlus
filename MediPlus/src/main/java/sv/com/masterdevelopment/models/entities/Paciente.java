package sv.com.masterdevelopment.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pacientes")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "pacientes_Seq")
	@SequenceGenerator(name = "pacientes_Seq", sequenceName = "PACIENTES_SEQ")
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
	
	@Column(name="fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date birthDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TipoSangre tipoSangre;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<EncargadoPaciente> encargadoPaciente;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<TelefonoPaciente> telefonoPaciente;
 
	public List<TelefonoPaciente> getTelefonoPaciente() {
		return telefonoPaciente;
	}

	public void setTelefonoPaciente(List<TelefonoPaciente> telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}

	public List<EncargadoPaciente> getEncargadoPaciente() {
		return encargadoPaciente;
	}

	public void setEncargadoPaciente(List<EncargadoPaciente> encargadoPaciente) {
		this.encargadoPaciente = encargadoPaciente;
	}

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public TipoSangre getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(TipoSangre tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

}
