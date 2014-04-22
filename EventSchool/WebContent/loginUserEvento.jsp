<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EventoSchool</title>
<link href="css/loginUser.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="principal">
		 <div id="top"></div>
		 <div id="menuHeader">
         	<a id="eventos" class="fontMenu" href="#">Eventos</a>
           	<a id="contato" class="fontMenu" href="#">Contato</a>
         </div>
         <div id="corpo">
         	<div id="loginUser">
         		
         		<div id="acessar" align="center" class="fontTitulo">Acessar o EventSchool</div>
         		<div id="erro">*Usuário ou senha incorreto</div>
         	
	         	<div class="fontTitulo">E-mail:</div>
	         	<input id="caixaEmail" type="text" name="e-mail"/>
	         	
	         	<div class="fontTitulo">Senha:</div>
	         	<input id="caixaSenha" type="text" name="senha"/>
	         	
	         	<div id="login" align="center"><input type="button" value="Fazer login"/> ou <a href="#">Cadastra-se</a></div>
	         </div>
         </div>
	</div>
</body>
</html>