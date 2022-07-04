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
			document.querySelector("#suppliesid").value = targetvalues[0];
			document.querySelector("#suppliesname").value = targetvalues[1];
			document.querySelector("#contactperson").value = targetvalues[2];
			document.querySelector("#position").value = targetvalues[3];
			document.querySelector("#suppliesphone").value = targetvalues[4];
			document.querySelector("#fax").value = targetvalues[5];
			document.querySelector("#suppliesadress").value = targetvalues[6];
			document.querySelector("#suppliesarea").value = targetvalues[7];
			console.log(targetvalues)
			currentIndex = 1;
		});
	});
}

let modalInsert = document.querySelector('#insert_btn');
modalInsert.onclick = function() {
	modalBg.classList.toggle('bg_active');
	document.querySelector("#suppliesid").value = "";
	document.querySelector("#suppliesname").value = "";
	document.querySelector("#contactperson").value = "";
	document.querySelector("#position").value = "";
	document.querySelector("#suppliesphone").value = "";
	document.querySelector("#fax").value = "";
	document.querySelector("#suppliesadress").value = "";
	document.querySelector("#suppliesarea").value = "";
	currentIndex = 0;
	
};

let send = document.querySelector('.send');
send.onclick = function() {
	let suppliesid = $("#suppliesid").prop("value");
	let suppliesname = $("#suppliesname").prop("value");
	let contactperson = $("#contactperson").prop("value");
	let position = $("#position").prop("value");
	let suppliesphone = $("#suppliesphone").prop("value");
	let fax = $("#fax").prop("value");
	let suppliesadress = $("#suppliesadress").prop("value");
	let suppliesarea = $("#suppliesarea").prop("value");
	let data = {
		"suppliesid": suppliesid,
		"suppliesname": suppliesname,
		"contactperson": contactperson,
		"position": position,
		"suppliesphone": suppliesphone,
		"fax": fax,
		"suppliesadress": suppliesadress,
		"suppliesarea": suppliesarea,
	}
	console.log(data);
	console.log(currentIndex);
	if (currentIndex == 1) {
		console.log("我跑PUT");
		$.ajax({
			url: "/backstage/pages/suppliesupdate",
			data: JSON.stringify(data),
			type: "PUT",
			contentType: "application/json;charset=utf-8",
			success: function(e) {
				alert("成功更改資料")
				window.location.href = 'http://localhost:8080/backstage/pages/SuppliesDisplay'
			},
			error: function(xhr, ajaxOptions, thrownError) {
				console.log(xhr.status);
				console.log(thrownError);
				alert("更改失敗")
			}
		})
	} else if(currentIndex == 0){
		$.ajax({
			url: "/backstage/pages/suppliesinsert",
			data: JSON.stringify(data),
			type: "POST",
			contentType: "application/json;charset=utf-8",
			success: function(e) {
				alert("成功新增資料")
				window.location.href = 'http://localhost:8080/backstage/pages/SuppliesDisplay'
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
		url: "/backstage/pages/supplies"
	})
	.then(function(e) {
		$.each(e, function(a, b) {
			$('#tableview').append(
				'<tr>'
				+ '</td><td>'
				+ b.suppliesid
				+ '</td><td>'
				+ b.suppliesname
				+ '</td><td>'
				+ b.contactperson
				+ '</td><td>'
				+ b.position
				+ '</td><td>'
				+ b.suppliesphone
				+ '</td><td>'
				+ b.fax
				+ '</td><td>'
				+ b.suppliesadress
				+ '</td><td>'
				+ b.suppliesarea
				+ '</td><td><input type="submit" class="edit" name="prodaction"value="編輯"></td></tr>');
		})
		addlistener();
	})