<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>

<!-- reference our style sheet -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">
			<!-- put add button here  -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAddCustomer';return false;"
				class="add-button" />

			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<!-- counstruct an update link with customer Id -->
					<c:url var="updatelink" value="/customer/showFormForUpdate">
					
					<c:param name="customerId" value="${tempCustomer.id }"/>
					</c:url>
					<c:url var="deletelink" value="/customer/delete">
					
					<c:param name="customerId" value="${tempCustomer.id }"/>
					</c:url>
					<tr>
						<td>${tempCustomer.first_name}</td>
						<td>${tempCustomer.last_name}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- display the update link -->
							<a href="${updatelink}">Update</a>|<a href="${deletelink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









