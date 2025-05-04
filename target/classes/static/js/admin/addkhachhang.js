function addKhachHang(){
	let hoten = document.getElementById("hoten").value;
	let diachi = document.getElementById("diachi").value;
	let sdt = document.getElementById("sdt").value;
	let ngaysinh = document.getElementById("ngaysinh").value;
	let ngaydangky = document.getElementById("ngaydangky").value;
	let doanhso = document.getElementById("doanhso").value;
	
	if(hoten == null){
		alert("Vui lòng không bỏ trống họ tên");
		return;
	}
	if(diachi == null){
		alert("Vui lòng không bỏ trống họ tên");
		return;
	}
	if(sdt == null){
		alert("Vui lòng không bỏ trống họ tên");
		return;
	}
	if(ngaysinh == null){
		alert("Vui lòng không bỏ trống họ tên");
		return;
	}
	if(ngaydangky == null){
		alert("Vui lòng không bỏ trống họ tên");
		return;
	}
	if(doanhso == null){
		alert("Vui lòng không bỏ trống họ tên");
		return;
	}
	fetch("http://localhost:8080/taikhoan/admin/addkhachhang",{
		method: "POST",
		headers: {"Content-Type": "application/json"},
		body: JSON.stringify({hoten: hoten, diachi: diachi, sdt: sdt, ngaysinh: ngaysinh, ngaydangky: ngaydangky, doanhso: doanhso})
	})
	.then(response =>{
		if(!response.ok) throw new Error("Http error", response.status);
		return response.json();
	})
	.then(data =>{
		if(data.success){
			alert("Thêm khách hàng thành công");
			window.location.href= data.redirectUrl;
			return;
		}
		return alert("Xảy ra lỗi khi thêm khách hàng");
	})
	.catch(error =>{
		console.log("Có lỗi khi thêm khách hàng");
		alert("Có lỗi khi thêm khách hàng", error);
	})
}