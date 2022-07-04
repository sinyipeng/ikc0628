let btn = document.querySelector("#btn");
let sidebar = document.querySelector(".sidebar");

btn.onclick = function() {
	sidebar.classList.toggle("active");
}
log_out.onclick = function() {
	window.location.href = 'http://localhost:8080/en-us/logout';
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
			document.querySelector("#useraccount").value = targetvalues[0];
			document.querySelector("#userpassword").value = targetvalues[1];
			document.querySelector("#membername").value = targetvalues[2];
			document.querySelector("#birthday").value = targetvalues[3];
			document.querySelector("#address").value = targetvalues[4];
			document.querySelector("#cellphone").value = targetvalues[5];
			document.querySelector("#telephone").value = targetvalues[6];
			document.querySelector("#email").value = targetvalues[7];
			document.querySelector("#userlevel").value = targetvalues[8];
			document.querySelector("#area").value = targetvalues[9];
			document.querySelector("#gender").value = targetvalues[10];
			console.log(targetvalues)
			currentIndex = 1;
		});
	});
}

let modalInsert = document.querySelector('#insert_btn');
modalInsert.onclick = function() {
	modalBg.classList.toggle('bg_active');
	document.querySelector("#useraccount").value = "";
	document.querySelector("#userpassword").value = "";
	document.querySelector("#membername").value = "";
	document.querySelector("#birthday").value = "";
	document.querySelector("#address").value = "";
	document.querySelector("#cellphone").value = "";
	document.querySelector("#telephone").value = "";
	document.querySelector("#email").value = "";
	document.querySelector("#userlevel").value = "";
	document.querySelector("#area").value = "";
	document.querySelector("#gender").value = "";
	currentIndex = 0;
};

let send = document.querySelector('.send');
send.onclick = function() {
	let useraccount = $("#useraccount").prop("value");
	let userpassword = $("#userpassword").prop("value");
	let membername = $("#membername").prop("value");
	let birthday = $("#birthday").prop("value");
	let address = $("#address").prop("value");
	let cellphone = $("#cellphone").prop("value");
	let telephone = $("#telephone").prop("value");
	let email = $("#email").prop("value");
	let userlevel = $("#userlevel").prop("value");
	let area = $("#area").prop("value");
	let gender = $("#gender").prop("value");
	let data = {
		"useraccount": useraccount,
		"userpassword": userpassword,
		"membername": membername,
		"birthday": birthday,
		"address": address,
		"cellphone": cellphone,
		"telephone": telephone,
		"email": email,
		"userlevel": userlevel,
		"area": area,
		"gender": gender,
	}
	console.log(data);
	if (currentIndex == 1) {
		$.ajax({
			url: "/backstage/pages/membersupdate",
			data: JSON.stringify(data),
			type: "PUT",
			contentType: "application/json;charset=utf-8",
			success: function(e) {
				alert("成功更改資料")
				window.location.href = 'http://localhost:8080/backstage/pages/MemberControl';
			},
			error: function(xhr, ajaxOptions, thrownError) {
				console.log(xhr.status);
				console.log(thrownError);
				alert("更改失敗")
			}
		})
	} else if (currentIndex == 0) {
		$.ajax({
			url: "/backstage/pages/membersinsert",
			data: JSON.stringify(data),
			type: "POST",
			contentType: "application/json;charset=utf-8",
			success: function(e) {
				alert("成功新增資料")
				window.location.href = 'http://localhost:8080/backstage/pages/MemberControl';
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
		url: "/backstage/pages/members"
	})
	.then(function(e) {
			$.each(e, function(a, b) {
				$('#tableview').append(
					'<tr><td style="display: none;">'
					+ b.useraccount
					+ '</td><td style="display: none;">'
					+ b.userpassword
					+ '</td><td><a href="http://localhost:8080/backstage/pages/MemberInformation">'
					+ b.membername
					+ '</a></td><td>'
					+ b.birthday
					+ '</td><td>'
					+ b.address
					+ '</td><td>'
					+ b.telephone
					+ '</td><td>'
					+ b.cellphone
					+ '</td><td>'
					+ b.email
					+ '</td><td>'
					+ b.userlevel
					+ '</td><td>'
					+ b.area
					+ '</td><td>'
					+ b.gender
					+ '</td><td><input type="submit" class="edit" name="prodaction"value="編輯"></td></tr>');
			})
			addlistener();
		})