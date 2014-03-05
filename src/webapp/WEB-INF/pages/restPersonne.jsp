<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app>
<head>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<meta content="charset=UTF-8">
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.12/angular.min.js"></script>
<script>
	$(function() {

		$("a").button();
		$("#create").hide();
		$("#delete").hide();
		$("#update").hide();
		$("#ajoutAmis").hide();

		$("input[type=radio]").change(function() {
			var value = $(this).val();
			if (value == 'create') {
				$("#create").show();
				$("#delete").hide();
				$("#update").hide();
				$("#ajoutAmis").hide();
			} else if (value == 'delete') {
				$("#create").hide();
				$("#delete").show();
				$("#update").hide();
				$("#ajoutAmis").hide();
			} else if (value == 'update') {
				$("#create").hide();
				$("#delete").hide();
				$("#update").show();
				$("#ajoutAmis").hide();
			} else {
				$("#create").hide();
				$("#delete").hide();
				$("#update").hide();
				$("#ajoutAmis").show();
			}

		});

		$("#datepicker").datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$("#datepicker2").datepicker();
		$('#rad').change(function() {
			if ($(this).is(":checked")) {
				$("#friend").show();
			} else {
				$("#friend").hide();
			}

		});
	});
</script>
<style type="text/css">
#create,#delete,#update,#ajoutAmis {
	margin-top: 20px;
	width: 8em;
	height: 4em;
	padding-top: 20px;
	margin-left: 100px;
	float: left;
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
	margin-top: 100px;
	text-align: center;
}

#tablePersonnes {
	/* 	border-width: 1px; */
	border-style: solid;
	border-color: black;
	width: 650px;
	background-color: #89CFF0;
	margin-top: 20px;
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

th,td {
	border: 1px solid black;
}

#tablePersonnes>tr:hover {
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

#lien {
	margin-top: 50px;
}
</style>
<title>REST | SpringMVC</title>
</head>
<body>
	<h1>TP SPRING FRAMEWORK CRUD</h1>
	<h1>REST SERVICES</h1>
	<div id="form">
		<form:form commandName="formulaireBean">
			<div id="personne">
				<label>id :</label>
				<form:input path="personneDO.idPersonne" ng-model="id" size="40px"
					width="20px" />
				<label>Nom :</label>
				<form:input path="personneDO.nom" ng-model="nom" size="40px" />
				<label>Date de Naissance :</label>
				<form:input path="personneDO.dateNaissance" ng-model="dateNaissance"
					id="datepicker" size="40px" />
				<br>
			</div>
			<input type="radio" name="personne" value="create" id="radio_1"> create
			<input type="radio" name="personne" value="update" id="radio_2"> update
			<input type="radio" name="personne" value="delete" id="radio_3"> delete
			<input type="radio" name="personne" value="addFriend" id="radio_4"> Ajouter des Amis<br>

			<div id="submitButtons">
				<a href="rest/ajoutPersonne/{{id}}/{{nom}}/{{dateNaissance}}"
					id="create">create</a> <a
					href="rest/miseAjourPersonne/{{id}}/{{nom}}/{{dateNaissance}}"
					id="update">update</a> <a
					href="rest/supprimePersonne/{{id}}/{{nom}}/{{dateNaissance}}"
					id="delete">delete</a> <a
					href="rest/ajoutAmis/{{id}}/{{nom}}/{{dateNaissance}}"
					id="ajoutAmis">ajoutAmis</a>
			</div>
		</form:form>
	</div>
	<h2 id="lien">link : {{id}}/{{nom}}/{{dateNaissance}}</h2>
	<table id="tablePersonnes">
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
</body>
</html>