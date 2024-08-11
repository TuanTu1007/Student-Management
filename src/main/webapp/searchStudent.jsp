<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý học sinh</title>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@v5.3.0/dist/css/bootstrap.min.css">
<style <%@ include file="./css/style.css" %>></style>

</head>
<body style="background-color: #484848">
	<%
	int i = 1;
	%>
	<!--  Body Wrapper -->
	<div class="page-wrapper" id="main-wrapper" data-layout="vertical"
		data-navbarbg="skin6" data-sidebartype="full"
		data-sidebar-position="fixed" data-header-position="fixed">

		<!-- Sidebar Start -->
		<aside class="left-sidebar">
			<!-- Sidebar scroll-->
			<div>
				<div
					class="brand-logo d-flex align-items-center justify-content-between">
					<a href="./index.html" class="text-nowrap brand-logo-link"> <img
						class="logo-img" src="./image/logo.jpg" alt=""> Quản lý học
						sinh
					</a>
					<div class="close-btn d-block sidebartoggler cursor-pointer"
						id="sidebarCollapse">
						<i class="fa-solid fa-xmark"></i>
					</div>
				</div>
				<!-- Sidebar navigation-->
				<nav class="sidebar-nav scroll-sidebar" data-simplebar="">
					<ul id="sidebarnav">
						<div class="sidebarnav-top">
							<li class="sidebar-item mg-l-4"><a
								class="sidebar-link"
								href="<%=request.getContextPath()%>/changePasswordServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-user"></i>
								</span> <span class="hide-menu">Tài Khoản</span>
							</a></li>
							<c:if test="${sessionScope.account.isAdmin != 5}">
								<li class="sidebar-item">
								<a class="sidebar-link" href="<%=request.getContextPath()%>/infoClassServlet" aria-expanded="false"> 
									<span> 
										<i class="fa fa-solid fa-chalkboard-user"></i>
									</span> 
									<span class="hide-menu">Lớp</span>
								</a></li>
							</c:if>

							<li class="sidebar-item"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/InfoStudentsServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-graduation-cap"></i>
								</span> <span class="hide-menu">Thông tin học sinh</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link active"
								href="<%=request.getContextPath()%>/searchStudentServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-magnifying-glass"></i>
								</span> <span class="hide-menu">Tra cứu học sinh</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/InfoSubjectServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-book-open"></i>
								</span> <span class="hide-menu">Môn</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/tablePointServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-table"></i>
								</span> <span class="hide-menu">Bảng điểm</span>
							</a></li>

							<li class="sidebar-item"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/ReportServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-file-excel"></i>
								</span> <span class="hide-menu">Báo cáo</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/ChangeRuleServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-gear"></i>
								</span> <span class="hide-menu">Thay đổi quy định</span>
							</a></li>
						</div>

						<div class="sidebarnav-bottom">
							<li class="sidebar-item"><a class="sidebar-link"
								href="./signIn.jsp" aria-expanded="false"> <span> <i
										class="fa-solid fa-power-off"></i>
								</span> <span class="hide-menu">Đăng xuất</span>
							</a></li>
						</div>


					</ul>

				</nav>
				<!-- End Sidebar navigation -->
			</div>
			<!-- End Sidebar scroll-->
		</aside>
		<!--  Sidebar End -->

		<!--  Main wrapper -->
		<div class="body-wrapper">
			<!--  Header Start -->
			<header class="app-header">
				<nav class="navbar navbar-expand-lg navbar-light">
					<ul class="navbar-nav">
						<li class="nav-item d-block d-xl-none"><a
							class="nav-link sidebartoggler nav-icon-hover"
							id="headerCollapse" href="javascript:void(0)"> <i
								class="fa-solid fa-bars"></i>
						</a></li>
						<li class="nav-item"><a class="nav-link nav-icon-hover"
							href="javascript:void(0)"> <i class="fa-regular fa-bell"></i>
								<div class="notification"></div>
						</a></li>

					</ul>
					<div class="navbar-collapse justify-content-end px-0"
						id="navbarNav">
						<ul
							class="navbar-nav flex-row ms-auto align-items-center justify-content-end">
							<a href="" target="_blank">${sessionScope.account.username}</a>
							<li class="nav-item dropdown"><a
								class="nav-link nav-icon-hover" href="javascript:void(0)"
								id="drop2" data-bs-toggle="dropdown" aria-expanded="false">
									<img src="./image/captain_yami-sukehiro.jpg" alt="" width="35"
									height="35" class="rounded-circle">
							</a></li>
						</ul>
					</div>
				</nav>
			</header>
			<!--  Header End -->

			<!-- Search student start -->
			<div id="search-student" class="container-fluid search-student">
				<div class="row">
					<div class="align-items-stretch">
						<div class="card">
							<div class="card-header">
								<i class="fas fa-table me-1"></i> Danh sách học sinh
							</div>
							<div class="card-body">
								<div class="datatable-wrapper">
									<div class="datatable-top">

										<form
											action="<%=request.getContextPath()%>/InfoStudentsServlet">
											<input type="hidden" name="action" value="/searchByName">
											<div class="datatable-search mb-4">
												<input name="search-student-name" class="datatable-input me-4 p-1"
													placeholder="Tên học sinh" type="text"
													title="Search within table"
													aria-controls="datatablesSimple"
													<c:if test="${not empty searchStudentName}">value="${searchStudentName}"</c:if>>

												<label for="search-student-class">Tên lớp: </label> <select
													class="search-student-class p-1" name="search-student-class">
													<c:forEach var="c" items="${DSL}">
													<option name="search-student-class"
														<c:if test="${searchStudentClass == c.tenLop}">selected</c:if>>${c.tenLop}</option>
													</c:forEach>
												</select>
											</div>

											<div class="search-student">
												<button type="submit"
													class="btn btn-primary search-point-btn">Tìm kiếm</button>
											</div>
										</form>

									</div>
									<div class="datatable-container" style="margin-top: -10px">
										<table id="datatablesSearchStudent" class="datatable-table">
											<thead>
												<tr>
													<th data-sortable="true" style="width: 10%; text-align: center; margin-left: 20px;"><a
														href="#" class="datatable-sorter">STT</a></th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="width: 25%; text-align: center;"><a
														href="#" class="datatable-sorter">Tên</a></th>
													<th data-sortable="true" style="width: 15%; text-align: center;"><a
														href="#" class="datatable-sorter">Lớp</a></th>
													<th data-sortable="true" style="width: 25%; text-align: center;"><a
														href="#" class="datatable-sorter">TB HKI</a></th>
													<th data-sortable="true" style="width: 25%; text-align: center;"><a
														href="#" class="datatable-sorter">TB HKII</a></th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="HocSinh" items="${DSTCHS}">
													<tr>
														<td style="text-align: center;"><%=i++%></td>
														<td><c:out value="${HocSinh.tenHS}" /></td>
														<td style="text-align: center;"><c:out value="${HocSinh.lop}" /></td>
														<td><c:out value="${HocSinh.tbhk1}" /></td>
														<td><c:out value="${HocSinh.tbhk2}" /></td>
													</tr>
												</c:forEach>


											</tbody>
										</table>
									</div>
								</div>
								<c:if test="${not empty requestScope.messageerror}">
									<div id="toast">
													<div class="toast toast--error">
														<div class="toast__icon">
															<i class="fa-solid fa-triangle-exclamation"></i>
														</div>
														<div class="toast__body">
															<h3 class="toast__title">Cảnh báo</h3>
															<p class="toast__msg">Không tìm thấy học sinh.</p>
														</div>
														<div class="toast__close">
															<i class="fa-solid fa-xmark"></i>
														</div>
													</div>
												</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Search student end -->


		</div>
		<!--  Main wrapper -->

	</div>


	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>


	<script src="./js/app.js"></script>
	<script src="./js/pagination.js"></script>

</body>
</html>