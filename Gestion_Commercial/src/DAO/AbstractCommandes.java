package DAO;

import java.sql.Timestamp;

/**
 * AbstractCommandes entity provides the base persistence definition of the
 * Commandes entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCommandes implements java.io.Serializable {

	// Fields

	private Integer codeCmd;
	private String client;
	private Integer codeL;
	private Integer qteCmd;
	private Timestamp dateCmd;

	// Constructors

	/** default constructor */
	public AbstractCommandes() {
	}

	/** full constructor */
	public AbstractCommandes(Integer codeCmd, String client, Integer codeL,
			Integer qteCmd, Timestamp dateCmd) {
		this.codeCmd = codeCmd;
		this.client = client;
		this.codeL = codeL;
		this.qteCmd = qteCmd;
		this.dateCmd = dateCmd;
	}

	// Property accessors

	public Integer getCodeCmd() {
		return this.codeCmd;
	}

	public void setCodeCmd(Integer codeCmd) {
		this.codeCmd = codeCmd;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Integer getCodeL() {
		return this.codeL;
	}

	public void setCodeL(Integer codeL) {
		this.codeL = codeL;
	}

	public Integer getQteCmd() {
		return this.qteCmd;
	}

	public void setQteCmd(Integer qteCmd) {
		this.qteCmd = qteCmd;
	}

	public Timestamp getDateCmd() {
		return this.dateCmd;
	}

	public void setDateCmd(Timestamp dateCmd) {
		this.dateCmd = dateCmd;
	}

}