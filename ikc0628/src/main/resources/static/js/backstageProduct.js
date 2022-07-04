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
			let getimage = $(event.target).parent().parent().find('td').find('img');
			let targetvalues = [];
			$.each(gettarget, function(a, b) { targetvalues.push(b.innerText); })
			document.querySelector("#productid").value = targetvalues[0];
			document.querySelector("#productname").value = targetvalues[1];
			document.querySelector("#suppliesid").value = targetvalues[2];
			document.querySelector("#productimg").value = getimage.attr('src');
			document.querySelector("#standardcost").value = targetvalues[4];
			document.querySelector("#productstock").value = targetvalues[5];
			document.querySelector("#productdescribe").value = targetvalues[6];
			document.querySelector("#productstatus").value = targetvalues[7];
			console.log(targetvalues)
			currentIndex = 1;
		});
	});
}

let modalInsert = document.querySelector('#insert_btn');
modalInsert.onclick = function() {
	modalBg.classList.toggle('bg_active');
	document.querySelector("#productid").value = "";
	document.querySelector("#productname").value = "";
	document.querySelector("#suppliesid").value = "";
	document.querySelector("#productimg").value = "";
	document.querySelector("#standardcost").value = "";
	document.querySelector("#productstock").value = "";
	document.querySelector("#productdescribe").value = "";
	document.querySelector("#productstatus").value = "";
	currentIndex = 0;
};

let send = document.querySelector('.send');
send.onclick = function() {
	let productid = $("#productid").prop("value");
	let productname = $("#productname").prop("value");
	let suppliesid = $("#suppliesid").prop("value");
	let productimg = $("#productimg").prop("value");
	let standardcost = $("#standardcost").prop("value");
	let productstock = $("#productstock").prop("value");
	let productdescribe = $("#productdescribe").prop("value");
	let productstatus = $("#productstatus").prop("value");
	let data = {
		"productid": productid,
		"productname": productname,
		"suppliesid": suppliesid,
		"productimg": productimg,
		"standardcost": standardcost,
		"productstock": productstock,
		"productdescribe": productdescribe,
		"productstatus": productstatus,
	}
	console.log(data);
	if (currentIndex == 1) {
		$.ajax({
			url: "/backstage/pages/productupdate",
			data: JSON.stringify(data),
			type: "PUT",
			contentType: "application/json;charset=utf-8",
			success: function(e) {
				alert("成功更改資料")
				window.location.href = 'http://localhost:8080/backstage/pages/Product';
			},
			error: function(xhr, ajaxOptions, thrownError) {
				console.log(xhr.status);
				console.log(thrownError);
				alert("更改失敗")
			}
		})
	} else if (currentIndex == 0) {
		$.ajax({
			url: "/backstage/pages/productinsert",
			data: JSON.stringify(data),
			type: "POST",
			contentType: "application/json;charset=utf-8",
			success: function(e) {
				alert("成功新增資料")
				window.location.href = 'http://localhost:8080/backstage/pages/Product';
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
		url: "/backstage/pages/product"
	})
	.then(function(e) {
		$.each(e, function(a, b) {
			$('#tableview')
				.append(
					'<tr>'
					+ '</td><td>'
					+ b.productid
					+ '</td><td>'
					+ b.productname
					+ '</td><td>'
					+ b.suppliesid
					+ '</td><td><img src="'
					+ b.productimg
					+ '"></td><td>'
					+ b.standardcost
					+ '</td><td>'
					+ b.productstock
					+ '</td><td style="width: 900px;">'
					+ b.productdescribe
					+ '</td><td>'
					+ b.productstatus
					+ '</td><td style="width: 100px;"><input type="submit" class="edit" name="prodaction"value="編輯"></td></tr>');
		})
		addlistener();
	});