package service;

import javax.ejb.Remote;

@Remote
public interface serviceRemote {
	public String[][] Qantite();
	
}
