function deleteKhachHang(makh, buttonElement){
	if(!confirm("Bạn có chắc muốn xóa khách hàng này không")){
		return;
	}
	fetch("http://localhost:8080/taikhoan/admin/deletekhachhang/" + makh, {
        method: "DELETE"
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Lỗi khi xóa khách hàng: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
		if(data.success){
			alert("Xóa khách hàng thành công!");
        	const itemElement = buttonElement.closest(".grid-item");
        	if (itemElement) {
            itemElement.remove();
        	}
        }
        else{
			alert("Xóa khách hàng thất bại");
		}
    })
    .catch(error => {
        console.error("Lỗi:", error);
        alert("Xảy ra lỗi khi xóa khách hàng!");
    });
}