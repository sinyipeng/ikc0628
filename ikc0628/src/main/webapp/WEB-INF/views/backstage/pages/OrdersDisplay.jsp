<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link>
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>

<link rel="stylesheet" type="text/css" href="/css/backstageOrder.css" />

<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>

<title>訂單管理</title>
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
					<th>訂單ID</th>
					<th>訂單帳號</th>
					<th>開單日期</th>
					<th>結單日期</th>
					<th>訂單地址</th>
					<th>訂單地區</th>
					<th>訂單狀態</th>
					<th>結帳方式</th>
					<th>送貨方式</th>
					<th>編輯</th>
				</tr>
			</thead>
		</table>

		<div class="modal_bg">
			<div class="modal">
				<div class="modal_head">新增/修改</div>

				<div class="modal_in">
					<label for="orderid">訂單ID</label> 
					<input type="text" class="getvalue" name="orderid" id="orderid"> 
					<label for="useraccount">訂單帳號</label> 
					<input type="text" class="getvalue" name="useraccount" id="useraccount"> 
					<label for="ordertime">開單日期</label> 
					<input type="text" class="getvalue" name="ordertime" id="ordertime"> 
					<label for="orderendtime">結單日期</label>
					<input type="text" class="getvalue" name="orderendtime" id="orderendtime"> 
					<label for="orderadress">訂單地址</label> 
					<input type="text" class="getvalue" name="orderadress" id="orderadress">
					<label for="orderstatus">訂單狀態</label> 
					<input type="text" class="getvalue" name="orderstatus" list="orderstatusdata" id="orderstatus"> 
					<datalist id="orderstatusdata">
						<option value="下單完成">下單完成</option>
						<option value="訂單未成立">訂單未成立</option>
					</datalist>
					<label for="payment">結帳方式</label> 
					<input type="text" class="getvalue" name="payment" list="paymentdata" id="payment">
					<datalist id="paymentdata">
						<option value="信用卡結帳">信用卡結帳</option>
						<option value="超商貨到付款">超商貨到付款</option>
					</datalist>
					<label for="orderarea">訂單地區</label>
					<input type="text" class="getvalue" name="orderarea" list="areadata" id="orderarea">
					<datalist id="areadata">
						<option value="臺北市">臺北市</option>
						<option value="新北市">新北市</option>
						<option value="基隆市">基隆市</option>
						<option value="桃園市">桃園市</option>
						<option value="新竹縣">新竹縣</option>
						<option value="苗栗縣">苗栗縣</option>
						<option value="臺中市">臺中市</option>
						<option value="彰化縣">彰化縣</option>
						<option value="南投縣">南投縣</option>
						<option value="雲林縣">雲林縣</option>
						<option value="嘉義縣">嘉義縣</option>
						<option value="臺南市">臺南市</option>
						<option value="高雄市">高雄市</option>
						<option value="屏東縣">屏東縣</option>
						<option value="宜蘭縣">宜蘭縣</option>
						<option value="花蓮縣">花蓮縣</option>
						<option value="臺東縣">臺東縣</option>
						<option value="澎湖縣">澎湖縣</option>
						<option value="澎湖縣">澎湖縣</option>
						<option value="金門縣">金門縣</option>
						<option value="連江縣">連江縣</option>
					</datalist>
					<label for="delivery">送貨方式</label> <input type="text"
						class="getvalue" name="delivery" list="deliverydata" id="delivery">
					<datalist id="deliverydata">
						<option value="宅配">宅配</option>
						<option value="超商取貨">超商取貨</option>
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

	<script src="/js/backstageOrder.js"></script>
</body>
</html>