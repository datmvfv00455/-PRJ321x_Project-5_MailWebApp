<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Page Not Found</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value='/templete/home/vendor/fontawesome-free/css/all.min.css'/>"
	rel="stylesheet" type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value='/templete/home/css/sb-admin-2.min.css'/>"
	rel="stylesheet">

</head>
<body id="page-top">

	<div id="wrapper">

		<!-- HEADER -->
		<%@include file="/common/header.jsp"%>
		<!-- END HEADER -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<nav
				class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top  ">

				<!-- Sidebar Toggle (Topbar) -->
				<button id="sidebarToggleTop"
					class="btn btn-link d-md-none rounded-circle mr-3">
					<i class="fa fa-bars"></i>
				</button>

				<div id="requirement-title"
					style="padding-right: .75rem; padding-left: .75rem; color: #4e73df; font-weight: 600 !important;">
					Error</div>
			</nav>

			<!-- Main Content -->
			<div id="content">

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- 404 Error Text -->
					<div class="text-center">
						<div class="error mx-auto" data-text="404">404</div>
						<p class="lead text-gray-800 mb-5">Page Not Found</p>

						<a href='<c:url value="/"  /> '>&larr; Back to All Posts</a>
					</div>

				</div>
				<!-- /.container-fluid -->


			</div>


			<!-- Footer -->
			<footer
				class="container sticky-footer bg-white container my-auto copyright">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Your Website 2019</span>
					</div>
				</div>
			</footer>

			<!-- End of Footer -->

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- End of Main Content -->


	<!-- BEGIN FOOTER -->
	<%@include file="/common/footer.jsp"%>
	<!-- END FOOTER -->
</body>
</html>