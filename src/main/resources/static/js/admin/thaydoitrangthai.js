function thayDoiTrangThai(id) {
    fetch("http://localhost:8080/taikhoan/admin/thaydoitrangthai/" + id, {
        method: "PUT",
    })
    .then(response => response.json())  // ← Phân tích JSON từ response
    .then(data => {
        if (data.status === "false") {
            throw new Error(data.message || "Lỗi không xác định từ server");
        } else {
            alert(data.message || "Thay đổi trạng thái thành công");
            location.reload();
        }
    })
    .catch(error => {
        console.error("Lỗi:", error.message);
        alert(error.message || "Lỗi kết nối máy chủ!");
    });
}
