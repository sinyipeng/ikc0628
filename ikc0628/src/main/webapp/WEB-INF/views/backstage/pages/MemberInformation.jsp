<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link>
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
<script
	src='http://fullcalendar.io/js/fullcalendar-2.1.1/lib/moment.min.js'></script>
<script
	src='http://fullcalendar.io/js/fullcalendar-2.1.1/lib/jquery.min.js'></script>
<script
	src="http://fullcalendar.io/js/fullcalendar-2.1.1/lib/jquery-ui.custom.min.js"></script>
<script
	src='http://fullcalendar.io/js/fullcalendar-2.1.1/fullcalendar.min.js'></script>
<style>
body {
	position: relative;
	height: 100%;
	width: 100%;
	overflow: hidden;
	background: rgb(89, 91, 95);
}

.sidebar {
	position: fixed;
	top: 0;
	left: 0;
	height: 100%;
	width: 80px;
	background: #11101d;
	padding: 20px 40px;
	transition: all 0.5s ease;
	z-index: 10;
}

.sidebar.active {
	width: 300px;
}

.sidebar .logo_content .logo {
	color: #fff;
	display: flex;
	height: 50px;
	width: 100%;
	align-items: center;
	opacity: 0;
	pointer-events: none;
}

.sidebar.active .logo_content .logo {
	opacity: 1;
	pointer-events: none;
	transition: all 0.5s ease;
}

.logo_content .logo .logo_name {
	font-size: 40px;
	font-weight: 500;
	white-space: nowrap;
}

.sidebar #btn {
	position: absolute;
	color: #fff;
	left: 50%;
	top: 20px;
	font-size: 40px;
	height: 50px;
	width: 50px;
	text-align: center;
	line-height: 50px;
	transform: translateX(-50%);
	transition: all 0.5s ease;
	border-radius: 12px;
	cursor: pointer;
}

.sidebar #btn:hover {
	color: #11101d;
	background-color: #fff;
	border-radius: 12px;
}

.sidebar.active #btn {
	left: 90%;
	transition: all 0.5s ease;
}

.sidebar ul {
	margin-top: 50px;
}

.sidebar ul li {
	position: relative;
	height: 50px;
	width: 100%;
	margin: 30px -60px;
	list-style: none;
	line-height: 50px;
	font-size: 30px;
	white-space: nowrap;
}

.sidebar ul li .tooltip {
	position: absolute;
	left: 130px;
	top: 0;
	transform: translate(-50%, -50%);
	border-radius: 6px;
	height: 35px;
	width: 130px;
	background: rgb(201, 205, 250);
	line-height: 35px;
	font-size: 25px;
	font-weight: 600;
	text-align: center;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	transition: 0s;
	opacity: 0;
	pointer-events: none;
	display: block;
}

.sidebar.active ul li .tooltip {
	display: none;
}

.sidebar ul li:hover .tooltip {
	transition: all 0.5s ease;
	opacity: 1;
	top: 50%;
}

.sidebar ul li a {
	color: #fff;
	display: flex;
	align-items: center;
	text-decoration: none;
	border-radius: 12px;
}

.sidebar ul li a:hover {
	color: #11101d;
	background: #fff;
}

.sidebar ul li i {
	height: 50px;
	min-width: 50px;
	border-radius: 12px;
	line-height: 50px;
	text-align: center;
}

.sidebar.sidebar ul li i:hover {
	background-color: #fff;
}

.sidebar .links_name {
	opacity: 0;
	pointer-events: none;
}

.sidebar.active .links_name {
	opacity: 1;
	pointer-events: none;
	transition: all 0.5s ease;
}

.sidebar .profile_content {
	position: absolute;
	color: #fff;
	bottom: 0;
	left: 0%;
	width: 100%;
}

.sidebar .profile_content .profile {
	position: relative;
	padding: 20px 10px;
	height: 80px;
	background: none;
	transition: all 0.5s ease;
}

.sidebar.active .profile_content .profile {
	background: #282644;
}

.profile_content .profile .profile_details {
	display: flex;
	align-items: center;
	opacity: 0;
	pointer-events: none;
	white-space: nowrap;
}

.sidebar.active .profile .profile_details {
	opacity: 1;
	pointer-events: auto;
	transition: all 0.5s ease;
}

.profile .profile_details img {
	height: 50px;
	width: 50px;
	object-fit: cover;
	border-radius: 12px;
}

.profile .profile_details .name_level {
	margin-left: 15px;
}

.profile .profile_details .name {
	font-size: 25px;
	font-weight: 400;
}

.profile .profile_details .level {
	font-size: 16px;
	font-weight: 400;
}

.profile #log_out {
	position: absolute;
	left: 50%;
	bottom: 10px;
	transform: translateX(-50%);
	min-width: 60px;
	min-height: 60px;
	line-height: 60px;
	font-size: 40px;
	border-radius: 12px;
	text-align: center;
	transition: all 0.5s ease;
	background: #282644;
	cursor: pointer;
}

.log_out_contain .tooltip {
	position: absolute;
	left: 150px;
	top: 0;
	transform: translate(-50%, -50%);
	border-radius: 6px;
	height: 35px;
	width: 120px;
	background: rgb(201, 205, 250);
	color: #11101d;
	line-height: 35px;
	font-size: 25px;
	font-weight: 600;
	text-align: center;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	transition: 0s;
	opacity: 0;
	pointer-events: none;
	display: block;
}

.log_out_contain:hover .tooltip {
	transition: all 0.5s ease;
	opacity: 1;
	top: 50%;
}

.sidebar.active .log_out_contain .tooltip {
	left: 370px;
}

.log_out_contain #log_out:hover {
	color: #11101d;
	background-color: #fff;
}

.sidebar.active .profile #log_out {
	left: 90%;
	background: none;
	transition: all 0.5s ease;
}

.sidebar.active .profile #log_out:hover {
	color: #11101d;
	background-color: #fff;
}

.header {
	position: relative;
	height: 100px;
	width: 100vw;
	left: 80px;
	transition: all 0.5s ease;
	background: #282644;
}

.header .text {
	position: fixed;
	font-size: 50px;
	font-weight: 500;
	color: #fff;
	padding-left: 50px;
	padding-top: 20px;
}

.main {
	position: relative;
	left: 80px;
	top: 13%;
	width: calc(100% - 80px);
	height: 87vh;
	transition: all 0.5s ease;
}

.sidebar.active ~.header {
	width: calc(100% -300px);
	left: 300px;
}

.sidebar.active ~.main {
	width: calc(100% -300px);
	left: 300px;
}

.main .back {
	position: absolute;
	width: 150px;
	height: 40px;
	right: 100px;
	bottom: 50px;
}

.main .back a {
	position: fixed;
	color: #fff;
	font-size: 24px;
	width: 150px;
	height: 40px;
	text-align: center;
	text-decoration: none;
	background: #252f52;
	border-radius: 12px;
}

.main .back a:hover {
	background: #485688;
}

.main .insert {
	position: absolute;
	width: 150px;
	height: 40px;
	bottom: 50px;
	left: 100px;
}

.main .insert #insert_btn {
	position: fixed;
	color: #fff;
	background: #252f52;
	font-size: 24px;
	width: 150px;
	height: 40px;
	text-align: center;
	text-decoration: none;
	border-radius: 12px;
	border: none;
}

.main .insert #insert_btn:hover {
	background: #485688;
}

table {
	table-layout: inherit;
	position: absolute;
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 14px;
	text-align: left;
	border-collapse: collapse;
	text-align: left;
	width: 92%;
	height: 70%;
	margin: 3%;
	font-size: 14px;
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	margin: 3%;
}

th {
	font-size: 18px;
	font-weight: bold;
	padding: 8px;
	background: #192342;
	border-bottom: 1px solid #fff;
	color: #fff;
}

th:first-child {
	border-top-left-radius: 10px;
}

th:last-child {
	border-top-right-radius: 10px;
}

td {
	padding: 8px;
	background: #3e4b7a;
	border-bottom: 1px solid #fff;
	color: #fff;
	border-top: 1px solid transparent;
}

td a {
	padding: 8px;
	color: #fff;
	text-decoration: none;
}

tr:hover td {
	background: #a0a8c7;
	color: #3e4b7a;
}

tr:hover td a {
	font-weight: bold;
	background: #788dd8;
	color: #3e4b7a;
	border-radius: 12px;
	background: #788dd8;
}

.modal_bg {
	position: fixed;
	width: 100%;
	height: 100vh;
	top: 0;
	left: 0;
	background-color: rgba(0, 0, 0, 0.5);
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: left;
	visibility: hidden;
	opacity: 0;
	transition: visibility 0s, opacity 0.5s;
}

.bg_active {
	visibility: visible;
	opacity: 1;
}

.modal {
	position: relative;
	background-color: rgb(87, 87, 96);
	border-radius: 12px;
	width: 70%;
	max-height: calc(100vh - 210px);
	font-weight: 600;
	display: flex;
	flex-direction: column;
	overflow-y: scroll;
}

::-webkit-scrollbar {
	width: 20px;
}

::-webkit-scrollbar-track {
	background: rgb(255, 249, 249);
	border-radius: 12px;
}

::-webkit-scrollbar-thumb {
	background: rgb(33, 35, 38);
	border-radius: 15px;
}

.modal .modal_head {
	position: relative;
	height: 10%;
	padding: 2% 0% 5% 5%;
	color: #fff;
	font-size: 20px;
	font-weight: 600;
	background: #000d34;
}

.modal .modal_in {
	position: relative;
	padding: 5%;
	color: #fff;
	display: flex;
	flex-direction: column;
}

.modal_in .getvalue {
	margin-bottom: 20px;
	background: none;
	border: none;
	border-radius: 12px;
	outline: none;
	color: rgb(0, 0, 0);
	caret-color: rgb(0, 0, 0);
	-webkit-text-fill-color: rgb(0, 0, 0);
	-webkit-box-shadow: 0 0 0 40px #ffffff inset !important;
	border-bottom: 1.5px solid rgb(234, 236, 251);
}

.getvalue option {
	background: rgb(87, 87, 96);
	color: #fff;
}

.modal .modal_bottom {
	position: relative;
	padding: 1% 2% 1% 1%;
	text-align: right;
	background: #000d34;
}

.modal_bottom .send {
	height: 40px;
	width: 100px;
	font-size: 18px;
	font-weight: 600;
	background-color: rgb(29, 56, 211);
	color: #fff;
	border: none;
	border-radius: 30px;
}

.modal_close {
	position: absolute;
	font-family: "Poppins", sans-serif;
	font-size: 20px;
	padding: 0px 5px;
	border-radius: 5px;
	color: #fff;
	background: rgb(59, 56, 94);
	top: 5%;
	right: 2%;
	font-weight: 800;
	cursor: pointer;
}
</style>
<title>供應商系統</title>
</head>
<body>
	<div class="sidebar">
		<div class="logo_content">
			<div class="logo">
				<div class="logo_name">後台管理</div>
			</div>
			<i class='bx bx-menu' id="btn"></i>
		</div>
		<ul class="nav_list">
			<li><a href="<c:url value="/backstage/pages/MemberControl"/>">
					<i class='bx bxs-user-account'></i> <span class="links_name">會員清單</span>
			</a> <span class="tooltip">會員清單</span></li>
			<li><a href="<c:url value="/backstage/pages/Product"/>"> <i
					class='bx bxs-store'></i> <span class="links_name">商品管理</span>
			</a> <span class="tooltip">商品管理</span></li>
			<li><a href="<c:url value="/backstage/pages/SuppliesDisplay"/>">
					<i class='bx bxs-truck'></i> <span class="links_name">廠商清單</span>
			</a> <span class="tooltip">廠商清單</span></li>
			<li><a href="<c:url value="/backstage/pages/OrdersDisplay"/>">
					<i class='bx bx-spreadsheet'></i> <span class="links_name">訂單管理</span>
			</a> <span class="tooltip">訂單管理</span></li>
		</ul>
		<div class="profile_content">
			<div class="profile">
				<div class="profile_details">
					<img
						src="https://www.nintendo.com.hk/character/kirby/assets/img/home/kirby-pink.png"
						alt="">
					<div class="name_level">
						<div class="name">GIS</div>
						<div class="level">管理員</div>
					</div>
				</div>
				<div class="log_out_contain">
					<i class='bx bx-log-out' id="log_out"></i> <span class="tooltip">登出</span>
				</div>
			</div>
		</div>
	</div>
	<div class="header">
		<div class="class text">IK Care 後台管理系統</div>
	</div>
	<div class="main">

		<table>
			<thead id="infoview">
				<tr>
					<th>用戶姓名</th>
					<th>身高</th>
					<th>體重</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="display: none;"><input type="hidden" name="bodyid"
						value="${row.bodyid}"></td>
					<td style="display: none;"><input type="hidden"
						name="useraccount" value="${row.useraccount}"></td>
					<td>${row.membername}<input type="hidden" name="membername"
						value="${row.membername}"></td>
					<td>${row.memberheight}<input type="hidden"
						name="memberheight" value="${row.memberheight}"></td>
					<td>${row.memberweight}<input type="hidden"
						name="memberweight" value="${row.memberweight}"></td>
				</tr>
			</tbody>

			<thead id="dietview">
				<tr>
					<th>食物名稱</th>
					<th>每份熱量</th>
					<th>食物份量</th>
					<th>飲食日期</th>
					<th>飲食時段</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="display: none;">${row.dietid}<input type="hidden"
						name="dietid" value="${row.dietid}"></td>
					<td style="display: none;">${row.useraccount}<input
						type="hidden" name="useraccount" value="${row.useraccount}"></td>
					<td>${row.samplename}<input type="hidden" name="samplename"
						value="${row.samplename}"></td>
					<td>${row.calories}<input type="hidden" name="calories"
						value="${row.calories}"></td>
					<td>${row.foodnumber}<input type="hidden" name="foodnumber"
						value="${row.foodnumber}"></td>
					<td>${row.dietdate}<input type="hidden" name="dietdate"
						value="${row.dietdate}"></td>
					<td>${row.diettime}<input type="hidden" name="diettime"
						value="${row.diettime}"></td>
				</tr>
			</tbody>

			<thead id="sportview">
				<tr>
					<th>運動型態</th>
					<th>每小時熱量消耗</th>
					<th>運動日期</th>
					<th>運動時數</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="display: none;">${row.sportid}<input type="hidden"
						name="sportid" value="${row.sportid}"></td>
					<td style="display: none;">${row.useraccount}<input
						type="hidden" name="useraccount" value="${row.useraccount}"></td>
					<td>${row.sporting}<input type="hidden" name="sporting"
						value="${row.sporting}"></td>
					<td>${row.calorieexpenditure}<input type="hidden"
						name="calorieexpenditure" value="${row.calorieexpenditure}"></td>
					<td>${row.sportdate}<input type="hidden" name="sportdate"
						value="${row.sportdate}"></td>
					<td>${row.sporthour}<input type="hidden" name="sporthour"
						value="${row.sporthour}"></td>
				</tr>
			</tbody>

			<thead id="sleepview">
				<tr>
					<th>睡眠型態</th>
					<th>睡眠日期</th>
					<th>睡眠時數</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="display: none;">${row.sleepingid}<input
						type="hidden" name="sleepingid" value="${row.sleepingid}"></td>
					<td style="display: none;">${row.useraccount}<input
						type="hidden" name="useraccount" value="${row.useraccount}"></td>
					<td>${row.sleetimeage}<input type="hidden" name="sleetimeage"
						value="${row.sleetimeage}"></td>
					<td>${row.sleepingdate}<input type="hidden"
						name="sleepingdate" value="${row.sleepingdate}"></td>
					<td>${row.sleepinghour}<input type="hidden"
						name="sleepinghour" value="${row.sleepinghour}"></td>
				</tr>
			</tbody>
		</table>

		<div class="insert">
			<input type="submit" id="insert_btn" name="insert" value="新增">
		</div>

		<div class="back">
			<a href="<c:url value="/backstage/pages/MemberControl"/>">回到上頁</a>
		</div>

		<div class="modal_bg">
			<div class="modal">
				<div class="modal_head">新增/修改</div>

				<div class="modal_in">
				
				</div>

				<div class="modal_bottom">
					<input type="button" class="send" value="送出">
				</div>

				<span class="modal_close">X</span>
			</div>
		</div>


		<script>
			let btn = document.querySelector("#btn");
			let sidebar = document.querySelector(".sidebar");

			btn.onclick = function() {
				sidebar.classList.toggle("active");
			}
			log_out.onclick = function() {
				// 登出Script
			}

			let modalBg = document.querySelector('.modal_bg');
			let modalClose = document.querySelector('.modal_close');

			modalClose.onclick = function() {
				modalBg.classList.toggle('bg_active');
			};

			function addlistener() {
				let modalEdit = [].slice.call(document
						.getElementsByClassName("edit"));

				modalEdit.forEach(function(element, index) {
					element.addEventListener("click", function() {
						modalBg.classList.toggle('bg_active');
					});
				});
			}

			let modalInsert = document.querySelector('#insert_btn');

			modalInsert.onclick = function() {
				modalBg.classList.toggle('bg_active');
			};
		</script>

		<script>
			jQuery
					.ajax({
						type : "get",
						url : "/backstage/pages/memberinformation/info"
					})
					.then(
							function(e) {
								$
										.each(
												e,
												function(a, b) {
													console.log(b.useraccount)
													$('#infoview')
															.append(
																	'<tr><td style="display: none;">'
																			+ b.bodyid
																			+ '</td><td style="display: none;">'
																			+ b.useraccount
																			+ '</td><td>'
																			+ b.membername
																			+ '</td><td>'
																			+ b.memberheight
																			+ '</td><td>'
																			+ b.memberweight
																			+ '</td><td><input type="submit" class="edit" name="prodaction"value="編輯"></td></tr>');
												})
												addlistener();
							})
		</script>
		
		<script>
			jQuery
					.ajax({
						type : "get",
						url : "/backstage/pages/memberinformation/diet/"
					})
					.then(
							function(e) {
								$
										.each(
												e,
												function(a, b) {
													console.log(b.useraccount)
													$('#dietview')
															.append(
																	'<tr><td style="display: none;">'
																			+ b.dietid
																			+ '</td><td style="display: none;">'
																			+ b.useraccount
																			+ '</td><td>'
																			+ b.membername
																			+ '</td><td>'
																			+ b.samplename
																			+ '</td><td>'
																			+ b.calories
																			+ '</td><td>'
																			+ b.foodnumber
																			+ '</td><td>'
																			+ b.dietdate
																			+ '</td><td><input type="submit" class="edit" name="prodaction"value="編輯"></td></tr>');
												})
												addlistener();
							})
		</script>
		
		<script>
			jQuery
					.ajax({
						type : "get",
						url : "/backstage/pages/memberinformation/sport"
					})
					.then(
							function(e) {
								$
										.each(
												e,
												function(a, b) {
													console.log(b.useraccount)
													$('#sportview')
															.append(
																	'<tr><td style="display: none;">'
																			+ b.sleepingid
																			+ '</td><td style="display: none;">'
																			+ b.useraccount
																			+ '</td><td>'
																			+ b.sleetimeage
																			+ '</td><td>'
																			+ b.sleepingdate
																			+ '</td><td>'
																			+ b.sleepinghour
																			+ '</td><td><input type="submit" class="edit" name="prodaction"value="編輯"></td></tr>');
												})
												addlistener();
							})
		</script>
		
		<script>
			jQuery
					.ajax({
						type : "get",
						url : "/backstage/pages/memberinformation/sleep"
					})
					.then(
							function(e) {
								$
										.each(
												e,
												function(a, b) {
													console.log(b.useraccount)
													$('#sleepview')
															.append(
																	'<tr><td style="display: none;">'
																			+ b.sportid
																			+ '</td><td style="display: none;">'
																			+ b.useraccount
																			+ '</td><td>'
																			+ b.sporting
																			+ '</td><td>'
																			+ b.calorieexpenditure
																			+ '</td><td>'
																			+ b.sportdate
																			+ '</td><td>'
																			+ b.sporthour
																			+ '</td><td><input type="submit" class="edit" name="prodaction"value="編輯"></td></tr>');
												})
												addlistener();
							})
		</script>

	</div>


</body>
</html>