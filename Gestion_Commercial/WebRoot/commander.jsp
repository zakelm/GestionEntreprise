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
		<title>Order</title>
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />

</head>
  
<body>
<center>
		<footer>
		BY :	El Maazouzi Zakaria QL | Marrakchi Amr QL | El Morabit Sofiane QL | El Moussaoui Romaysae M2I
		</footer>
			<header class="codrops-header">
				<img src="img/x.png" style="margin-top :-45px; margin-bottom : -20px" width="245" height="245"/>
				<h1><span>Welcome [<% 
	 	HttpSession sess = request.getSession();
	 	out.println(sess.getAttribute("login"));  
	%> ]</span></h1>
			</header>

	<form action="commander.do">
		<section style=" margin-top : -80px; margin-bottom :-20px" class="content">
				<span class="input input--ichiro">
					<input class="input__field input__field--ichiro" name="nomC" type="text" id="input-1" />
					<label class="input__label input__label--ichiro" for="input-1">
						<span class="input__label-content input__label-content--ichiro">CLIENT NAME</span>
					</label>
				</span><br/>
				<span class="input input--ichiro">
					<input class="input__field input__field--ichiro" name="codeCmd" type="text" id="input-2" />
					<label class="input__label input__label--ichiro" for="input-2">
						<span class="input__label-content input__label-content--ichiro">ORDER CODE</span>
					</label>
				</span><br/>
				<span class="input input--ichiro">
					<input class="input__field input__field--ichiro" name="qteCmd" type="text" id="input-3" />
					<label class="input__label input__label--ichiro" for="input-3">
						<span class="input__label-content input__label-content--ichiro">QUANTITY</span>
					</label>
				</span><br/>
						<input type="hidden" name="codeL" value="1" />
						<% 
						// on réccupère les données envoyées dans l'url 
						// et on les stocke dans la session pour les utilisées dans 
						// la création de la facture
				
		   				sess.setAttribute("codeL" , request.getParameter("codeL")); 
		   				sess.setAttribute("prixL" , request.getParameter("prixL"));
						%>
				<br/><br/>
					<input class="button-x" type="submit" value="ORDER" name="commander" />
	</form>
	</section>
</center>
</body>
</html>