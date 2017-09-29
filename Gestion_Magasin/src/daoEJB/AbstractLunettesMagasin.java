package daoEJB;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractLunettesMagasin entity provides the base persistence definition of
 * the LunettesMagasin entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractLunettesMagasin implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer codeL;
	private Integer qteL;
	private Integer codemagasin;

	// Constructors

	/** default constructor */
	public AbstractLunettesMagasin() {
	}

	/** full constructor */
	public AbstractLunettesMagasin(Integer codeL, Integer qteL,
			Integer codemagasin) {
		this.codeL = codeL;
		this.qteL = qteL;
		this.codemagasin = codemagasin;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "codeL", nullable = false)
	public Integer getCodeL() {
		return this.codeL;
	}

	public void setCodeL(Integer codeL) {
		this.codeL = codeL;
	}

	@Column(name = "qteL", nullable = false)
	public Integer getQteL() {
		return this.qteL;
	}

	public void setQteL(Integer qteL) {
		this.qteL = qteL;
	}

	@Column(name = "codemagasin", nullable = false)
	public Integer getCodemagasin() {
		return this.codemagasin;
	}

	public void setCodemagasin(Integer codemagasin) {
		this.codemagasin = codemagasin;
	}

}