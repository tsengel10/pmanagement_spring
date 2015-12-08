<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">

			<spring:url value="/project/add" var="formAddProjectUrl" />
			<form:form action="${formAddProjectUrl }"
				cssClass="col-md-8 col-md-offset-2" method="POST"
				modelAttribute="project">

				<div class="form-group">
					<label for="project-name">Name</label>
					<form:input id="project-name" path="name" cssClass="form-control" />
					<form:errors path="name" />
				</div>

				<div class="form-group">
					<label for="project-type">Type</label>
					<form:select path="type" cssClass="selectpicker">
						<form:options items="${yearOptions}" />
					</form:select>
				</div>

				<div class="form-group">
					<label for="sponsor-name">Sponsor name</label>
					<form:input id="sponsor-name" cssClass="form-control"
						path="sponsor.name" />

				</div>

				<div class="form-group">
					<label for="sponsor-phone">Sponsor phone</label>
					<form:input id="sponsor-phone" cssClass="form-control"
						path="sponsor.phone" />
				</div>

				<div class="form-group">
					<label for="sponsor-email">Sponsor email</label>
					<form:input id="sponsor-email" cssClass="form-control"
						path="sponsor.email" />
				</div>

				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<form:input id="funds" path="authorizedFunds"
						cssClass="form-control" />
				</div>

				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<form:input id="hours" path="authorizedHours"
						cssClass="form-control" />
				</div>

				<div class="form-group">
					<label for="description">Description</label>
					<form:textarea id="description" path="description"
						cssClass="form-control" rows="3" />
					<form:errors path="description" />
				</div>

				<div class="form-group">
					<label for="startDate">Start Date</label>
					<form:input id="startDate" path="startDate" cssClass="form-control" />
				</div>

				<div class="form-group">
					<label for="poc1">POC-1</label>
					<form:input id="poc1" cssClass="form-control"
						path="pointsOfContact[0]" />
				</div>

				<div class="form-group">
					<label for="poc2">POC-2</label>
					<form:input id="poc2" cssClass="form-control"
						path="pointsOfContact[1]" />
				</div>

				<div class="form-group">
					<label for="poc3">POC-3</label>
					<form:input id="poc3" cssClass="form-control"
						path="pointsOfContact[2]" />
				</div>

				<div class="form-group">
					<label for="special">Special</label>
					<form:checkbox id="special" path="special" />
				</div>



				<button type="submit" class="btn btn-default">Submit</button>

			</form:form>

		</div>
	</div>
</body>
</html>