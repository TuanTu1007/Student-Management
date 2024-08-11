<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@v5.3.0/dist/css/bootstrap.min.css">
<style <%@ include file="./css/style.css" %>></style>

</head>
<body>
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
						class="logo-img" src="./image/logo.jpg" alt="">
						StudentManager
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
								href="#" aria-expanded="false"> <span> <i
										class="fa fa-solid fa-user"></i>
								</span> <span class="hide-menu">Tài Khoản</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link" href="#"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-chalkboard-user"></i>
								</span> <span class="hide-menu">Lớp</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link" href="#"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-graduation-cap"></i>
								</span> <span class="hide-menu">Thông tin học sinh</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link" href="#"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-magnifying-glass"></i>
								</span> <span class="hide-menu">Tra cứu học sinh</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link" href="#"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-book-open"></i>
								</span> <span class="hide-menu">Môn</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link" href="#"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-table"></i>
								</span> <span class="hide-menu">Bảng điểm</span>
							</a></li>

							<li class="sidebar-item"><a class="sidebar-link" href="#"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-file-excel"></i>
								</span> <span class="hide-menu">Báo cáo</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link" href="#"
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
						<li class="nav-item">
							<div class="toggle-switch">
								<label class="switch-label"> <input type="checkbox"
									class="checkbox toggle-theme"> <span class="slider"></span>
								</label>
							</div>
						</li>
					</ul>
					<div class="navbar-collapse justify-content-end px-0"
						id="navbarNav">
						<ul
							class="navbar-nav flex-row ms-auto align-items-center justify-content-end">
							<a href="" target="_blank">VanA@gmail.com</a>
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


			<!-- Account start -->
			<div id="account" class="container-fluid account hidden">

				<div class="row">
					<div class="card account-info">
						<div class="account-info-content">
							<h3 class="account-info-heading">Thông tin tài khoản</h3>

							<div class="spacer"></div>

							<div class="account-info-group">
								<label><i class="account-icon fa-solid fa-user"></i>Tên
									tài khoản: </label>
								<div class="account-name">
									<p class="account-info-text">Van A</p>
								</div>

							</div>

							<div class="account-info-group">
								<label><i class="account-icon fa-solid fa-key"></i>Mật
									khẩu: </label>
								<div class="account-pass">
									<p class="account-info-text account-pass-text__hide">*******</p>
									<p class="account-info-text account-pass-text__show hidden">123456</p>
									<div class="pass-selection">
										<i class="show-pass fa-solid fa-eye"></i> <i
											class="hide-pass fa-solid fa-eye-slash hidden"></i> <i
											class="edit-pass fa-solid fa-pen-to-square"></i>
									</div>
								</div>
							</div>

							<div class="account-info-group">
								<label><i class="account-icon fa-solid fa-envelope"></i>Email:
								</label>
								<div class="account-pass">
									<p class="account-info-text">KienTuong@gmail.com</p>
								</div>
							</div>
						</div>


						<footer class="account-info-footer">
							<span>Last update: </span>
							<p class="account-last-update">__/__/____</p>
						</footer>
					</div>

				</div>
			</div>
			<!-- Account end -->


			<!-- Class start -->
			<div id="class" class="container-fluid class">
				<div class="row">
					<div class="align-items-stretch">
						<div class="card">
							<div class="card-header">
								<i class="fas fa-table me-1"></i> Danh sách lớp
							</div>

							<div class="class-list-wrap">
								<div class="card-body class-list-data">
									<div class="datatable-wrapper">
										<div class="datatable-top">
											<div class="datatable-selection">

												<div id="class-semester" class="class-semester-selection">
													<label>Học kỳ: </label> <select>
														<option></option>
														<option>1</option>
														<option>2</option>
													</select>
												</div>

											</div>


											<div class="search-class">
												<button class="btn btn-primary search-class-btn">Tìm
													kiếm</button>
											</div>

										</div>
										<div class="datatable-container">
											<table id="datatablesClass" class="datatable-table">
												<thead>
													<tr>
														<th data-sortable="true" style="width: 10%;"><a
															href="#" class="datatable-sorter">STT</a></th>
														<th data-sortable="true" aria-sort="descending"
															class="datatable-descending" style="width: 30%;"><a
															href="#" class="datatable-sorter">Tên Lớp</a></th>
														<th data-sortable="true" style="width: 20%;"><a
															href="#" class="datatable-sorter">Sỉ số</a></th>
													</tr>
												</thead>
												<tbody>
													<tr data-index="0">
														<td>1</td>
														<td class="className-edit">Technical Author <i
															class="className-edit-icon fa fa-solid fa-pen-to-square"></i>
														</td>
														<td>23</td>
													</tr>
													<tr data-index="0">
														<td>2</td>
														<td class="className-edit">ABC <i
															class="className-edit-icon fa fa-solid fa-pen-to-square"></i>
														</td>
														<td>45</td>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="datatablefooter justify-content-end ">
											<button class="btn btn-primary add-class-btn">Thêm
												lớp</button>
										</div>
									</div>
								</div>

								<div class="card-body change-className hidden">
									<div class="card">
										<header class="change-className-top">
											<h5>Thay đổi tên lớp</h5>
										</header>

										<div class="change-className-container">
											<div class="change-className-group">
												<label for="change-className-input">Nhập tên lớp
													mới:</label> <input type="text" id="change-className-input"
													placeholder="Tên lớp mới">
											</div>
										</div>


										<div class="change-className-bottom">
											<div class="change-className-confirm">
												<button class="btn btn-primary change-className-cancel-btn">Hủy</button>
												<button class="btn btn-primary change-className-confirm-btn">Xác
													nhận</button>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<!-- Class end -->


			<!-- Info student start -->
			<div id="info-student" class="container-fluid info-student hidden">
				<div class="row">
					<div class="align-items-stretch">
						<div class="card">
							<div class="card-header">
								<i class="fas fa-table me-1"></i> Danh sách học sinh
							</div>
							<div class="card-body">
								<div
									class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
									<div class="datatable-top">
										<div class="add-student">
											<button class="btn btn-primary add-student-btn">Thêm
												học sinh</button>
										</div>


										<div class="datatable-search">
											<input class="datatable-input" placeholder="Search..."
												type="search" title="Search within table"
												aria-controls="datatablesSimple">
										</div>

									</div>
									<div class="datatable-container">
										<table id="datatablesInfoStudent" class="datatable-table">
											<thead>
												<tr>
													<th data-sortable="true" style="width: 10%;"><a
														href="#" class="datatable-sorter">STT</a></th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="width: 25%;"><a
														href="#" class="datatable-sorter">Tên</a></th>
													<th data-sortable="true" style="width: 15%;"><a
														href="#" class="datatable-sorter">Giới Tính</a></th>
													<th data-sortable="true" style="width: 25%;"><a
														href="#" class="datatable-sorter">Địa chỉ</a></th>
													<th data-sortable="true" style="width: 25%;"><a
														href="#" class="datatable-sorter">Email</a></th>
												</tr>
											</thead>
											<tbody>
												<tr data-index="0">
													<td>1</td>
													<td>Technical Author</td>
													<td>Nam</td>
													<td>123 quan hoa</td>
													<td>vanA@gmail.com</td>
												</tr>


											</tbody>
										</table>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Info student end -->

			<!-- Search student start -->
			<div id="search-student"
				class="container-fluid search-student hidden">
				<div class="row">
					<div class="align-items-stretch">
						<div class="card">
							<div class="card-header">
								<i class="fas fa-table me-1"></i> Danh sách học sinh
							</div>
							<div class="card-body">
								<div
									class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
									<div class="datatable-top">
										<div class="datatable-search">
											<input class="datatable-input" placeholder="Search..."
												type="search" title="Search within table"
												aria-controls="datatablesSimple">
										</div>

										<div class="search-student">
											<button class="btn btn-primary search-point-btn">Tìm
												kiếm</button>
										</div>
									</div>
									<div class="datatable-container">
										<table id="datatablesSearchStudent" class="datatable-table">
											<thead>
												<tr>
													<th data-sortable="true" style="width: 10%;"><a
														href="#" class="datatable-sorter">STT</a></th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="width: 25%;"><a
														href="#" class="datatable-sorter">Tên</a></th>
													<th data-sortable="true" style="width: 15%;"><a
														href="#" class="datatable-sorter">Lớp</a></th>
													<th data-sortable="true" style="width: 25%;"><a
														href="#" class="datatable-sorter">TB HKI</a></th>
													<th data-sortable="true" style="width: 25%;"><a
														href="#" class="datatable-sorter">TB HKII</a></th>
												</tr>
											</thead>
											<tbody>
												<tr data-index="0">
													<td>1</td>
													<td>Technical Author</td>
													<td>Nam</td>
													<td>123 quan hoa</td>
													<td>vanA@gmail.com</td>
												</tr>


											</tbody>
										</table>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Search student end -->

			<!-- Table point start -->
			<div id="table-point" class="container-fluid table-point hidden">
				<div class="row">
					<div class="align-items-stretch">
						<div class="card">
							<div class="card-header">
								<i class="fas fa-table me-1"></i> Bảng điểm môn
							</div>
							<div class="card-body">
								<div
									class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
									<div class="datatable-top">
										<div class="datatable-selection">
											<div class="">
												<label>Lớp: </label> <input class="" placeholder="..."
													type="text">
											</div>

											<div class="">
												<label>Học kỳ: </label> <select>
													<option>1</option>
													<option>2</option>
												</select>
											</div>

											<div class="">
												<label>Môn: </label> <select>
													<option>Toán</option>
													<option>Văn</option>
													<option>Đạo đức</option>
													<option>Sinh</option>
													<option>Sử</option>
													<option>Địa</option>
													<option>Lý</option>
													<option>Hóa</option>
													<option>Thể dục</option>
												</select>
											</div>

										</div>


										<div class="search-point">
											<button class="btn btn-primary search-point-btn">Tìm
												kiếm</button>
										</div>

									</div>
									<div class="datatable-container">
										<table id="datatablesPoint" class="datatable-table">
											<thead>
												<tr>
													<th data-sortable="true" style="width: 10%;"><a
														href="#" class="datatable-sorter">STT</a></th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="width: 30%;"><a
														href="#" class="datatable-sorter">Tên</a></th>
													<th data-sortable="true" style="width: 20%;"><a
														href="#" class="datatable-sorter">15'</a></th>
													<th data-sortable="true" style="width: 20%;"><a
														href="#" class="datatable-sorter">1T</a></th>
													<th data-sortable="true" style="width: 20%;"><a
														href="#" class="datatable-sorter">TB môn</a></th>
												</tr>
											</thead>
											<tbody>
												<tr data-index="0">
													<td>1</td>
													<td>Technical Author</td>
													<td>Nam</td>
													<td>123 quan hoa</td>
													<td>vanA@gmail.com</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Table point end -->

			<!-- Report start -->
			<div id="report" class="container-fluid report hidden">
				<div class="row">
					<div class="align-items-stretch">
						<div class="card">
							<div class="card-header">
								<i class="fas fa-table me-1"></i> Báo cáo tổng kết
							</div>
							<div class="card-body">
								<div
									class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
									<div class="datatable-top">
										<div class="datatable-selection">
											<div class="report-type-selection">
												<label for="report-type-selection">Loại: </label> <select
													id="report-type-selection">
													<option></option>
													<option value="report-subject">Báo cáo tổng kết
														môn</option>
													<option value="report-semester">Báo cáo tổng kết
														học kỳ</option>
												</select>
											</div>

											<div class="report-type-list hidden">
												<div id="report-semester"
													class="report-type report-semester-selection">
													<label>Học kỳ: </label> <select>
														<option></option>
														<option>1</option>
														<option>2</option>
													</select>
												</div>

												<div id="report-subject"
													class="report-type report-subject-selection">
													<label>Môn: </label> <select>
														<option></option>
														<option>Toán</option>
														<option>Văn</option>
														<option>Đạo đức</option>
														<option>Sinh</option>
														<option>Sử</option>
														<option>Địa</option>
														<option>Lý</option>
														<option>Hóa</option>
														<option>Thể dục</option>
													</select>
												</div>
											</div>


										</div>


										<div class="search-report">
											<button class="btn btn-primary search-point-btn">Tìm
												kiếm</button>
										</div>

									</div>
									<div class="datatable-container">
										<table id="datatablesReport" class="datatable-table">
											<thead>
												<tr>
													<th data-sortable="true" style="width: 10%;"><a
														href="#" class="datatable-sorter">STT</a></th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending" style="width: 30%;"><a
														href="#" class="datatable-sorter">Lớp</a></th>
													<th data-sortable="true" style="width: 20%;"><a
														href="#" class="datatable-sorter">Sỉ số</a></th>
													<th data-sortable="true" style="width: 20%;"><a
														href="#" class="datatable-sorter">Số lượng đạt</a></th>
													<th data-sortable="true" style="width: 20%;"><a
														href="#" class="datatable-sorter">Tỉ lệ</a></th>
												</tr>
											</thead>
											<tbody>
												<tr data-index="0">
													<td>1</td>
													<td>Technical Author</td>
													<td>Nam</td>
													<td>123 quan hoa</td>
													<td>vanA@gmail.com</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Report end -->

			<!-- Change rule start -->
			<div id="change-rule" class="container-fluid change-rule hidden">
				<div class="row">
					<div class="align-items-stretch">
						<div class="card">
							<div class="card-header">Thay đổi quy định</div>
							<div class="card-body">
								<div class="datatable-wrapper">

									<div class="datatable-selection">
										<label for="change-rule-selection">Loại quy định: </label> <select
											id="change-rule-selection">
											<option></option>
											<option value="QD1">Quy định 1: Thay đổi số tuổi tối
												thiểu, tuổi tối đa</option>
											<option value="QD2">Quy định 2: Thay đổi sỉ số tối
												đa của các lớp</option>
											<option value="QD3">Quy định 3: Thay đổi số lượng
												lớp trong trường</option>
											<option value="QD4">Quy định 4: Thay đổi số lượng
												các môn học</option>
											<option value="QD5">Quy định 5: Thay đổi điểm đạt
												môn</option>
										</select>
									</div>

									<div class="change-rule-list hidden">
										<div id="QD1" class="rule">

											<div class="card">
												<header class="change-rule-top">
													<h5>Thay đổi số tuổi tối thiểu, tuổi tối đa</h5>
												</header>

												<div class="change-rule-container">
													<div class="change-rule-group rule1-min-age">
														<label for="min-age-rule">Nhập tuổi tối thiểu:</label> <input
															type="text" id="min-age-rule"
															placeholder="Tuổi tối thiểu">
													</div>

													<div class="change-rule-group rule1-max-age">
														<label for="max-age-rule">Nhập tuổi tối đa:</label> <input
															type="text" id="max-age-rule" placeholder="Tuổi tối đa">
													</div>
												</div>


												<div class="change-rule-bottom">
													<div class="change-rule-confirm">
														<button class="btn btn-primary change-rule-cancel-btn">Hủy</button>
														<button class="btn btn-primary change-rule-confirm-btn">Xác
															nhận</button>
													</div>
												</div>
											</div>

										</div>


										<div id="QD2" class="rule">
											<div class="card">
												<header class="change-rule-top">
													<h5>Thay đổi sỉ số tối đa của các lớp</h5>
												</header>

												<div class="change-rule-container">
													<div class="change-rule-group rule2-max-number">
														<label for="max-number-of-student">Nhập sỉ số tối
															đa:</label> <input type="text" id="max-number-of-student"
															placeholder="Sỉ số tối đa">
													</div>

												</div>


												<div class="change-rule-bottom">
													<div class="change-rule-confirm">
														<button class="btn btn-primary change-rule-cancel-btn">Hủy</button>
														<button class="btn btn-primary change-rule-confirm-btn">Xác
															nhận</button>
													</div>
												</div>
											</div>
										</div>

										<div id="QD3" class="rule">
											<div class="card">
												<header class="change-rule-top">
													<h5>Thay đổi số lượng lớp trong trường</h5>
												</header>

												<div class="change-rule-container">
													<div class="change-rule-group rule3-max-number">
														<label for="max-number-of-class">Nhập số lượng
															lớp:</label> <input type="text" id="max-number-of-class"
															placeholder="Số lượng lớp">
													</div>
												</div>


												<div class="change-rule-bottom">
													<div class="change-rule-confirm">
														<button class="btn btn-primary change-rule-cancel-btn">Hủy</button>
														<button class="btn btn-primary change-rule-confirm-btn">Xác
															nhận</button>
													</div>
												</div>
											</div>
										</div>

										<div id="QD4" class="rule">
											<div class="card">
												<header class="change-rule-top">
													<h5>Thay đổi số lượng các môn học</h5>
												</header>

												<div class="change-rule-container">
													<div class="change-rule-group rule4-max-number">
														<label for="max-number-of-subject">Nhập số lượng
															các môn học:</label> <input type="text"
															id="max-number-of-subject" placeholder="Số lượng môn học">
													</div>
												</div>


												<div class="change-rule-bottom">
													<div class="change-rule-confirm">
														<button class="btn btn-primary change-rule-cancel-btn">Hủy</button>
														<button class="btn btn-primary change-rule-confirm-btn">Xác
															nhận</button>
													</div>
												</div>
											</div>
										</div>

										<div id="QD5" class="rule">
											<div class="card">
												<header class="change-rule-top">
													<h5>Thay đổi điểm đạt môn</h5>
												</header>

												<div class="change-rule-container">
													<div class="change-rule-group rule5-point">
														<label for="min-point">Nhập điểm đạt môn học:</label> <input
															type="text" id="min-point" placeholder="Điểm đạt">
													</div>
												</div>


												<div class="change-rule-bottom">
													<div class="change-rule-confirm">
														<button class="btn btn-primary change-rule-cancel-btn">Hủy</button>
														<button class="btn btn-primary change-rule-confirm-btn">Xác
															nhận</button>
													</div>
												</div>
											</div>
										</div>
									</div>



								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Change rule end -->

		</div>
		<!--  Main wrapper -->

	</div>


	<!-- Modal add student -->
	<div class="modal add-student-modal">
		<div class="modal-container add-student-modal-container">

			<div class="icon-close js-modal-close">
				<i class="modal-icon-close fa-solid fa-xmark"></i>
			</div>

			<header class="modal-header"> Thêm học sinh mới </header>

			<div class="modal-body">
				<div class="model-input-item">
					<label for="student-name" class="modal-label">Tên:</label> <input
						type="text" id="student-name" class="modal-input"
						placeholder="Họ tên">
				</div>

				<div class="model-input-item">
					<label class="modal-label">Giới tính:</label>
					<div class="student-gender">
						<div class="student-gender-wrap">
							<label for="student-male" class="modal-label">Nam</label> <input
								type="radio" id="student-male" class="modal-input"
								name="gender-group" value="Nam">
						</div>

						<div class="student-gender-wrap">
							<label for="student-female" class="modal-label">Nữ</label> <input
								type="radio" id="student-female" class="modal-input"
								name="gender-group" value="Nữ">
						</div>

					</div>

				</div>

				<div class="model-input-item">
					<label for="student-year" class="modal-label">Năm sinh:</label> <input
						type="text" id="student-year" class="modal-input"
						placeholder="Năm sinh">
				</div>

				<div class="model-input-item">
					<label for="student-address" class="modal-label">Địa chỉ:</label> <input
						type="text" id="student-address" class="modal-input"
						placeholder="Địa chỉ">
				</div>

				<div class="model-input-item">
					<label for="student-email" class="modal-label">Email:</label> <input
						type="email" id="student-email" class="modal-input"
						placeholder="Email">
				</div>

			</div>

			<footer class="modal-footer">
				<button class="btn btn-primary cancel-add-student-btn">Hủy</button>
				<button class="btn btn-primary confirm-add-studen-btn">Xác
					nhận</button>
			</footer>
		</div>
	</div>

	<!-- Modal edit password -->
	<div class="modal edit-pass-modal">
		<div class="modal-container edit-pass-modal-container">

			<div class="icon-close js-modal-edit-pass-close">
				<i class="modal-icon-close fa-solid fa-xmark"></i>
			</div>

			<header class="modal-header"> Đổi mật khẩu </header>

			<div class="modal-body">
				<div class="model-input-item">
					<label for="new-password" class="modal-label">Mật khẩu mới:</label>
					<input type="text" id="new-password" class="modal-input"
						placeholder="Mật khẩu mới">
				</div>


				<div class="model-input-item">
					<label for="comfirm-new-password" class="modal-label">Xác
						nhận mật khẩu mới:</label> <input type="text" id="comfirm-new-password"
						class="modal-input" placeholder="Xác nhận mật khẩu mới">
				</div>

			</div>

			<footer class="modal-footer">
				<button class="btn btn-primary cancel-edit-pass-btn">Hủy</button>
				<button class="btn btn-primary confirm-edit-pass-btn">Xác
					nhận</button>
			</footer>
		</div>
	</div>

	<!-- Modal add class -->
	<div class="modal add-class-modal">
		<div class="modal-container add-class-modal-container">

			<div class="icon-close js-modal-add-class-close">
				<i class="modal-icon-close fa-solid fa-xmark"></i>
			</div>

			<header class="modal-header"> Thêm lớp mới </header>

			<div class="modal-body">
				<div class="model-input-item">
					<label for="new-class" class="modal-label">Tên lớp:</label> <input
						type="text" id="new-class" class="modal-input"
						placeholder="Tên lớp">
				</div>


				<div class="model-input-item">
					<label for="number-of-student" class="modal-label">Sỉ số:</label> <input
						type="text" id="number-of-student" class="modal-input"
						placeholder="Sỉ số">
				</div>

			</div>

			<footer class="modal-footer">
				<button class="btn btn-primary cancel-add-class-btn">Hủy</button>
				<button class="btn btn-primary confirm-add-class-btn">Xác
					nhận</button>
			</footer>
		</div>
	</div>

	<!-- Modal list students to add class -->
	<div class="modal list-students-modal">
		<div class="modal-container list-students-modal-container">
			<div class="icon-close js-modal-list-students-close">
				<i class="modal-icon-close fa-solid fa-xmark"></i>
			</div>

			<header class="modal-header"> Danh sách học sinh </header>


			<div class="datatable-container">
				<table id="datatablesListStudent" class="datatable-table">
					<thead>
						<tr>
							<th data-sortable="true" style="width: 10%;"><a href="#"
								class="datatable-sorter">STT</a></th>
							<th data-sortable="true" aria-sort="descending"
								class="datatable-descending" style="width: 25%;"><a
								href="#" class="datatable-sorter">Tên</a></th>
							<th data-sortable="true" style="width: 15%;"><a href="#"
								class="datatable-sorter">Giới Tính</a></th>
							<th data-sortable="true" style="width: 25%;"><a href="#"
								class="datatable-sorter">Địa chỉ</a></th>
							<th data-sortable="true" style="width: 25%;"><a href="#"
								class="datatable-sorter">Email</a></th>
						</tr>
					</thead>
					<tbody>
						<tr data-index="0">
							<td>1</td>
							<td>Technical Author</td>
							<td>Nam</td>
							<td>123 quan hoa</td>
							<td>vanA@gmail.com</td>
							<td class="choose-student-to-class"><input
								class="choose-student-to-class-input" type="checkbox"></td>
						</tr>
					</tbody>
				</table>
			</div>

			<footer class="modal-footer">
				<button class="btn btn-primary cancel-list-students-btn">Hủy</button>
				<button class="btn btn-primary confirm-list-students-btn"><a href = "./listStudentOfClass.jsp">Xác
				nhận</a></button>
			</footer>
		</div>
	</div>



	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>


	<script src="./js/app.js"></script>
	<script src="./js/changeRule.js"></script>
	<script src="./js/reportTypeHandle.js"></script>
	<script src="./js/darkTheme.js"></script>
	<script src="./js/editClassName.js"></script>
	<script src="./js/pagination.js"></script>
	<script src="./js/modalAddClass.js"></script>
	<script src="./js/modalAddStudent.js"></script>
	<script src="./js/modalEditPass.js"></script>
	<script src="./js/modalListStudent.js"></script>
	<script src="./js/showPass.js"></script>
</body>
</html>