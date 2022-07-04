<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>I K care | 線上營養師</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link>
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>

<link rel="stylesheet" type="text/css" href="/css/backstageIndex.css" />

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
		<div class="functionsup">
			<div class="funcmembers">
				<p>會員清單</p>
			</div>
			<div class="funcproducts">
				<p>商品管理</p>
			</div>
		</div>
		<div class="functionsdown">
			<div class="funcsupplies">
				<p>廠商清單</p>
			</div>
			<div class="funcorders">
				<p>訂單管理</p>
			</div>
		</div>
	</div>

	<script src="/js/backstageIndex.js"></script>
</body>

</html>