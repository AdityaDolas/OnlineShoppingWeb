<%@page import="com.aditya.pojo.Product"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Product List</title>

<style type="text/css">
.con {
	
}
</style>

</head>
<body>


	<%List<Product> al=(List<Product>)session.getAttribute("plist"); %>

	<%-- <jsp:include page="BG.jsp"></jsp:include> --%>

	<jsp:include page="ANavbar.jsp"></jsp:include>

	<div class="con">
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Product Name</th>
					<th scope="col">Product Price</th>
					<th scope="col">Product QTY</th>
					<th scope="col">Product Category</th>
					<th scope="col">Product Description</th>
					<th scope="col">Action</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>

				<%for (Product p : al) {%>

				<tr>
					<th scope="row">1</th>
					<td><%=p.getPName() %></td>
					<td><%=p.getPPrice() %></td>
					<td><%=p.getPQuantity() %></td>
					<td><%=p.getPCategory() %></td>
					<td><%=p.getPDescript() %></td>
					<td><a href="UpdateProduct.jsp">
							<button class="btn btn-warning btn-sm" type="submit">Edit</button></td>
					<td>
						<button class="btn btn-danger btn-sm" type="submit">Delete</button>
					</td>
				</tr>

			</tbody>
		<%} %>
		</table>
	</div>

	<!-- Optional JavaScript -->	
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>