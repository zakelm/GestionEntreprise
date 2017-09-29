package DAO;

import java.sql.Timestamp;

/**
 * Commandes entity. @author MyEclipse Persistence Tools
 */
public class Commandes extends AbstractCommandes implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Commandes() {
	}

	/** full constructor */
	public Commandes(Integer codeCmd, String client, Integer codeL,
			Integer qteCmd, Timestamp dateCmd) {
		super(codeCmd, client, codeL, qteCmd, dateCmd);
	}

}
