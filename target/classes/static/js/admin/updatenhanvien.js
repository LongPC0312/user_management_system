function updateNhanVien() {
	let manv = document.getElementById("manv").value;
	let hoten = document.getElementById("hoten").value;
	let sdt = document.getElementById("sdt").value;
	let ngayvaolam = document.getElementById("ngayvaolam").value;
	let avatarUrl = document.getElementById("avatarUrl").value;

	if (!hoten) {
		alert("Vui lòng nhập họ tên!");
		return;
	}
	if (!sdt) {
		alert("Vui lòng nhập số điện thoại!");
		return;
	}
	if (!ngayvaolam) {
		alert("Vui lòng nhập ngày vào làm!");
		return;
	}

	fetch("http://localhost:8080/taikhoan/admin/updatenhanvien/" + manv, {
		method: "PUT",
		headers: { "Content-Type": "application/json" },
		body: JSON.stringify({manv: manv,hoten: hoten,sdt: sdt,ngayvaolam: ngayvaolam,avatarUrl: avatarUrl})
	})
	.then(response => {
		if (!response.ok) throw new Error("Http error " + response.status);
		return response.json();
	})
	.then(data => {
		if (data.success) {
			alert("Cập nhật thành công!");
			window.location.href = data.redirectUrl;
		} else {
			alert("Cập nhật thất bại: " + data.message);
		}
	})
	.catch(error => {
		console.log("Lỗi", error);
		alert("Error: " + error.message);
	});
}
