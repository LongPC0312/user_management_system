package quanlybanhang.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import quanlybanhang.models.TaiKhoan;

@Service
public interface TaiKhoanService {
	public Optional<TaiKhoan> kiemTraDangNhap(String tk, String mk);
	public Optional<TaiKhoan> findByUserName(String tk);
	public void save(TaiKhoan taikhoan);
	
}
