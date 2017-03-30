<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Test</title>
	</head>
	<body>
		<jsp:useBean id="client" class="lionel.tochap.ngassam.beans.Client" />
		<jsp:setProperty name="client" property="nom" value="Tochap Ngassam" />
		<c:out value="${ client.nom }<br />" escapeXml="true" default="Default name" />
		<c:out value="${ 'a' < 'b' }" />
		<%-- ${ client.nom } --%>
		<br />
		
		
		<%-- Mise en attribut d'une variable equivalent au setAttribute() : Creation d'une variable--%>
		<c:set var="message" value="Salut les zéros" scope="request" />
		
		<%-- Affichage de la variable --%>
		<c:out value="${ requestScope.message }">
		Affichage par defaut si value est null
		</c:out>
		
		<%-- Modification d'une variable --%>
		<c:set var="locale" scope="session">
			<c:out value="${param.lang}" default="FR"></c:out>
		</c:set>
		
		
		<c:set target="${client}" property="prenom" value="Wile E."></c:set>
		
	</body>
</html>