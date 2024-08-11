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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">

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
							<li class="sidebar-item"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/searchStudentServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-magnifying-glass"></i>
								</span> <span class="hide-menu">Tra cứu học sinh</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link active"
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

			<!-- Class start -->
			<div id="subject" class="container-fluid subject">
				<div class="row">
					<div class="align-items-stretch">
						<div class="card">
							<div class="card-header">
								<i class="fas fa-table me-1"></i> Danh sách môn
							</div>

							<div class="subject-list-wrap">
								<div class="card-body subject-list-data">

									<div class="datatable-wrapper">
										<c:if test="${not empty requestScope.messageErrorAddSubject}">
												<div id="toast">
													<div class="toast toast--error">
														<div class="toast__icon">
															<i class="fa-solid  fa-triangle-exclamation"></i>
														</div>
														<div class="toast__body">
															<h3 class="toast__title">Thất bại</h3>
															<p class="toast__msg">Tên môn đã tồn tại</p>
														</div>
														<div class="toast__close">
															<i class="fa-solid fa-xmark"></i>
														</div>
													</div>
												</div>
											</c:if>
										<c:if test="${not empty requestScope.messageInfoAddSubject}">
											<div id="toast">
												<div class="toast toast--success">
													<div class="toast__icon">
														<i class="fa-solid fa-circle-check"></i>
													</div>
													<div class="toast__body">
														<h3 class="toast__title">Thành công</h3>
														<p class="toast__msg">Thêm môn mới thành công.</p>
													</div>
													<div class="toast__close">
														<i class="fa-solid fa-xmark"></i>
													</div>
												</div>
											</div>
										</c:if>

										<c:if test="${not empty requestScope.messageErrorDeleteSubject}">
												<div id="toast">
													<div class="toast toast--error">
														<div class="toast__icon">
															<i class="fa-solid  fa-triangle-exclamation"></i>
														</div>
														<div class="toast__body">
															<h3 class="toast__title">Thất bại</h3>
															<p class="toast__msg">Không thể xóa môn đang học.</p>
														</div>
														<div class="toast__close">
															<i class="fa-solid fa-xmark"></i>
														</div>
													</div>
												</div>
											</c:if>
										<c:if
											test="${not empty requestScope.messageInfoDeleteSubject}">
											<div id="toast">
												<div class="toast toast--success">
													<div class="toast__icon">
														<i class="fa-solid fa-circle-check"></i>
													</div>
													<div class="toast__body">
														<h3 class="toast__title">Thành công</h3>
														<p class="toast__msg">Xóa môn không có dữ liệu thành
															công.</p>
													</div>
													<div class="toast__close">
														<i class="fa-solid fa-xmark"></i>
													</div>
												</div>
											</div>
										</c:if>

										<c:if test="${not empty requestScope.messageErrorUpdateSubject}">
												<div id="toast">
													<div class="toast toast--error">
														<div class="toast__icon">
															<i class="fa-solid  fa-triangle-exclamation"></i>
														</div>
														<div class="toast__body">
															<h3 class="toast__title">Thất bại</h3>
															<p class="toast__msg">Tên môn đã tồn tại.</p>
														</div>
														<div class="toast__close">
															<i class="fa-solid fa-xmark"></i>
														</div>
													</div>
												</div>
											</c:if>
										<c:if
											test="${not empty requestScope.messageInfoUpdateSubject}">
											<div id="toast">
												<div class="toast toast--success">
													<div class="toast__icon">
														<i class="fa-solid fa-circle-check"></i>
													</div>
													<div class="toast__body">
														<h3 class="toast__title">Thành công</h3>
														<p class="toast__msg">Sửa tên môn thành công.</p>
													</div>
													<div class="toast__close">
														<i class="fa-solid fa-xmark"></i>
													</div>
												</div>
											</div>
										</c:if>

										<div class="add-subject">
											<button class="btn btn-primary add-subject-btn" <c:if test="${sessionScope.account.isAdmin != 1 && sessionScope.account.isAdmin != 4}">
													                   aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													               </c:if>>Thêm
												môn</button>
										</div>

										<div class="datatable-container">
											<table id="datatablesSubject" class="datatable-table">
												<thead>
													<tr>
														<th data-sortable="true" style="width: 20%; text-align: center;"><a
															href="#" class="datatable-sorter">STT</a></th>
														<th data-sortable="true" aria-sort="descending"
															class="datatable-descending" style="width: 60%; text-align: center;"><a
															href="#" class="datatable-sorter">Tên môn</a></th>
														<th data-sortable="true" style="width: 20%; text-align: center;"><a
															href="#" class="datatable-sorter">Hệ số</a></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="Mon" items="${DSMH}">
														<tr>
															<td style="text-align: center;"><%=i++%></td>
															<td class="subjectName-edit" style="margin-left: 30px"><c:out
																	value="${Mon.tenMH}" /><span><i
																	class="subjectName-edit-icon fa fa-solid fa-pen-to-square" <c:if test="${sessionScope.account.isAdmin != 1 && sessionScope.account.isAdmin != 4}">
													                   aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													               </c:if>></i>
																	<i class="removeSubject-icon fa fa-solid fa-trash-can" <c:if test="${sessionScope.account.isAdmin != 1 && sessionScope.account.isAdmin != 4}">
													                   aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													               </c:if>></i>
															</span></td>
															<td style="text-align: center;"><c:out value="${Mon.heSo}" /></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>


								</div>
								<div class="card-body change-subjectName hidden">
									<div class="card">
										<header class="change-subjectName-top">
											<h5>Thay đổi tên môn</h5>
										</header>
										<form
											action="<%=request.getContextPath()%>/InfoSubjectServlet">
											<input type="hidden" name="action" value="/update">
											<div class="change-subjectName-container">
												<div class="change-subjectName-group">
													<label for="subjectNameOld">Tên môn thay đổi:</label> <input
														type="text" id="subjectNameOld" name="nameOld" readonly>
												</div>
												<div class="change-subjectName-group">
													<label for="change-subjectName-input">Nhập tên môn
														mới:</label> <input type="text" id="change-subjectName-input"
														placeholder="Tên môn mới" name="name">
												</div>
												<div class="change-subjectName-group">
													<label for="numberSubject-input">Nhập hệ số:</label> <select
														class="numberSubject-input" name="number">
														<option name="number"
															<c:if test="${number == '1'}">selected</c:if>>1</option>
														<option name="number"
															<c:if test="${number == '2'}">selected</c:if>>2</option>
													</select>
												</div>
											</div>


											<div class="change-subjectName-bottom">
												<div class="change-subjectName-confirm">
													<button type="button"
														class="btn btn-primary change-subjectName-cancel-btn btn-cancel">Hủy</button>
													<button type="submit"
														class="btn btn-primary change-subjectName-confirm-btn">Xác
														nhận</button>
												</div>
											</div>
										</form>
									</div>
								</div>

								<div class="card-body remove-subject hidden" style="margin-top: 113px;">
									<div class="card">
										<header class="remove-subject-top">
											<h5>Bạn có chắc chắn xóa môn</h5>
										</header>
										<form
											action="<%=request.getContextPath()%>/InfoSubjectServlet">
											<input type="hidden" name="action" value="/delete">
											<div class="remove-subject-container">

												<div class="remove-subject-group">
													<input type="text" id="subjectNameRemove" name="nameRemove"
														readonly>
												</div>
											</div>


											<div class="remove-subject-bottom">
												<div class="remove-subject-confirm">
													<button type="button"
														class="btn btn-primary remove-subject-cancel-btn btn-cancel">Hủy</button>
													<button type="submit"
														class="btn btn-primary remove-subject-confirm-btn">Xác
														nhận</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Class end -->

		</div>
		<!--  Main wrapper -->

	</div>



	<!-- Modal add subject -->
	<div class="modal add-subject-modal">
		<div class="modal-container add-subject-modal-container">

			<div class="icon-close js-modal-add-subject-close">
				<i class="modal-icon-close fa-solid fa-xmark"></i>
			</div>

			<header class="modal-header"> Thêm môn mới </header>

			<form action="<%=request.getContextPath()%>/InfoSubjectServlet">
				<input type="hidden" name="action" value="/insert">
				<div class="modal-body">
					<div class="model-input-item">
						<label for="new-subject" class="modal-label">Tên môn:</label> <input
							type="text" id="new-subject" class="modal-input"
							placeholder="Tên môn" name="subjectName">
					</div>


					<div class="model-input-item">
						<label for="number-of-subject" class="modal-label">Hệ số:</label>
						<select class="number-of-subject" name="heSo">
							<option name="heSo" <c:if test="${heSo == '1'}">selected</c:if>>1</option>
							<option name="heSo" <c:if test="${heSo == '2'}">selected</c:if>>2</option>
						</select>
					</div>

				</div>

				<footer class="modal-footer">
					<button type="button"
						class="btn btn-primary cancel-add-subject-btn btn-cancel">Hủy</button>
					<button type="submit"
						class="btn btn-primary confirm-add-subject-btn">Xác nhận</button>
				</footer>
			</form>
		</div>
	</div>




	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>


	<script src="./js/app.js"></script>
	<script src="./js/pagination.js"></script>
	<script src="./js/subjectHandle.js"></script>
	<script src="./js/modalAddSubject.js"></script>
</body>
</html>