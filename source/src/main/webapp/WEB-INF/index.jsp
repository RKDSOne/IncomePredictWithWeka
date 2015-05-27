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
			PersonalInfo user = (PersonalInfo) request.getAttribute("user");
		%>
		<div class="container">
			<h1>CS559 Machine learning final project</h1>
			<div class="row-fluid">
				<div class="col-md-3">
					<%=calendar.getTime().toString()%>
				</div>
				<div class="col-md-9">
					<h2>Input information</h2>
					<p>This program is using machine learning technology to predict your income</p>
					<p>Pleaser input below information</p>
					<form class="form form-horizontal col-md-5" method="post">
						<div class="form-group">
							<label for="name">Name:</label> <input type="text"
								class="form-control" name="name" />
						</div>
						 
						<div class="form-group">
							<label for="slctAge">Select your age:</label> 
							<select	class="form-control col-lg-1" id="slctAge" name="slctAge">
								<c:forEach items="${age}" var="ageList">
									<option value="${ageList.value }">${ageList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctWorkClass">Select your work class:</label> 
							<select class="form-control col-lg-1" id="slctWorkClass" name="slctWorkClass">
								<c:forEach items="${workclass}" var="workclassList">
									<option value="${workclassList.value }">${workclassList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctEducation">Select your education level:</label> 
							<select class="form-control col-lg-1" id="slctEducation" name="slctEducation">
								<c:forEach items="${education}" var="educationList">
									<option value="${educationList.value }">${educationList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctMaritalStatus">Select your marital status:</label> 
							<select class="form-control col-lg-1" id="slctMaritalStatus" name="slctMaritalStatus">
								<c:forEach items="${maritalStatus}" var="maritalStatusList">
									<option value="${maritalStatusList.value }">${maritalStatusList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctOccupation">Select your occupation:</label> 
							<select class="form-control col-lg-1" id="slctOccupation" name="slctOccupation">
								<c:forEach items="${occupation}" var="occupationList">
									<option value="${occupationList.value }">${occupationList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctRelationship">Select your relationship:</label> 
							<select class="form-control col-lg-1" id="slctRelationship" name="slctRelationship">
								<c:forEach items="${relationship}" var="relationshipList">
									<option value="${relationshipList.value }">${relationshipList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctRace">Select your race:</label> 
							<select class="form-control col-lg-1" id="slctRace" name="slctRace">
								<c:forEach items="${race}" var="raceList">
									<option value="${raceList.value }">${raceList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctSex">Select your sex:</label> 
							<select class="form-control col-lg-1" id="slctSex" name="slctSex">
								<c:forEach items="${sex}" var="sexList">
									<option value="${sexList.value }">${sexList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctCapitalGain">Select your capitalGain:</label> 
							<select class="form-control col-lg-1" id="slctCapitalGain" name="slctCapitalGain">
								<c:forEach items="${capitalGain}" var="capitalGainList">
									<option value="${capitalGainList.value }">${capitalGainList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctCapitalLoss">Select your capitalLoss:</label> 
							<select class="form-control col-lg-1" id="slctCapitalLoss" name="slctCapitalLoss">
								<c:forEach items="${capitalLoss}" var="capitalLossList">
									<option value="${capitalLossList.value }">${capitalLossList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctHoursPerWeek">Select your hoursPerWeek:</label> 
							<select class="form-control col-lg-1" id="slctHoursPerWeek" name="slctHoursPerWeek">
								<c:forEach items="${hoursPerWeek}" var="hoursPerWeekList">
									<option value="${hoursPerWeekList.value }">${hoursPerWeekList.key }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="slctNativeCountry">Select your NativeCountry:</label> 
							<select class="form-control col-lg-1" id="slctNativeCountry" name="slctNativeCountry">
								<c:forEach items="${nativeCountry}" var="nativeCountryList">
									<option value="${nativeCountryList.value }">${nativeCountryList.key }</option>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>


					</form>

				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="bootstrap/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
</body>
</html>