function dangky(){
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	let confirm_password= document.getElementById("confirm-password").value;
	let vaitro = document.getElementById("vaitro").value;
	
	if(username == null){
		alert("Vui lòng nhập tài khoản");
		return; 
	}
	if(password == null){
		alert("Vui lòng nhập mật khẩu");
		return;
	}
	if(confirm_password == null){
		alert("Vui lòng nhập mật khẩu xác nhận");
	}
	if(vaitro == null){
		alert("Vui lòng chọn vai trò");
		return;
	}
	if(password != confirm_password){
		alert("Mật khẩu xác nhận không khớp, vui lòng nhập lại");
		return;
	}
	fetch("http://localhost:8080/taikhoan/dangky",{
		method: "POST",
		headers: {"Content-Type": "application/json"},
		body: JSON.stringify({ tk: username, mk:password, vaitro:vaitro })
	})
	.then(response => {
		if(!response.ok) throw new Error("Có lỗi xảy ra!");
		else{
			return response.json();
		}	
	})
	.then(data =>{
		if(data.success){
			alert("Tạo tài khoản thành công");
			window.location.href= data.redirectUrl;
		}
		else{
			alert("Đã có lỗi xảy ra khi tạo tài khoản!");
		}
	})
	.catch(error =>{
		console.log("Lỗi", error);
		alert("Có lỗi xảy ra, vui lòng thử lại!");
	})
}