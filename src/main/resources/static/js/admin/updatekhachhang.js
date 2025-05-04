function updateKhachHang(){
	let makh = document.getElementById("makh").value;
	let hoten = document.getElementById("hoten").value;
	let diachi = document.getElementById("diachi").value;
	let sdt = document.getElementById("sdt").value;
	let ngaysinh = document.getElementById("ngaysinh").value;
	let ngaydangky = document.getElementById("ngaydangky").value;
	let doanhso = document.getElementById("doanhso").value;
	let avatarUrl = document.getElementById("avatarUrl").value;
	
	if(hoten == null){
		alert("Vui lòng nhập họ tên");
		return;
	}
	if(diachi == null){
		alert("Vui lòng nhập địa chỉ");
		return;
	}
	if(sdt == null){
		alert("Vui lòng nhập sđt");
		return;
	}
	if(ngaysinh == null){
		alert("Vui lòng nhập ngày sinh");
		return;
	}
	if(ngaydangky == null){
		alert("Vui lòng nhập ngày đăng ký");
		return;
	}
	if(doanhso == null){
		alert("Vui lòng nhập doanh số");
		return;
	}
	fetch("http://localhost:8080/taikhoan/admin/updatekhachhang/" + makh,{
		method: "PUT",
		headers:{"Content-Type":"application/json"},
		body:JSON.stringify({makh: makh, hoten: hoten, diachi: diachi, sdt: sdt, ngaysinh: ngaysinh, ngaydangky: ngaydangky, doanhso: doanhso, avatarUrl: avatarUrl})
	})
	.then(response =>{
		if(!response.ok) throw new Error ("Http error", response.status);
		return response.json();
	})
	.then(data =>{
		if(data.success){
			alert("Cập nhật nhân viên thành công");
			window.location.href = data.redirectUrl;
		}
		else{
			alert("Cập nhật thất bại");			
		}
	})
	.catch(error => {
		console.log("Lỗi", error);
		alert("Error: " + error.message);
	});
}