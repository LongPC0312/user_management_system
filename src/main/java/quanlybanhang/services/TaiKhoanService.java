package quanlybanhang.services;

import java.util.List;
import java.util.Optional;



import quanlybanhang.models.TaiKhoan;


public interface TaiKhoanService {
	public Optional<TaiKhoan> kiemTraDangNhap(String tk, String mk);
	public Optional<TaiKhoan> findByUserName(String tk);
	public void save(TaiKhoan taikhoan);
	public List<TaiKhoan> findAll();
	public Optional<TaiKhoan> findById(long id);
}
