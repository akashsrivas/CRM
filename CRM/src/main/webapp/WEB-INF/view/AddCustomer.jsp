<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddCustomer</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/addCustomer.css" />


</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Customer</h3>
		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
			<!-- need to assosiate this data with customer id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="first_name" />
							</form></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="last_name" />
							</form></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" />
							</form></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" />
						</form></td>
					</tr>

				</tbody>
			</table>
		</form:form>

		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to List</a>
		</p>

	</div>
</body>
</html>