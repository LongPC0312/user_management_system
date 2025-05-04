async function login(){
	let username = document.getElementById("username").value;
	let password =document.getElementById("password").value;
	if(!username){
		alert("Vui lòng nhập tài khoản");
		return;
	}
	if(!password){
		alert("Vui lòng nhập mật khẩu");
		return;
	}
	fetch("http://localhost:8080/api/login",{
		method: "POST",
		headers: {"Content-Type":"application/json"},
		body: JSON.stringify({username:username, password:password})
	})
	.then(response => {
		if(!response.ok) throw new Error("Có lỗi xảy ra");
		else{
			return response.json();
		}	
		})
		
	 
	.then(data =>{
		console.log("DEBUG:", data);
		if(data.success){
			alert("Đăng nhập thành công");
			console.log("Redirect URL:", data.redirectUrl); // Debug
        	window.location.href =  data.redirectUrl ;

		}
		else{
			alert("Sai tài khoản hoặc mật khẩu");
		}
	})
	.catch(error =>{
		console.error("Lỗi: ", error);
		alert("Có lỗi xảy ra, vui lòng thử lại!");
	})
	
}