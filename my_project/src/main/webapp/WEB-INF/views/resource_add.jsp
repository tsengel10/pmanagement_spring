<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<script src="<spring:url value="/resources/js/resource.js"/>"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<div class="container">

		<div class="row">
			<h1>Resource</h1>

			<spring:url value="/resource/review" var="formUrl" />
			<form:form method="POST" action="${formUrl }"
				modelAttribute="resource" cssClass="col-md-8 col-md-offset-2">
				<div class="row">

					<div class="form-group">
						<label for="resource-name">Name</label>
						<!--  <input type="text"
						id="resource-name" class="form-control" name="name" />
					-->
						<form:input path="name" cssClass="form-control" id="resource-name" />
					</div>

					<div class="form-group">
						<label for="resource-type">Type</label>
						<form:select path="type" cssClass="selectpicker">
							<form:options items="${typeOptions}" />
						</form:select>

					</div>

					<div class="form-group">
						<label for="cost">Cost</label> <input id="cost" type="text"
							class="form-control" name="cost" />
					</div>

					<div class="form-group">
						<label for="unit">Unit of Measure</label>
						<form:radiobuttons id="unit" path="unitOfMeasure"
							items="${radioOptions }" />
					</div>

					<div class="form-group">
						<label for="indicators">Indicators</label>
						<form:checkboxes id="indicators" path="indicators"
							items="${checkOptions }" />
						<a id="request-link"
							href='<spring:url value="/resource/request" />'>Send request</a>
					</div>

					<div class="form-group">
						<label for="notes">Notes</label>
						<form:textarea id="notes" path="notes" cssClass="form-control"
							rows="3" />
					</div>

					<button type="submit" class="btn btn-default">Submit</button>

				</div>
			</form:form>

			<spring:url value="/resource/upload" var="uploadUrl"></spring:url>
			<form method="POST" enctype="multipart/form-data"
				action="${uploadUrl }">
				file to upload: <input type="file" name="file" /><br /> <input type="submit"
					value="upload" />
			</form>
		</div>
	</div>
</body>
</html>