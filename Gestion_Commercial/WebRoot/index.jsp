<%@ page language="java" pageEncoding="ISO-8859-1"%>



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
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
</head>

  
<body>
<center>
<div class="container">
		<footer>
		BY :	El Maazouzi Zakaria QL | Marrakchi Amr QL | El Morabit Sofiane QL | El Moussaoui Romaysae M2I
		</footer>
			<header class="codrops-header">
				<img src="img/x.png" style="margin-top :-45px; margin-bottom : -20px" width="245" height="245"/>
				<h1><span>Login to your account</span></h1>
			</header>
			
			
	<form action="login.do">
	<section style=" margin-top : -80px; margin-bottom :-20px" class="content">
				<span class="input input--ichiro">
					<input class="input__field input__field--ichiro" name="login" type="text" id="input-1" />
					<label class="input__label input__label--ichiro" for="input-1">
						<span class="input__label-content input__label-content--ichiro">LOGIN</span>
					</label>
				</span>
				<span class="input input--ichiro">
					<input class="input__field input__field--ichiro" name="pass" type="password" id="input-2" />
					<label class="input__label input__label--ichiro" for="input-2">
						<span class="input__label-content input__label-content--ichiro">PASSWORD</span>
					</label>
				</span><br/><br/>
				<input class="button-x" type="submit" value="LOGIN" name="login" />
	</form>
	</section>
	
</center>	
</body>
</html>