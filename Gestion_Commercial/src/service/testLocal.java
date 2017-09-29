package service;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class testLocal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub    
		
        try {	
        
        InitialContext ctx;
		Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");		        
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		
        ctx = new InitialContext(props);
		serviceRemote bean = (serviceRemote) ctx.lookup("ejb/service");
		//boolean t=bean.updateMag(1, 2);
		//boolean t1=bean.updateMag(2, 2);
		//System.out.println(t + "   " + t1);
		
		String [][] result = bean.getLunettesQte();
		
		for(int i=0; i<result.length; ++i){
			System.out.println("code magasin "+result[i][0]);
			System.out.println("code lunette "+result[i][1]);
			System.out.println("quantité lunettes "+result[i][2]);
		}
		

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
