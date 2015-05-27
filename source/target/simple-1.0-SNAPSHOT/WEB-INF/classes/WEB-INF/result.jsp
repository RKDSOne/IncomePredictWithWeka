<%@ page import="java.util.Calendar"%>
<%@ page import="com.mantiso.PersonalInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title><%=application.getInitParameter("ProductName")%></title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="metro-bootstrap-master/css/metro-bootstrap.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="_header.jsp"%>
	<section class="main container-fluid">
		<%
			Calendar calendar = Calendar.getInstance();
			String classifierName = (String) request.getAttribute("classifierName");
					
		%>
		<div class="container">
			<h1>CS559 Machine learning final project</h1>
			<div class="row-fluid">
				<div class="col-md-3">
					<%=calendar.getTime().toString()%>
					
				</div>
				
				
				<div class="col-md-9">
				<div><hr></div>
					<h2>Result of <%=classifierName %></h2>
					<b></b>
				<c:forEach var="resultItem" items="${result}">
				<p><c:out value = "${resultItem}"/>
				</p>
				</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="bootstrap/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
</body>
</html>