package DAO;

/**
 * AbstractLunettesPrix entity provides the base persistence definition of the
 * LunettesPrix entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLunettesPrix implements java.io.Serializable {

	// Fields

	private Integer codeL;
	private String nomL;
	private String descL;
	private Integer prixL;

	// Constructors

	/** default constructor */
	public AbstractLunettesPrix() {
	}

	/** full constructor */
	public AbstractLunettesPrix(Integer codeL, String nomL, String descL,
			Integer prixL) {
		this.codeL = codeL;
		this.nomL = nomL;
		this.descL = descL;
		this.prixL = prixL;
	}

	// Property accessors

	public Integer getCodeL() {
		return this.codeL;
	}

	public void setCodeL(Integer codeL) {
		this.codeL = codeL;
	}

	public String getNomL() {
		return this.nomL;
	}

	public void setNomL(String nomL) {
		this.nomL = nomL;
	}

	public String getDescL() {
		return this.descL;
	}

	public void setDescL(String descL) {
		this.descL = descL;
	}

	public Integer getPrixL() {
		return this.prixL;
	}

	public void setPrixL(Integer prixL) {
		this.prixL = prixL;
	}

}