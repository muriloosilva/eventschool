<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EventoSchool</title>
<link href="css/cadastrarEvento.css" rel="stylesheet" type="text/css" />
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
         		
         		<div id="acessar" align="center" class="fontTitulo">CADASTRAR EVENTO</div>
         		<div id="erro">*Evento já cadastrado</div>
         		
         		<div class="fontTitulo">Nome:</div>
	         	<input id="caixaEmail" type="text" name="nome"/>
	         	
	         	<div class="fontTitulo">Descrição:</div>
	         	<input id="caixaEmail" type="text" name="descricao"/>
         	
	         	<div class="fontTitulo">Local:</div>
	         	<input id="caixaEmail" type="text" name="local"/>
	         	
	         	<div class="fontTitulo">Data Inicio:</div>
	         	<input id="caixaSenha" type="text" name="inicio"/>
	         	
	         	<div class="fontTitulo">Data Fim:</div>
	         	<input id="caixaSenha" type="text" name="fim"/>
	         	
	         	<div class="fontTitulo">Data inicio inscrições:</div>
	         	<input id="caixaSenha" type="text" name="inicioInscricoes"/>
	         	
	         	<div class="fontTitulo">Data fim inscrições:</div>
	         	<input id="caixaSenha" type="text" name="fimInscricoes"/>
	         	
	         	<div class="fontTitulo">Telefone:</div>
	         	<input id="caixaSenha" type="text" name="telefone"/>
	         	
	         	<div class="fontTitulo">E-mail:</div>
	         	<input id="caixaSenha" type="text" name="email"/>
	         	
	         	<div id="login" align="center"><input type="button" value="Cancelar"/><input type="button" value="Cadastrar"/></div>
	         </div>
         </div>
	</div>
</body>
</html>