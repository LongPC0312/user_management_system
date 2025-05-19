function dangky(){
	let username = document.getElementById("username").value.trim();
	let password = document.getElementById("password").value.trim();
	let confirm_password= document.getElementById("confirm-password").value.trim();
	let vaitro = document.getElementById("vaitro").value.trim();
	
	if(!username){
		alert("Vui lòng nhập tài khoản");
		return; 
	}
	if(!password){
		alert("Vui lòng nhập mật khẩu");
		return;
	}
	if(!confirm_password){
		alert("Vui lòng nhập mật khẩu xác nhận");
		return;
	}
	if(!vaitro){
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
			alert(data.message);
			window.location.href= data.redirectUrl;
		}
		else{
			alert(data.message);
		}
	})
	.catch(error =>{
		console.log("Lỗi", error);
		alert("Lỗi kết tới server hoặc Lỗi mạng!");
	})
}