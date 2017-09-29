package DAO;

import java.util.Date;

/**
 * TousCommandes entity. @author MyEclipse Persistence Tools
 */
public class TousCommandes extends AbstractTousCommandes implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TousCommandes() {
	}

	/** full constructor */
	public TousCommandes(Integer codeCmd, String client, Integer codeL,
			Integer qteCmd, Date dateCmd) {
		super(codeCmd, client, codeL, qteCmd, dateCmd);
	}

}
