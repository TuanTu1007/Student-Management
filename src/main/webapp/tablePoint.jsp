<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<style>
@media print {
            .no-print {
                display: none;
            }
        }
</style>

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
							
							<c:if test="${sessionScope.account.isAdmin != 5}">
							<li class="sidebar-item"><a class="sidebar-link"
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
							</c:if>
							<li class="sidebar-item"><a class="sidebar-link active"
								href="<%=request.getContextPath()%>/tablePointServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-table"></i>
								</span> <span class="hide-menu">Bảng điểm</span>
							</a></li>
							<c:if test="${sessionScope.account.isAdmin != 5}">

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
						</c:if>
						<c:if test="${sessionScope.account.isAdmin == 5}">
							<br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
						</c:if>
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
			<header class="app-header no-print">
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
					<div class="navbar-collapse justify-content-end px-0 no-print"
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

			<!-- Table point start -->
			<div id="table-point" class="container-fluid table-point">
				<div class="row">
					<div class="align-items-stretch">
						<div class="card">
							<div class="card-header no-print">
								<c:if test="${sessionScope.account.isAdmin != 5}">
									<i class="fas fa-table me-1"></i> BẢNG ĐIỂM MÔN LỚP
								</c:if>
								<c:if
									test="${sessionScope.account.username == sessionScope.hs.maHS}">
									<i class="fas fa-table me-1"></i> BẢNG ĐIỂM MÔN HỌC SINH
								</c:if>
							</div>
							<div class="card-body pb-2">
								<div class="datatable-wrapper">
									<c:if test="${sessionScope.account.isAdmin != 5}">
										<div class="datatable-top">
											<form
												action="<%=request.getContextPath()%>/tablePointServlet">
												<input type="hidden" name="action" value="/pointStudent">
												<div class="datatable-selection">

													<div class="">
														<label>Lớp: </label> <select class="search-class"
															name="search-lop">
															<c:forEach var="c" items="${DSL}">
																<option
																	<c:if test="${nameLop == c.tenLop}">selected</c:if>>${c.tenLop}</option>
															</c:forEach>

														</select>

													</div>

													<div class="">
														<label>Học kỳ: </label> <select id="search-hk"
															name="search-hk">
															<option <c:if test="${nameHocKy == '1'}">selected</c:if>>1</option>
															<option <c:if test="${nameHocKy == '2'}">selected</c:if>>2</option>
														</select>
													</div>

													<div class="">

														<label>Môn: </label> <select id="search-mon"
															name="search-mon">
															<c:forEach var="subject" items="${DSMH}">
																<option
																	<c:if test="${nameMon == subject.tenMH}">selected</c:if>>${subject.tenMH}</option>
															</c:forEach>
														</select>
													</div>

												</div>


												<div class="search-point no-print">
													<button type="submit"
														class="btn btn-primary search-point-btn">Xem</button>
													<a href="<%=request.getContextPath()%>/renderPointAllSubjectServlet">
														<button type="button" class="btn btn-primary">Điểm
															tổng kết</button>
													</a>
													<button type="button"
														class="btn btn-primary import-point-btn float-end" <c:if test="${sessionScope.account.isAdmin != 3 && sessionScope.account.isAdmin != 1}">
														aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													</c:if>>
														<i class="fa-solid fa-pen-nib pe-2"></i>Nhập điểm</button>
												</div>
											</form>


											<div class="importFileExcelModal modal">
												<div class="modal-container importFileExcel-modal-container"
													style="min-height: 200px">
													<div class="icon-close js-importFileExcel-modal-close">
														<i class="modal-icon-close fa-solid fa-xmark"></i>
													</div>
													<header class="modal-header p-4">Nhập điểm</header>
													<form method="post" enctype="multipart/form-data"
														action="<%=request.getContextPath()%>/tablePointServlet"
														class="d-flex justify-content-between p-4">
														<label for="chooseFile" class="flex-1">Chọn file:</label>
														<input id="chooseFile" type="file" name="file"><br>
														<input type="submit" value="Upload" class="btn btn-primary">
													</form>
												</div>
											</div>
										</div>
									</c:if>
									<c:if test="${sessionScope.account.isAdmin != 5}">
										<div class="datatable-container">
											<table id="datatablesPoint" class="datatable-table">
												<thead>
													<tr>
														<th style="width: 5%; text-align: center;">STT</th>
														<th style="width: 25%; text-align: center;">Tên</th>
														<th style="width: 10%; text-align: center;">Miệng</th>
														<th style="width: 10%; text-align: center;">15'</th>
														<th style="width: 10%; text-align: center;">1 Tiết</th>
														<th style="width: 10%; text-align: center;">Học kỳ</th>
														<th style="width: 20%; text-align: center;">Trung bình môn</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="point" items="${DSD}">
														<tr data-index="0">
															<td style="text-align: center;"><%=i++%></td>
															<td>${point.tenHS}</td>
															<td style="text-align: center;">${point.mieng}</td>
															<td style="text-align: center;">${point.muoiLamPhut}</td>
															<td style="text-align: center;">${point.motTiet}</td>
															<td style="text-align: center;">${point.hocKy}</td>
															<td style="text-align: center;"><fmt:formatNumber
																	value="${point.tbMon}" type="number" maxFractionDigits="1" /></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<c:if
												test="${not empty requestScope.messageError}">
												<div id="toast">
													<div class="toast toast--error">
														<div class="toast__icon">
															<i class="fa-solid  fa-triangle-exclamation"></i>
														</div>
														<div class="toast__body">
															<h3 class="toast__title">Thất bại</h3>
															<p class="toast__msg">Nhập điểm không được</p>
														</div>
														<div class="toast__close">
															<i class="fa-solid fa-xmark"></i>
														</div>
													</div>
												</div>
											</c:if>
											
									<c:if test="${not empty requestScope.messageSuccess}">
												<div id="toast">
													<div class="toast toast--success">
														<div class="toast__icon">
															<i class="fa-solid fa-circle-check"></i>
														</div>
														<div class="toast__body">
															<h3 class="toast__title">Thành công</h3>
															<p class="toast__msg">Nhập điểm thành
																công.</p>
														</div>
														<div class="toast__close">
															<i class="fa-solid fa-xmark"></i>
														</div>
													</div>
												</div>
											</c:if>
											<button class="btn btn-primary ms-auto no-print" onclick="printReport()">
													<i class="fa-solid fa-print""></i> In bảng điểm
												</button>
										</div>
									</c:if>

									<c:if
										test="${sessionScope.account.username == sessionScope.hs.maHS}">

										<button class="btn btn-primary ms-auto no-print"
											onclick="printReport()">
											<i class="fa-solid fa-print""></i> Xuất bảng điểm
										</button>

										<div class="datatable-container mb-4">
											<h2 style="text-align: center;">BẢNG ĐIỂM HỌC SINH</h2>
											<table id="datatablesInfoOneStudent" class="datatable-table">
												<thead>
													<tr>
														<th>Mã học sinh</th>
														<td class="name">${sessionScope.hs.maHS}</td>
														<th>Giới tính</th>
														<td class="gender">${sessionScope.hs.gioiTinh}</td>
														<th>Địa chỉ</th>
														<td class="address">${sessionScope.hs.diaChi}</td>
														<th>Lớp</th>
														<td>${sessionScope.l.tenLop}</td>
													</tr>
													<tr>
														<th>Họ và tên</th>
														<td class="name">${sessionScope.hs.tenHS}</td>
														<th>Ngày sinh</th>
														<td class="year">${sessionScope.hs.namSinh}</td>
														<th>Email</th>
														<td class="email d-flex justify-content-between border-0">
															${sessionScope.hs.email}</td>
														<th>Tình trạng</th>
														<td>Đang học</td>
													</tr>
												</thead>
											</table>
										</div>
										<div class="datatable-container mt-4 mb-4">
											<h5>Học kỳ 1 - Năm học 2023-2024</h5>
											<table id="datatablesOnePoint" class="datatable-table">
												<thead>
													<tr>
														<th style="width: 5%; text-align: center;">STT</th>
														<th style="width: 25%; text-align: center;">Tên</th>
														<th style="width: 10%; text-align: center;">Miệng</th>
														<th style="width: 10%; text-align: center;">15'</th>
														<th style="width: 10%; text-align: center;">1T</th>
														<th style="width: 10%; text-align: center;">HK</th>
														<th style="width: 20%; text-align: center;">TB môn</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="p" items="${p}">
														<tr data-index="0">
															<td style="text-align: center;"><%=i++%></td>
															<td>${p.tenHS}</td>
															<td style="text-align: center;"><fmt:formatNumber
																	value="${p.mieng}" type="number" maxFractionDigits="1" /></td>
															<td style="text-align: center;"><fmt:formatNumber
																	value="${p.muoiLamPhut}" type="number"
																	maxFractionDigits="1" /></td>
															<td style="text-align: center;"><fmt:formatNumber
																	value="${p.motTiet}" type="number"
																	maxFractionDigits="1" /></td>
															<td style="text-align: center;"><fmt:formatNumber
																	value="${p.hocKy}" type="number" maxFractionDigits="1" /></td>
															<td style="text-align: center;"><fmt:formatNumber
																	value="${p.tbMon}" type="number" maxFractionDigits="1" /></td>
														</tr>
													</c:forEach>
													<tr>
														<td></td>
														<td><b>Trung bình học kỳ</b></td>
														<td></td>
														<td></td>
														<td></td>
														<td></td>
														<td style="text-align: center;"><fmt:formatNumber
																value="${sessionScope.pAVG.diemTBHK}" type="number"
																maxFractionDigits="2" /></td>
													</tr>
												</tbody>
											</table>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Table point end -->


		</div>
		<!--  Main wrapper -->

	</div>



	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
	<script src="./js/app.js"></script>
	<script>
	const importPointBtn = document.querySelector('.import-point-btn')
	const modalImportPoint = document.querySelector('.importFileExcelModal')
	const modalImportPointContainer = document.querySelector('.importFileExcel-modal-container')
	const modalImportPointClose = document.querySelector('.js-importFileExcel-modal-close')

	function OpenModalImportPoint() {
		modalImportPoint.classList.add('open')
	}

	function HideModalImportPoint() {
		modalImportPoint.classList.remove('open')
	}

	importPointBtn.addEventListener('click', OpenModalImportPoint)


	modalImportPointClose.addEventListener('click', HideModalImportPoint)
	modalImportPoint.addEventListener('click', HideModalImportPoint)
	modalImportPointContainer.addEventListener('click', function(event) { event.stopPropagation() })
	
	function printReport() {
            window.print();
        }
	</script>
	
</body>
</html>