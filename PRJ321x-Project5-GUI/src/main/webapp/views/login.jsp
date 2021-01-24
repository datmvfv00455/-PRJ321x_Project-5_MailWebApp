<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<fmt:message
	var="placeholder_user"
	key="label.placeholder.user"
	bundle="${messages}" />
<fmt:message
	var="placeholder_password"
	key="label.placeholder.password"
	bundle="${messages}" />
<fmt:message
	var="label_login"
	key="label.login"
	bundle="${messages}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>${label_login}</title>
<!-- Custom fonts for this template-->
<link
	href="<c:url value='/templete/home/vendor/fontawesome-free/css/all.min.css'/>"
	rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link
	href="<c:url value='/templete/home/css/sb-admin-2.min.css'/>"
	rel="stylesheet">
</head>
<body class="bg-gradient-primary">
	<div class="container">
		<!-- Outer Row -->
		<div class="row justify-content-center">
			<div class="col-xl-10 col-lg-12 col-md-9 ">
				<div class="card o-hidden border-0 shadow-lg my-5">
					<!-- Nested Row within Card Body -->
					<div class="row">
						<div class="col-lg-12">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">${label_login}</h1>
								</div>
								<form
									class="login-form user"
									method="post">
									<div class="form-group ">
										<input
											type="text"
											class="form-control form-control-user"
											name="bean.userName"
											placeholder="${placeholder_user }">
									</div>
									<div class="form-group">
										<input
											type="password"
											class="form-control form-control-user"
											name="bean.userPassword"
											placeholder="${placeholder_password }">
									</div>
									<button
										class="btn btn-primary btn-user btn-block"
										type="submit">${label_login}</button>
								</form>
								<hr>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- BEGIN FOOTER -->
	<%@include file="/common/footer.jsp"%>
	<script src="templete/home/js/login.js"></script>
	<!-- END FOOTER -->
</body>
</html>
