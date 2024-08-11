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
							<li class="sidebar-item mg-l-4"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/changePasswordServlet" aria-expanded="false"> <span> <i
										class="fa fa-solid fa-user"></i>
								</span> <span class="hide-menu">Tài Khoản</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/infoClassServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-chalkboard-user"></i>
								</span> <span class="hide-menu">Lớp</span>
							</a></li>
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
							<li class="sidebar-item"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/InfoSubjectServlet"
								aria-expanded="false"> <span> <i
										class="fa fa-solid fa-book-open"></i>
								</span> <span class="hide-menu">Môn</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link"
								href="<%=request.getContextPath()%>/tablePointServlet" aria-expanded="false"> <span>
										<i class="fa fa-solid fa-table"></i>
								</span> <span class="hide-menu">Bảng điểm</span>
							</a></li>

							<li class="sidebar-item"><a class="sidebar-link"
								href="./report.jsp" aria-expanded="false"> <span> <i
										class="fa fa-solid fa-file-excel"></i>
								</span> <span class="hide-menu">Báo cáo</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link active"
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

			<!-- Change rule start -->
			<div id="change-rule" class="container-fluid change-rule">
				<div class="row">
					<div class="align-items-stretch">
						<div class="card">
							<div class="card-header">Thay đổi quy định</div>
							<div class="card-body">
								<div class="datatable-wrapper">
									<h3 class="text-center mb-4">Tiêu chuẩn của các quy định
										hiện tại</h3>

									<div class="datatable-container">
										<table id="datatablesChangeRule" class="datatable-table">
											<thead>
												<tr>
													<th data-sortable="true"
														style="width: 5%; text-align: center;"><a href="#"
														class="datatable-sorter">STT</a></th>
													<th data-sortable="true" aria-sort="descending"
														class="datatable-descending"
														style="width: 30%; text-align: center;"><a href="#"
														class="datatable-sorter">Loại quy định</a></th>
													<th data-sortable="true"
														style="width: 20%; text-align: center;"><a href="#"
														class="datatable-sorter">Tiêu chuẩn</a></th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td style="text-align: center;"><%=i++%></td>
													<td
														class="changeRuleName-edit d-flex justify-content-between ps-4">Tuổi
														tối đa <span> <i
															class="changeRule1 changeRule-edit-icon fa fa-solid fa-pen-to-square"
															<c:if test="${sessionScope.account.isAdmin != 1 && sessionScope.account.isAdmin != 4}">
													                   aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													               </c:if>></i>
													</td>
													<td style="text-align: center;">${CR.tuoiHSToiDa}</td>
												</tr>
												<tr>
													<td style="text-align: center;"><%=i++%></td>
													<td
														class="changeRuleName-edit d-flex justify-content-between ps-4">Tuổi
														tối thiểu<span> <i
															class="changeRule1 changeRule-edit-icon fa fa-solid fa-pen-to-square"
															<c:if test="${sessionScope.account.isAdmin != 1 && sessionScope.account.isAdmin != 4}">
													                   aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													               </c:if>></i>
													</td>
													<td style="text-align: center;">${CR.tuoiHSToiThieu}</td>
												</tr>
												<tr>
													<td style="text-align: center;"><%=i++%></td>
													<td
														class="changeRuleName-edit d-flex justify-content-between ps-4">Sĩ
														số tối đa<span> <i
															class="changeRule2 changeRule-edit-icon fa fa-solid fa-pen-to-square"
															<c:if test="${sessionScope.account.isAdmin != 1 && sessionScope.account.isAdmin != 4}">
													                   aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													               </c:if>></i>
													</td>
													<td style="text-align: center;">${CR.soLuongHSToiDa}</td>
												</tr>
												<tr>
													<td style="text-align: center;"><%=i++%></td>
													<td
														class="changeRuleName-edit d-flex justify-content-between ps-4">Điểm
														tối đa<span> <i
															class="changeRule3 changeRule-edit-icon fa fa-solid fa-pen-to-square"
															<c:if test="${sessionScope.account.isAdmin != 1 && sessionScope.account.isAdmin != 4}">
													                   aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													               </c:if>></i>
													</td>
													<td style="text-align: center;">${CR.diemToiDa}</td>
												</tr>
												<tr>
													<td style="text-align: center;"><%=i++%></td>
													<td
														class="changeRuleName-edit d-flex justify-content-between ps-4">Điểm
														tối thiểu<span> <i
															class="changeRule3 changeRule-edit-icon fa fa-solid fa-pen-to-square"
															<c:if test="${sessionScope.account.isAdmin != 1 && sessionScope.account.isAdmin != 4}">
													                   aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													               </c:if>></i>
													</td>
													<td style="text-align: center;">${CR.diemToiThieu}</td>
												</tr>
												<tr>
													<td style="text-align: center;"><%=i++%></td>
													<td
														class="changeRuleName-edit d-flex justify-content-between ps-4">Điểm
														đạt<span> <i
															class="changeRule4 changeRule-edit-icon fa fa-solid fa-pen-to-square"
															<c:if test="${sessionScope.account.isAdmin != 1 && sessionScope.account.isAdmin != 4}">
													                   aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													               </c:if>></i>
													</td>
													<td style="text-align: center;">${CR.diemDat}</td>
												</tr>
												
											</tbody>
										</table>

									</div>
									<div class="add-rule">
									<c:if test="${sessionScope.account.isAdmin == 1 || sessionScope.account.isAdmin == 4}">
										<button style="margin-left: 689px; margin-top: 20px;" class="btn btn-primary add-rule-btn"
													                   aria-disabled="true" style="pointer-events: none; opacity: 0.5;"
													               >Thêm
											quy định</button>
											</c:if>
									</div>

									<div id="QD1" class="changeRuleForm">
										<div class="rule">
											<div class="card">
												<header class="change-rule-top">
													<h5>Thay đổi số tuổi tối thiểu, tuổi tối đa</h5>
												</header>
												<form action="<%=request.getContextPath()%>/ChangeRuleServlet">
													<input type="hidden" name="action" value="/updateTuoi">
													<div class="change-rule-container">

														<div class="change-rule-group rule1-min-age">
															<label for="min-age-rule">Nhập tuổi tối thiểu:</label> <select
																id="min-age-rule" name="tuoiHSToiThieu">
																<option>10</option>
																<option>11</option>
																<option>12</option>
																<option>13</option>
																<option>14</option>
																<option>15</option>
															</select>


														</div>

														<div class="change-rule-group rule1-max-age">
															<label for="max-age-rule">Nhập tuổi tối đa:</label> <select
																id="max-age-rule" name="tuoiHSToiDa">
																<option>20</option>
																<option>21</option>
																<option>22</option>
																<option>23</option>
																<option>24</option>
																<option>25</option>
															</select>
														</div>
													</div>

													<div class="change-rule-bottom">
														<div class="change-rule-confirm">
															<button type="button"
																class="btn btn-primary change-rule-cancel-btn btn-cancel">Hủy</button>
															<button type="submit"
																class="btn btn-primary change-rule-confirm-btn">Xác
																nhận</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>

									<div id="QD2" class="changeRuleForm">
										<div class="rule">
											<div class="card">
												<header class="change-rule-top">
													<h5>Thay đổi sỉ số tối đa của các lớp</h5>
												</header>
												<form action="<%=request.getContextPath()%>/ChangeRuleServlet">
													<input type="hidden" name="action" value="/updateSiSo">
													<div class="change-rule-container">
														<div class="change-rule-group rule2-max-number">
															<label for="max-number-of-student">Nhập sỉ số tối
																đa:</label> <select id="max-number-of-student" name="siSoToiDa">
																<option>30</option>
																<option>35</option>
																<option>40</option>
															</select>
														</div>
													</div>
													<div class="change-rule-bottom">
														<div class="change-rule-confirm">
															<button type="button"
																class="btn btn-primary change-rule-cancel-btn btn-cancel">Hủy</button>
															<button type="submit"
																class="btn btn-primary change-rule-confirm-btn">Xác
																nhận</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>

									<div id="QD3" class="changeRuleForm">
										<div class="rule">
											<div class="card">
												<header class="change-rule-top">
													<h5>Thay đổi điểm tối thiểu, điểm tối đa</h5>
												</header>
												<form action="<%=request.getContextPath()%>/ChangeRuleServlet">
													<input type="hidden" name="action" value="/updateDiem">
													<div class="change-rule-container">

														<div class="change-rule-group rule1-min-point">
															<label for="max-point-rule">Điểm tối thiểu:</label> <select
																id="min-point-rule" name="minPoint">
																<option>0</option>
																<option>1</option>
																<option>2</option>
																<option>3</option>
															</select>
														</div>


														<div class="change-rule-group rule1-max-point">
															<label for="max-point-rule">Điểm tối đa:</label> <select
																id="max-point-rule" name="maxPoint">
																<option>4</option>
																<option>5</option>
																<option>10</option>
															</select>
														</div>
													</div>

													<div class="change-rule-bottom">
														<div class="change-rule-confirm">
															<button type="button"
																class="btn btn-primary change-rule-cancel-btn btn-cancel">Hủy</button>
															<button type="submit"
																class="btn btn-primary change-rule-confirm-btn">Xác
																nhận</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>

									<div id="QD4" class="changeRuleForm">
										<div class="rule">
											<div class="card">
												<header class="change-rule-top">
													<h5>Thay đổi điểm đạt môn</h5>
												</header>
												<form action="<%=request.getContextPath()%>/ChangeRuleServlet">
													<input type="hidden" name="action" value="/updateDiemDat">
													<div class="change-rule-container">
														<div class="change-rule-group rule5-point">
															<label for="min-point">Nhập điểm đạt môn học:</label> <select
																id="min-point" name="pointPass">
																<option>3</option>
																<option>4</option>
																<option>5</option>
															</select>
														</div>
													</div>

													<div class="change-rule-bottom">
														<div class="change-rule-confirm">
															<button type="button"
																class="btn btn-primary change-rule-cancel-btn btn-cancel">Hủy</button>
															<button type="submit"
																class="btn btn-primary change-rule-confirm-btn">Xác
																nhận</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>


									<div id="QDX" class="changeRuleForm">
										<div class="rule">
											<div class="card">
												<header class="change-rule-top">
													<h5>Thêm quy định</h5>
												</header>
												<form action="<%=request.getContextPath()%>/ChangeRuleServlet">
													<input type="hidden" name="action" value="/insert">
													<div class="change-rule-container">
														<div class="change-rule-group ruleX">
															<label for="min-point">Nhập tên quy định:</label> <input
																type="text" id="new-rule" class="modal-input"
																placeholder="Tên quy định" name="ruleName">
														</div>
														
														<div class="change-rule-group ruleX">
															<label for="min-point">Nhập tiêu chuẩn:</label> <input
																type="text" id="new-standard-rule" class="modal-input"
																placeholder="Tiêu chuẩn" name="ruleStandard">
														</div>
													</div>

													<div class="change-rule-bottom">
														<div class="change-rule-confirm">
															<button type="button"
																class="btn btn-primary change-rule-cancel-btn btn-cancel">Hủy</button>
															<button type="submit"
																class="btn btn-primary change-rule-confirm-btn">Xác
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
				</div>
			</div>

		</div>


		<!-- Change rule end -->

	</div>
	<!--  Main wrapper -->



	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
	<script src="./js/app.js"></script>
	<script src="./js/pagination.js"></script>
	<script>
	const changeRule1 = document.querySelectorAll('.changeRule1')
	const changeRule2 = document.querySelector('.changeRule2')
	const changeRule3 = document.querySelectorAll('.changeRule3')
	const changeRule4 = document.querySelector('.changeRule4')
	const btnChangeRuleX = document.querySelector('.add-rule-btn')
	const changeRuleForm1 = document.getElementById('QD1')
	const changeRuleForm2 = document.getElementById('QD2')
	const changeRuleForm3 = document.getElementById('QD3')
	const changeRuleForm4 = document.getElementById('QD4')
	const changeRuleFormX = document.getElementById('QDX')
	const changeRuleFormContainer = document.querySelectorAll('.rule')
	const cancelChangeRuleBtn = document.querySelectorAll('.change-rule-cancel-btn')
	const changeRuleForms = document.querySelectorAll('.changeRuleForm')

	changeRule1.forEach(function(item) {
		item.addEventListener('click', () => {
			changeRuleForm1.classList.add('open')
		})
	});

	changeRule2.addEventListener('click', () => {
		changeRuleForm2.classList.add('open')
	})
	
	changeRule3.forEach(function(item) {
		item.addEventListener('click', () => {
			changeRuleForm3.classList.add('open')
		})
	});
	
	changeRule4.addEventListener('click', () => {
		changeRuleForm4.classList.add('open')
	})
	
	btnChangeRuleX.addEventListener('click', () => {
		changeRuleFormX.classList.add('open')
	})
	
	
	changeRuleForm1.addEventListener('click', () => {
		changeRuleForm1.classList.remove('open')
	})
	changeRuleForm2.addEventListener('click', () => {
		changeRuleForm2.classList.remove('open')
	})
	
	changeRuleForm3.addEventListener('click', () => {
		changeRuleForm3.classList.remove('open')
	})
	changeRuleForm4.addEventListener('click', () => {
		changeRuleForm4.classList.remove('open')
	})
	changeRuleFormX.addEventListener('click', () => {
		changeRuleFormX.classList.remove('open')
	})
	
	changeRuleFormContainer.forEach(function(item) {
		item.addEventListener('click', (event) => {event.stopPropagation()})
	});
	
	cancelChangeRuleBtn.forEach(function(item) {
		item.addEventListener('click', () => {
			changeRuleForms.forEach(function(changeRuleForm) {
				if(changeRuleForm.classList.contains("open")) {
					changeRuleForm.classList.remove('open')
				}
			});
		})
	});
	
	</script>
	
	<script type="text/javascript">
		(function(d, m) {
			var kommunicateSettings = {
				"appId" : "1f738c914043ebc4eff88a22ec4875001",
				"popupWidget" : true,
				"automaticChatOpenOnNavigation" : true
			};
			var s = document.createElement("script");
			s.type = "text/javascript";
			s.async = true;
			s.src = "https://widget.kommunicate.io/v2/kommunicate.app";
			var h = document.getElementsByTagName("head")[0];
			h.appendChild(s);
			window.kommunicate = m;
			m._globals = kommunicateSettings;
		})(document, window.kommunicate || {});
	</script>

</body>
</html>
