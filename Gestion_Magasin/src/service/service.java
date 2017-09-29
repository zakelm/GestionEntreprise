package service;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import daoEJB.LunettesMagasin;




@Stateless(name = "service", mappedName = "ejb/service")
public class service implements serviceRemote {
	
	// on va creer la fonction qui va récuperer les enregistrement de la table Lunettes_magasin
	 public String[][] Qantite() {
		 
	    EntityManagerFactory e = Persistence.createEntityManagerFactory("e");
		EntityManager em = e.createEntityManager();
	   	List<LunettesMagasin> result = em.createQuery("SELECT lunette FROM LunettesMagasin lunette ").getResultList();

	   	
	   	Iterator iterator = result.iterator();
		
		String lunettes[][] = new String[result.size()][4];
		
		int i=0;
		
		while(iterator.hasNext()){
			
			LunettesMagasin lp = (LunettesMagasin) iterator.next();
			lunettes[i][0] = lp.getCodemagasin().toString();
			lunettes[i][1] = lp.getCodeL().toString();
			lunettes[i][2] = lp.getQteL().toString();
			i++;
		}
		
		return lunettes;
		}
	 
}
