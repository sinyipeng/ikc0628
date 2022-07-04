<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link rel="stylesheet" type="text/css" href="/css/backstageProduct.css" />

<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>

<title>商品管理</title>
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
		<div class="class text">
			<a href="<c:url value="/backstage/Index" />">IK Care 後台管理系統</a>
		</div>
	</div>
	<div class="main">

		<table>
			<thead id="tableview">
				<tr>
					<th>商品ID</th>
					<th>商品名稱</th>
					<th>供應商ID</th>
					<th>商品圖片</th>
					<th>定價</th>
					<th>庫存數</th>
					<th>商品描述</th>
					<th>商品狀態</th>
					<th>編輯</th>
				</tr>
			</thead>
		</table>

		<div class="modal_bg">
			<div class="modal">
				<div class="modal_head">新增/修改</div>

				<div class="modal_in">
					<label for="productid">商品ID</label>
					<input type="text" class="getvalue" name="productid" id="productid">
					<label for="productname">商品名稱</label> 
					<input type="text" class="getvalue" name="productname" id="productname">
					<label for="suppliesid">供應商ID</label> 
					<input type="text" class="getvalue" name="suppliesid" id="suppliesid">
					<label for="productimg">商品圖片</label> 
					<input type="text" class="getvalue" name="productimg" id="productimg">
					<label for="standardcost">定價</label> 
					<input type="text" class="getvalue" name="standardcost" id="standardcost">
					<label for="productstock">庫存數</label> 
					<input type="text" class="getvalue" name="productstock" id="productstock">
					<label for="productdescribe">商品描述</label> 
					<input type="text" class="getvalue" name="productdescribe" id="productdescribe"> 
					<label for="productstatus">商品狀態</label>
					<input type="text" class="getvalue" name="productstatus" list="statusdata" id="productstatus">
					<datalist id="statusdata">
						<option value="上架">上架</option>
						<option value="下架">下架</option>
					</datalist>
				</div>

				<div class="modal_bottom">
					<input type="button" class="send" value="送出">
				</div>

				<span class="modal_close">X</span>
			</div>
		</div>
	</div>

	<div class="insert">
		<input type="submit" id="insert_btn" name="insert" value="新增">
	</div>

	<script src="/js/backstageProduct.js"></script>
</body>
</html>