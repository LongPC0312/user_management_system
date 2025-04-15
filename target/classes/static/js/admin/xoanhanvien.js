function deleteNhanVien(manv, buttonElement) {
    if (!confirm("Bạn có chắc chắn muốn xóa nhân viên này không?")) {
        return;
    }

    fetch(`http://localhost:8080/taikhoan/admin/deletenhanvien/${manv}`, {
        method: "DELETE"
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Lỗi khi xóa nhân viên: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
		if(data.success){
			alert("Xóa nhân viên thành công!");
        	const itemElement = buttonElement.closest(".grid-item");
        	if (itemElement) {
            itemElement.remove();
        	}
        }
        else{
			alert("Xóa nhân viên thất bại");
		}
    })
    .catch(error => {
        console.error("Lỗi:", error);
        alert("Xảy ra lỗi khi xóa nhân viên!");
    });
}
