package daoEJB;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * LunettesMagasin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lunettes_magasin", catalog = "g_magasin")
public class LunettesMagasin extends AbstractLunettesMagasin implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public LunettesMagasin() {
	}

	/** full constructor */
	public LunettesMagasin(Integer codeL, Integer qteL, Integer codemagasin) {
		super(codeL, qteL, codemagasin);
	}

}
