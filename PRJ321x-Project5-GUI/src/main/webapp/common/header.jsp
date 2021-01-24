<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ include file="/common/taglib.jsp"%>

<%@ page import="vn.funix.prj321x.project5.gui.common.WebConstant"%>

<c:url
	var="mailLoginForm"
	value="<%=WebConstant.URL_MAIL_LOGIN%>"
/>
<c:url
	var="urlMailLogout"
	value='<%=WebConstant.URL_MAIL_LOGOUT%>'
/>




<c:url
	var="urlMailNew"
	value='<%=WebConstant.URL_MAIL_NEW%>'
/>



<c:url
	var="urlSystemLogout"
	value='<%=WebConstant.URL_SYSTEM_LOGOUT%>'
/>


<fmt:message
	var="label_sidebarbrand"
	key="label.sidebarbrand"
	bundle="${messages}"
/>
<fmt:message
	var="label_requirement"
	key="label.requirement"
	bundle="${messages}"
/>
<fmt:message
	var="label_requirement1"
	key="label.requirement1"
	bundle="${messages}"
/>
<fmt:message
	var="label_requirement2"
	key="label.requirement2"
	bundle="${messages}"
/>
<fmt:message
	var="label_requirement3"
	key="label.requirement3"
	bundle="${messages}"
/>
<fmt:message
	var="label_requirement4"
	key="label.requirement4"
	bundle="${messages}"
/>
<fmt:message
	var="label_requirement5"
	key="label.requirement5"
	bundle="${messages}"
/>

<fmt:message
	var="label_advanced"
	key="label.advanced"
	bundle="${messages}"
/>
<fmt:message
	var="label_advanced1"
	key="label.advanced1"
	bundle="${messages}"
/>


<fmt:message
	var="placeholder_password"
	key="label.placeholder.password"
	bundle="${messages}"
/>
<fmt:message
	var="label_login"
	key="label.login"
	bundle="${messages}"
/>



<div
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar"
>

	<!-- Sidebar Brand -->
	<a
		href='<c:url value='/' /> '
		class="sidebar-brand 
		d-flex align-items-center justify-content-center sidebar-brand-text
		 mx-3"
	>${label_sidebarbrand}</a>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">
	<div class="sidebar-heading">System Account</div>

	<ul class="navbar-nav ml-auto ">

		<c:choose>
			<c:when test="${ not empty user_system  }">

				<!-- Nav Item - User Information -->
				<li class="nav-item dropdown no-arrow ">
					<!--  --> <a
					class="nav-link dropdown-toggle d-flex align-items-center justify-content-center "
					href="#"
					id="userDropdown"
					role="button"
					data-toggle="dropdown"
					aria-haspopup="true"
					aria-expanded="false"
				> <!-- Avatar --> <img
						class="img-profile rounded-circle"
						src="https://source.unsplash.com/QAB-WJcbgJk/60x60"
						style="margin: 0px 10px 0px 10px;"
					> <!--Avatar  --> <span
						class="mr-2 d-none d-lg-inline text-white-600 small"
					>${user_system} </span>
				</a>

					<div
						class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
						aria-labelledby="userDropdown"
						x-placement="bottom-end"
						style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(224px, 64px, 0px);"
					>


						<a
							class="dropdown-item clickable"
							data-toggle="modal"
							data-target="#exampleModal"
						> <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
							Logout
						</a>
					</div>
				</li>

			</c:when>

			<c:otherwise>

				<!-- Nav Item - Login -->
				<li class="nav-item ">
					<!--  --> <a
					href="login"
					class="nav-link  d-flex align-items-center justify-content-center "
				> <i
						class="fas fa-sign-in-alt"
						style="font-size: 1.2rem"
					></i> <span class="mr-2 d-none d-lg-inline text-white-600 small">Login</span>


				</a>
				</li>
			</c:otherwise>
		</c:choose>

	</ul>
	<!-- ========================================================================================================= -->

	<!-- Modal System Logout -->
	<div
		class="modal fade"
		id="exampleModal"
		tabindex="-1"
		role="dialog"
		aria-labelledby="exampleModalLabel"
		aria-hidden="true"
	>
		<div
			class="modal-dialog"
			role="document"
		>
			<div class="modal-content">
				<div class="modal-header">
					<h5
						class="modal-title"
						id="exampleModalLabel"
					>Ready to Leave?</h5>
					<button
						type="button"
						class="close"
						data-dismiss="modal"
						aria-label="Close"
					>
						<span aria-hidden="true">&times;</span>

					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready to end
					your current session.</div>
				<div class="modal-footer">

					<button
						class="btn btn-secondary"
						type="button"
						data-dismiss="modal"
					>Cancel</button>
					<a
						class="btn btn-primary"
						href="${urlSystemLogout }"
						style="margin-left: 5px;"
					>Logout</a>
				</div>
			</div>
		</div>
	</div>



	<!-- ========================================================================================================= -->

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">
	<div class="sidebar-heading">Mail Account</div>

	<ul class="navbar-nav ml-auto ">

		<c:choose>
			<c:when test="${ not empty user_mail  }">
				<!-- Nav Item - Mail Account Information -->
				<li class="nav-item dropdown no-arrow ">
					<!--  --> <a
					class="nav-link dropdown-toggle d-flex align-items-center justify-content-center "
					href="#"
					id="userDropdown"
					role="button"
					data-toggle="dropdown"
					aria-haspopup="true"
					aria-expanded="false"
				> <!-- Avatar --> <img
						class="img-profile rounded-circle"
						src="https://lh3.googleusercontent.com/proxy/vSqRHsmYFOyYG7Au7lgeTRrqoVslYfNmRx5PEFXW059hj_31mZiyh-ShgQwN579oOFg0Re87iBGthNAPD3OJnCkIYBONXqmqSBwkf6G3YD_ZONovALw629vXxqYTMn8"
						style="margin: 0px 10px 0px 10px;"
					> <!--Avatar  --> <span
						class="mr-2 d-none d-lg-inline text-white-600 small"
					>${user_mail.userName} </span>
				</a>

					<div
						class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
						aria-labelledby="userDropdown"
						x-placement="bottom-end"
						style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(224px, 64px, 0px);"
					>

						<a
							class="dropdown-item"
							href="${urlMailNew } "
						> <i class="fas fa-plus fa-sm fa-fw mr-2 text-gray-400"></i> New Mail
						</a>
				 

						<div class="dropdown-divider"></div>

						<a
							class="dropdown-item clickable"
							data-toggle="modal"
							data-target="#mailLogoutModal"
						> <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
							Logout
						</a>
					</div>
				</li>


			</c:when>

			<c:otherwise>


				<!-- Nav Item - Login -->
				<li class="nav-item ">
					<!--  --> <a
					data-toggle="modal"
					data-target="#mailLoginModal"
					href="login"
					class="nav-link  d-flex align-items-center justify-content-center "
				> <i
						class="fas fa-sign-in-alt"
						style="font-size: 1.2rem"
					></i> <span class="mr-2 d-none d-lg-inline text-white-600 small">Add
							Mail Account</span>


				</a>
				</li>

			</c:otherwise>

		</c:choose>



	</ul>


	<!-- ========================================================================================================= -->

	<!-- Modal Mail Login  -->
	<div
		class="modal fade"
		id="mailLoginModal"
		tabindex="-1"
		role="dialog"
		aria-labelledby="exampleModalLabel"
		aria-hidden="true"
	>
		<div
			class="modal-dialog"
			role="document"
		>
			<div class="modal-content">
				<div class="modal-header">
					<h5
						class="modal-title"
						id="exampleModalLabel"
					>Login To Gmail</h5>
					<button
						type="button"
						class="close"
						data-dismiss="modal"
						aria-label="Close"
					>
						<span aria-hidden="true">&times;</span>

					</button>
				</div>
				<div class="modal-body">

					<form
						action="${mailLoginForm }"
						class="login-form user"
						method="post"
					>
						<div class="form-group ">
							<input
								type="text"
								class="form-control form-control-user"
								name="bean.userName"
								placeholder="example@gmail.com"
							>
						</div>
						<div class="form-group">
							<input
								type="password"
								class="form-control form-control-user"
								name="bean.userPassword"
								placeholder="${placeholder_password }"
							>
						</div>
						<div class="modal-footer">

							<button
								class="btn btn-primary btn-user btn-block"
								type="submit"
							>Login</button>


						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- ========================================================================================================= -->

	<!-- Modal Logout Mail  -->
	<div
		class="modal fade"
		id="mailLogoutModal"
		tabindex="-1"
		role="dialog"
		aria-labelledby="exampleModalLabel"
		aria-hidden="true"
	>
		<div
			class="modal-dialog"
			role="document"
		>
			<div class="modal-content">
				<div class="modal-header">
					<h5
						class="modal-title"
						id="exampleModalLabel"
					>Ready to Leave?</h5>
					<button
						type="button"
						class="close"
						data-dismiss="modal"
						aria-label="Close"
					>
						<span aria-hidden="true">&times;</span>

					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready to end
					your current session.</div>
				<div class="modal-footer">

					<button
						class="btn btn-secondary"
						type="button"
						data-dismiss="modal"
					>Cancel</button>
					<a
						class="btn btn-primary"
						href="${urlMailLogout }"
						style="margin-left: 5px;"
					>Logout</a>
				</div>
			</div>
		</div>
	</div>



	<!-- ========================================================================================================= -->


	<!-- Heading -->
	<div class="sidebar-heading">${label_requirement}</div>
	<hr class="sidebar-divider d-none d-md-block">
	<ul class="navbar-nav ">
		<li class="nav-item  "><a class="nav-link"> <i
				class="fas fa-fw fa-check"
			></i> <span>${label_requirement1}</span></a></li>
		<li class="nav-item"><a class="nav-link"> <i class="fas far fa-check"></i>
				<span>${label_requirement2}</span></a></li>
		<li class="nav-item"><a class="nav-link"> <i class="fas far fa-check"></i>
				<span>${label_requirement3}</span></a></li>
		<li class="nav-item"><a class="nav-link"> <i class="fas far fa-check"></i>
				<span>${label_requirement4}</span></a></li>
		<li class="nav-item"><a class="nav-link"> <i class="fas far fa-check"></i>
				<span>${label_requirement5}</span></a></li>
	</ul>




	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">
	<div class="sidebar-heading">${label_advanced}</div>
	<ul class="navbar-nav ">
		<!-- Nav Item - Form -->
		<li class="nav-item"><a class="nav-link"> <!--  --> <i
				class="fas fa-check "
			> <!--  -->
			</i> <!--  --> <span>${label_advanced1}</span>

		</a></li>


	</ul>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">



</div>

