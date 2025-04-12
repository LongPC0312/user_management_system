function addNhanVien(){
	let hoten = document.getElementById("hoten").value;
	let sdt = document.getElementById("sdt").value;
	let ngayvaolam = document.getElementById("ngayvaolam").value;
	
	if(hoten == null){
		alert("Vui lòng nhập họ tên");
		return;
	}
	if(sdt == null){
		alert("Vui lòng nhập sđt");
		return;
	}
	if(ngayvaolam == null){
		alert("Vui lòng nhập ngày vào làm");
		return;
	}
	fetch("http://localhost:8080/taikhoan/admin/addnhanvien",{
		method: "POST",
		headers: {"Content-Type" : "application/json"},
		body: JSON.stringify({hoten: hoten, sdt: sdt, ngayvaolam: ngayvaolam})
	})
	.then(response => {
		if(!response.ok) throw new Error("Http error:" + response.status);
		return response.json()
	})
	.then(data =>{
		if(data.success){
			alert("Thêm nhân viên thành công");
			window.location.href = data.redirectUrl;
			return;
		}
		alert("Thất bại" + data.message);
	})
	.catch(error =>{
		console.log("lỗi", error);
		alert("Error" + error.message);
	})
	
}