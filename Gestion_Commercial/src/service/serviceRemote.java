package service;

import javax.ejb.Remote;

@Remote
public interface serviceRemote {
	public String[][] getLunettesQte();
	public boolean updateMag(int codel, int qteCmd);
	public String[] getLunettesQteByCodeL(int codeL);
	
}
