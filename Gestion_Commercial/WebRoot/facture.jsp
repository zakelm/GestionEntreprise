<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="com.lowagie.text.*" %>
<%@ page import="com.lowagie.text.pdf.*" %>
<%@ page import="com.lowagie.text.Image" %>
<%@ page import="java.io.File" %> 
<%@ page import="java.io.FileOutputStream" %> 
<%@ page import="java.io.OutputStream" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>My JSF 'facture.jsp' starting page</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
  
<body>
	<%
		HttpSession sess = request.getSession();
		// reccupoeration des données pour les utilisée dans le pdf
		
		String client = request.getAttribute("nomC").toString();
		int codeL = Integer.parseInt(sess.getAttribute("codeL").toString());
		int codeCmd = Integer.parseInt(request.getAttribute("codeCmd").toString());
		int qteCmd = Integer.parseInt(request.getAttribute("qteCmd").toString());
		int prix = Integer.parseInt(request.getAttribute("prixL").toString());
		
		// creation du document PDF
		
		response.setContentType("application/pdf");	
		
		OutputStream file = new FileOutputStream(new File("C:\\work/Facture"+codeCmd+".pdf"));
 
            Document document = new Document();
           
 			PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            
            Image logo = Image.getInstance("C:\\Users/Zakaria/Workspaces/MyEclipse 8.6/gestionCommercial/WebRoot/css/images/x.png");
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);
            
            Paragraph parag = new Paragraph("Société RayBan pour vente des Lunettes.");
            parag.setAlignment(Element.ALIGN_CENTER);
            document.add(parag);
            
            Paragraph parag2 = new Paragraph("Facture de Payement.");
            parag2.setAlignment(Element.ALIGN_CENTER);
            document.add(parag2);
            
			document.add( Chunk.NEWLINE );
        	document.add( Chunk.NEWLINE );
        	
        	java.util.Date date = new java.util.Date();
			document.add(new Paragraph(
			    "Date de la facture " +"  " + date));
			document.add( Chunk.NEWLINE );
			
			document.add(new Paragraph(
			    "Nom Client: " +"  " + client));
			document.add( Chunk.NEWLINE );
			
			document.add(new Paragraph(
			    "Code Lunettes: " +"  " + codeL));
			document.add( Chunk.NEWLINE );
			
			document.add(new Paragraph(
			    "Commande N°: " +"  " + codeCmd));
			document.add( Chunk.NEWLINE );
			
			document.add(new Paragraph(
			    "Quantité de la Commande: " +"  " + qteCmd));
			document.add( Chunk.NEWLINE );
			
			document.add(new Paragraph(
			    "Prix par unité " +"  " + sess.getAttribute("prixL")));
			document.add( Chunk.NEWLINE );
			
			document.add(new Paragraph(
			    "Prix Total: " +"  " + prix)); 		
			document.add( Chunk.NEWLINE );
				    
			document.add(new Paragraph(
			    "\n merci pour votre fidélité !")); 
			
            document.close(); 
	 %>
	 
</body>
</html>