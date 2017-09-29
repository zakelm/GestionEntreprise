<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ page import="serviceWS.*" %>
<%@ page import="service.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.servlet.http.HttpSession" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
 	    <meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>List</title>
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
</head>
  
<body>
<div class="container">
		<footer>
		BY :	El Maazouzi Zakaria QL | Marrakchi Amr QL | El Morabit Sofiane QL | El Moussaoui Romaysae M2I
		</footer>
			<header class="codrops-header">
				<img src="img/x.png" style="margin-top :-45px; margin-bottom : -20px" width="245" height="245"/>
				<h1><span>SUNGLASSES LIST<br/>
					Caissier [  <% 
	 				HttpSession sess = request.getSession();
	 				out.print(sess.getAttribute("login")); %> 
	 				 ] </span></h1>
		</header> <br/>
		<%			
		// extraire les informations depuis le webservice	
		 LunettesServiceClient client = new LunettesServiceClient();  
		 LunettesServicePortType service = client.getLunettesServiceHttpPort(); 	  
		      
		 List enregistrement =service.selectLunettes().getArrayOfString();
		 
		//////////////////////////////////////////////////////////////////////  
			
			%>
			
			
					 <% 		 
			// extraire les informations depuis l'ejb		
			serviceRemote bean=null;
			int qte=0;
			
			try {	
	        
	        InitialContext ctx;
			Properties props = new Properties();
	        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
	        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
	        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
	        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");		        
	        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
			
	        ctx = new InitialContext(props);
			bean = (serviceRemote) ctx.lookup("ejb/service");	
	
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//////////////////////////////////////////////////////////////////////
			 
				for(int i=0; i< enregistrement.size(); ++i){
				
				// reccuperer la liste des lunettes existant sur le web service
					List enregistrementParLun = service.selectLunettes().getArrayOfString().get(i).getString();
					int codeL = Integer.parseInt(enregistrementParLun.get(2).toString());
			
				// réccuperer la quantitée de chaque lunettes à partir de l'EJB
				String[][] result = bean.getLunettesQte();
							
				for(int j=0; j<result.length; ++j){
					if(codeL == Integer.parseInt(result[j][1])){
						qte= Integer.parseInt(result[j][2]);
					}
				}
				
				%> 
				
	<div class="product">
	<center>
	   <img src="img/lunettes/<%=codeL%>.jpg" width="210"/>
		<div id="info">
		<div id="name"><%= enregistrementParLun.get(0).toString() %></div>
		<div id="text">Product ID : <%=codeL%></div>
		<div id="text"><%= qte %> units in stock</div>
		<div id="desc"><p><%= enregistrementParLun.get(1).toString() %></p></div>
		<div id="price"><%= Integer.parseInt(enregistrementParLun.get(3).toString()) %> DH</div>
		</div>
		<div id="commander">
		<a href="commander.jsp?codeL=<%= codeL %>&prixL=<%= Integer.parseInt(enregistrementParLun.get(3).toString()) %>" >order now</a>
	</div>	
	</center>
	</div>		
 
			 <% 		 	
				 	
				 }
			 %>
	
</body>
</html>