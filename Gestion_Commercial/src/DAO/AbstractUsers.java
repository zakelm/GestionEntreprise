package DAO;

/**
 * AbstractUsers entity provides the base persistence definition of the Users
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUsers implements java.io.Serializable {

	// Fields

	private Integer codeUser;
	private String login;
	private String pass;

	// Constructors

	/** default constructor */
	public AbstractUsers() {
	}

	/** full constructor */
	public AbstractUsers(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}

	// Property accessors

	public Integer getCodeUser() {
		return this.codeUser;
	}

	public void setCodeUser(Integer codeUser) {
		this.codeUser = codeUser;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}