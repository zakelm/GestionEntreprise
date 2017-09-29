package DAO;

import java.util.Date;

/**
 * AbstractTousCommandes entity provides the base persistence definition of the
 * TousCommandes entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTousCommandes implements java.io.Serializable {

	// Fields

	private Integer codeTousCmd;
	private Integer codeCmd;
	private String client;
	private Integer codeL;
	private Integer qteCmd;
	private Date dateCmd;

	// Constructors

	/** default constructor */
	public AbstractTousCommandes() {
	}

	/** full constructor */
	public AbstractTousCommandes(Integer codeCmd, String client, Integer codeL,
			Integer qteCmd, Date dateCmd) {
		this.codeCmd = codeCmd;
		this.client = client;
		this.codeL = codeL;
		this.qteCmd = qteCmd;
		this.dateCmd = dateCmd;
	}

	// Property accessors

	public Integer getCodeTousCmd() {
		return this.codeTousCmd;
	}

	public void setCodeTousCmd(Integer codeTousCmd) {
		this.codeTousCmd = codeTousCmd;
	}

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

	public Date getDateCmd() {
		return this.dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

}