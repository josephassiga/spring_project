<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<meta content="charset=UTF-8">
<script>
	$(function() {
		$("input[type=submit], a, button").button();
		$("#datepicker").datepicker();
		$("#datepicker2").datepicker();
		$('#checkbox').change(function() {
			if ($(this).is(":checked")) {
				$("#friend").show();
			} else {
				$("#friend").hide();
			}

		});
	});
</script>
<style type="text/css">
input[type=submit] {
	margin-top: 20px;
	margin-left: 5px;
	width: 8em;
	height: 4em;
	margin-left: 10px;
}

label {
	display: inline-block;
	width: 250px;
	text-align: left;
	margin-left: 30px
}

body {
	margin-left: auto;
	margin-right: auto;
	width: 700px;
	margin-top: 100px
}

#tablePersonnes {
	margin-top: 20px;
}

table {
	/* 	border-width: 1px; */
	border-style: solid;
	border-color: black;
	width: 650px;
	background-color: #89CFF0;
}

td {
	border-width: 1px;
	border-style: solid;
	width: 100px;
}

tr {
	border-width: 1px;
	border-style: solid;
	border: 1px;
	width: 100px;
}

table,th,td {
	border: 1px solid black;
}

tr:hover {
	background-color: #7BB661;
}

#form {
	margin-top: 40px;
}

h1 {
	font-size: 40px;
	margin-left: 20px;
	color: green;
	font-family: monospace;
}

#friend {
	display: none;
}

input[type=checkbox] {
	margin-left: 10px;
	margin-top: 10px;
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>SpringMVC</title>
</head>
<body>
	<h1>TP SPRING FRAMEWORK CRUD</h1>
	<div id="form">
		<form:form commandName="formulaireBean" method="POST">			
			<div id="personne">
				<label>id :</label>
				<form:input path="personneDO.idPersonne" size="35px" width="20px"/>
				<font color='red'><form:errors path="personneDO.idPersonne" cssClass="error" /></font>
				<label>Nom :</label>
				<form:input path="personneDO.nom" size="35px"/>
				<font color='red'><form:errors path="personneDO.nom" cssClass="error" /></font>
				<label>Date de Naissance :</label>
				<form:input path="personneDO.dateNaissance" id="datepicker" size="35px"/>
				<font color='red'><form:errors path="personneDO.dateNaissance" cssClass="error" /></font> <br>
			</div>
			
			<input type="checkbox" name="friend" value="friend" id="checkbox"> Ajouter des Amis<br>
			
			<div id="friend">
				<label>Friend id :</label>
				<form:input path="friendDO.idPersonne" size="35px" width="20px"/>
				<font color='red'><form:errors path="friendDO.idPersonne" cssClass="error" /></font>
				<label>Friend Nom:</label>
				<form:input path="friendDO.nom" size="35px"/>
				<font color='red'><form:errors path="friendDO.nom" cssClass="error" /></font>
				<label>Friend Date de Naissance :</label>
				<form:input path="friendDO.dateNaissance" id="datepicker2" size="35px"/>
				<font color='red'><form:errors path="friendDO.dateNaissance"  cssClass="error" /></font> <br>
			</div>
			
			<input type="submit" id="Save" formaction="createPersonne"
				value="create" size="30px" />
			<input type="submit" id="Update" formaction="updatePersonne"
				value="udate" size="30px" />
			<input type="submit" id="Delete" formaction="deletePersonne"
				value="delete" size="30px" />
			<input type="submit" id="Friend" formaction="addFriend"
				value="addFriend" size="30px" />
		</form:form>
	</div>

	<div id="tablePersonnes">
		<table>
			<tr>
				<th>id</th>
				<th>Nom</th>
				<th>Date De Naissance</th>
			</tr>
			<c:forEach items="${personnes}" var="p">
				<tr>
					<td>${p.idPersonne}</td>
					<td>${p.nom}(${p.tailleListeAmis})</td>
					<td>${p.dateNaissance}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>