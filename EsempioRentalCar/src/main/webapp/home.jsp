<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rental Car</title>

<style type="text/css">
body {
	text-align: center;
}

table {
	margin-left: 15%;
	min-width: 70%;
	border: 1px solid #CCC;
	border-collapse: collapse;
}

table tr {
	line-height: 30px;
}

table tr th {
	background: #000033;
	color: #FFF;
}

table tr td {
	border: 1px solid #CCC;
	margin: 5px;
}

input[type=text], input[type=email], input[type=tel] {
	min-width: 60%;
}

input[type=submit], a {
	background: green;
	padding: 5px;
	margin: 5px;
	color: #FFF;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<h1>Rental Car</h1>
	<c:url value="/utente/registrazione" var="registerUrl" />
	<form action="${registerUrl}" method="post">
		<table>
			<c:if test="${utente.id ne null}">
				<tr>
					<td>Utente ID:</td>
					<td><input type="text" name="id" value="${utente.id}"
						readonly="readonly"></td>
				</tr>
			</c:if>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" value="${utente.nome}"
					required></td>
			</tr>
			<tr>
				<td>Cognome:</td>
				<td><input type="text" name="cognome" value="${utente.cognome}"
					required></td>
			</tr>
			<tr>
				<td>Anno Nascita:</td>
				<td><input type="text" name="anno nascita"
					value="${utente.annoNascita}" required></td>
			</tr>
			<!-- 			<tr> -->
			<!-- 				<td>Mobile:</td> -->
			<%-- 				<td><input type="tel" name="mobile" value="${customer.mobile}" required></td> --%>
			<!-- 				pattern="[789][0-9]{9}" -->
			<!-- 			</tr> -->

			<c:if test="${utente.id ne null}">
				<tr>
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
			</c:if>
			<c:if test="${utente.id eq null}">
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</c:if>
		</table>
	</form>
	<br>
	<h1>Lista Utenti</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Anno Nascita</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${listaUtenti}" var="utente">
			<tr>
				<td>${utente.id}</td>
				<td>${utente.nome}</td>
				<td>${utente.cognome}</td>
				<td>${utente.annoNascita}</td>

				<td>
					<form action="<c:url value="/utente/update"/>" method="post">
						<input type="hidden" name="utenteId" value="${utente.id}">
						<input type="submit" value="Update">
					</form>
				<td>
					<form action="<c:url value="/utente/cancellazione"/>" method="post">
						<input type="hidden" name="utenteId" value="${utente.id}">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>