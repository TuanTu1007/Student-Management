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
					class="brand-logo d-flex align-items-center justify-content-between no-print">
					<a href="./index.html" class="text-nowrap brand-logo-link"> <img
						class="logo-img" src="./image/logo.jpg" alt="">
						Quản lý học sinh
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
							<li class="sidebar-item mg-l-4"><a class="sidebar-link"
								href="./account.jsp" aria-expanded="false"> <span> <i
										class="fa fa-solid fa-user"></i>
								</span> <span class="hide-menu">Tài Khoản</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link"
								href="./class.jsp" aria-expanded="false"> <span> <i
										class="fa fa-solid fa-chalkboard-user"></i>
								</span> <span class="hide-menu">Lớp</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link"
								href="./infoStudent.jsp" aria-expanded="false"> <span>
										<i class="fa fa-solid fa-graduation-cap"></i>
								</span> <span class="hide-menu">Thông tin học sinh</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/searchStudentServlet" aria-expanded="false"> <span>
										<i class="fa fa-solid fa-magnifying-glass"></i>
								</span> <span class="hide-menu">Tra cứu học sinh</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link"
								href="./subject.jsp" aria-expanded="false"> <span> <i
										class="fa fa-solid fa-book-open"></i>
								</span> <span class="hide-menu">Môn</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link active"
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
								href="<%=request.getContextPath()%>/ChangeRuleServlet" aria-expanded="false"> <span>
										<i class="fa fa-solid fa-gear"></i>
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
							<a href="" target="_blank">Admin</a>
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
							<div class="card-header">
								<i class="fas fa-table me-1"></i> Bảng điểm tổng kết 
							</div>
							<div class="card-body">
								<div class="datatable-wrapper">
									<div class="datatable-top no-print">
										<form action="<%=request.getContextPath()%>/renderPointAllSubjectServlet">
											<input type="hidden" name="action" value="/pointAllSubject">
											<div class="datatable-selection no-print">
												<div class="">
													<label>Lớp: </label> 
													<select class="search-class" name="search-lop">
														<c:forEach var="c" items="${DSL}">
															<option <c:if test="${nameLop == c.tenLop}">selected</c:if>>${c.tenLop}</option>
															
														</c:forEach>
													</select> 
												</div>

												<div class="">
													<label>Học kỳ: </label> 
													<select id="search-hk" name="search-hk">
														<option <c:if test="${nameHocKy == '1'}">selected</c:if>>1</option>
														<option <c:if test="${nameHocKy == '2'}">selected</c:if>>2</option>
													</select>
												</div>
												
												<div class="">
													<label>Năm học: </label> 
													<select id="search-nh" name="search-nh" style="width: auto;">
														<option>2023-2024</option>
														<option>2022-2023</option>
													</select>
												</div>
											</div>

											<div class="select-point">
												<a href="./tablePointServlet">
													<button type="button" class="btn btn-primary">Quay lại</button>
												</a>
												<button type="submit" class="btn btn-primary">Xem</button>
												<button class="btn btn-primary" onclick="printReport()">
													<i class="fa-solid fa-print"></i> In bảng điểm
												</button>
												
											</div>
											
										</form>
										
										

									</div>
									<h3 style="text-align: center;">BẢNG ĐIỂM TỔNG KẾT HỌC KỲ</h3>
									<div class="datatable-container">
									
										<table id="datatablesPoint" class="datatable-table">
											<thead>
												<tr>
													<th data-sortable="true" style="text-align: center;">STT</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending">Tên học sinh</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Toán</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Lý</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Hóa</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Anh</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Văn</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Thể dục</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Sinh</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Sử</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Địa</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">GDCD</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">TBHK</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Học lực</th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="text-align: center;">Hạnh kiểm</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="point" items="${DSD}">
													<tr>
														<td style="text-align: center;"><%=i++%></td>
														<td>${point.tenHS}</td>
														<td style="text-align: center;">${point.dToan}</td>
														<td style="text-align: center;">${point.dLy}</td>
														<td style="text-align: center;">${point.dHoa}</td>
														<td style="text-align: center;">${point.dAnh}</td>
														<td style="text-align: center;">${point.dVan}</td>
														<td style="text-align: center;">Đạt</td>
														<td style="text-align: center;">${point.dSinh}</td>
														<td style="text-align: center;">${point.dSu}</td>
														<td style="text-align: center;">${point.dDia}</td>
														<td style="text-align: center;">${point.dGDCD}</td>
														<td style="text-align: center;">${point.dTBHK}</td>
														<td style="text-align: center;">${point.sXepLoai}</td>
														<td style="text-align: center;">Tốt</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<form action="<%=request.getContextPath()%>/renderPointAllSubjectServlet">
											<input type="hidden" name="action" value="/filter">
											<div class="">
												<label>Phân loại: </label> 
												<select id="search-loaiHS" name="search-loaiHS" style="width: auto;">
													<option value="xuatSac" <c:if test="${loaiHS == 'Xuất sắc'}">selected</c:if>>Xuất sắc</option>
													<option value="gioi" <c:if test="${loaiHS == 'Giỏi'}">selected</c:if>>Giỏi</option>
													<option value="kha" <c:if test="${loaiHS == 'Khá'}">selected</c:if>>Khá</option>
													<option value="trungBinh" <c:if test="${loaiHS == 'Trung Bình'}">selected</c:if>>Trung Bình</option>
													<option value="yeu" <c:if test="${loaiHS == 'Yếu'}">selected</c:if>>Yếu</option>
												</select>
												<button type="submit" class="btn btn-primary">Lọc</button>
											</div>
										</form>
									</div>
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
	<!-- <script src="./js/pagination.js"></script> -->
	<script>
        function printReport() {
            window.print();
        }
    </script>

</body>
</html>