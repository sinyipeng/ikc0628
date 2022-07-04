let btn = document.querySelector("#btn");
let sidebar = document.querySelector(".sidebar");

btn.onclick = function() {
	sidebar.classList.toggle("active");
}
log_out.onclick = function() {
	window.location.href = 'http://localhost:8080/';
}

let modalBg = document.querySelector('.modal_bg');
let modalClose = document.querySelector('.modal_close');
modalClose.onclick = function() {
	modalBg.classList.toggle('bg_active');
};

var currentIndex = -1;
function addlistener() {
	let modalEdit = [].slice.call(document.getElementsByClassName("edit"));

	modalEdit.forEach(function(element, index) {
		element.addEventListener("click", function() {
			modalBg.classList.toggle('bg_active');
			let gettarget = $(event.target).parent().parent().find('td');
			let targetvalues = [];
			$.each(gettarget, function(a, b) { targetvalues.push(b.innerText); })
			document.querySelector("#orderid").value = targetvalues[0];
			document.querySelector("#useraccount").value = targetvalues[1];
			document.querySelector("#ordertime").value = targetvalues[2];
			document.querySelector("#orderendtime").value = targetvalues[3];
			document.querySelector("#orderadress").value = targetvalues[4];
			document.querySelector("#orderarea").value = targetvalues[5];
			document.querySelector("#orderstatus").value = targetvalues[6];
			document.querySelector("#payment").value = targetvalues[7];
			document.querySelector("#delivery").value = targetvalues[8];
			console.log(targetvalues)
			currentIndex = 1;
		});
	});
}

let modalInsert = document.querySelector('#insert_btn');
modalInsert.onclick = function() {
	modalBg.classList.toggle('bg_active');
	document.querySelector("#orderid").value = "";
	document.querySelector("#useraccount").value = "";
	document.querySelector("#ordertime").value = "";
	document.querySelector("#orderendtime").value = "";
	document.querySelector("#orderadress").value = "";
	document.querySelector("#orderarea").value = "";
	document.querySelector("#orderstatus").value = "";
	document.querySelector("#payment").value = "";
	document.querySelector("#delivery").value = "";
	currentIndex = 0;
};

let send = document.querySelector('.send');
send.onclick = function() {
	let orderid = $("#orderid").prop("value");
	let useraccount = $("#useraccount").prop("value");
	let ordertime = $("#ordertime").prop("value");
	let orderendtime = $("#orderendtime").prop("value");
	let orderadress = $("#orderadress").prop("value");
	let orderarea = $("#orderarea").prop("value");
	let orderstatus = $("#orderstatus").prop("value");
	let payment = $("#payment").prop("value");
	let delivery = $("#delivery").prop("value");
	let data = {
		"orderid": orderid,
		"useraccount": useraccount,
		"ordertime": ordertime,
		"orderendtime": orderendtime,
		"orderadress": orderadress,
		"orderarea": orderarea,
		"orderstatus": orderstatus,
		"payment": payment,
		"delivery": delivery,
	}
	console.log(data);
	if (currentIndex == 1) {
		$.ajax({
			url: "/backstage/pages/ordersupdate",
			data: JSON.stringify(data),
			type: "PUT",
			contentType: "application/json;charset=utf-8",
			success: function(e) {
				alert("成功更改資料")
				window.location.href = 'http://localhost:8080/backstage/pages/OrdersDisplay';
			},
			error: function(xhr, ajaxOptions, thrownError) {
				console.log(xhr.status);
				console.log(thrownError);
				alert("更改失敗")
			}
		})
	} else if (currentIndex == 0) {
		$.ajax({
			url: "/backstage/pages/ordersinsert",
			data: JSON.stringify(data),
			type: "POST",
			contentType: "application/json;charset=utf-8",
			success: function(e) {
				alert("成功新增資料")
				window.location.href = 'http://localhost:8080/backstage/pages/OrdersDisplay';
			},
			error: function(xhr, ajaxOptions, thrownError) {
				console.log(xhr.status);
				console.log(thrownError);
				alert("新增失敗")
			}
		})
	}
};

jQuery
	.ajax({
		type: "get",
		url: "/backstage/pages/orders"
	})
	.then(
		function(e) {
			$.each(e, function(a, b) {
				$('#tableview').append(
					'<tr>'
					+ '</td><td>'
					+ b.orderid
					+ '</td><td>'
					+ b.useraccount
					+ '</td><td>'
					+ b.ordertime.split('T')[0] + " " + b.ordertime.split('T')[1].split('.')[0]
					+ '</td><td>'
					+ b.orderendtime
					+ '</td><td>'
					+ b.orderadress
					+ '</td><td>'
					+ b.orderarea
					+ '</td><td>'
					+ b.orderstatus
					+ '</td><td>'
					+ b.payment
					+ '</td><td>'
					+ b.delivery
					+ '</td><td><input type="submit" class="edit" name="prodaction"value="編輯"></td></tr>');
			})
			addlistener();
		})