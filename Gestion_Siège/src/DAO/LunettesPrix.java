package DAO;

/**
 * LunettesPrix entity. @author MyEclipse Persistence Tools
 */
public class LunettesPrix extends AbstractLunettesPrix implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public LunettesPrix() {
	}

	/** full constructor */
	public LunettesPrix(Integer codeL, String nomL, String descL, Integer prixL) {
		super(codeL, nomL, descL, prixL);
	}

}
