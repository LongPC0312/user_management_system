package quanlybanhang.services;

import java.util.List;
import java.util.Optional;

import quanlybanhang.models.KhachHang;

public interface KhachHangService {
	public Optional<KhachHang> findByMakh(long makh);
	
	public Optional<KhachHang> findByHoten(String hoten);

	public List<KhachHang> findAll();
	
	public void save(KhachHang khachhang);
	
	public boolean deleteByMakh(long makh);
}
