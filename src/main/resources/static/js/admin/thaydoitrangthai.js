function thayDoiTrangThai(id) {
    fetch("/taikhoan/admin/thaydoitrangthai/" + id, {
        method: "PUT",
    })
    .then(response => {
    if (!response.ok) {
        return response.json().then(err => {
            throw new Error(err.message || "Lỗi không xác định từ server");
        });
    }
    else{
		alert("Thay đổi trạng thái thành công");
		location.reload();
		return response.json();
		} // <--- cần đảm bảo backend thật sự trả JSON
	})
	
    
    .catch(error => {
        console.error("Lỗi:", error);
        alert("Lỗi kết nối máy chủ!");
    });
}
