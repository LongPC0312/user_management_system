package quanlybanhang.services;

import java.util.List;
import java.util.Optional;


import quanlybanhang.models.NhanVien;


public interface NhanVienService {
	public List<NhanVien> findAllNhanVien();
	public Optional<NhanVien> findByMaNV(long manv);
	public Optional<NhanVien> findByHoten(String hoten );
	public void save(NhanVien nhanvien);
	public boolean deleteByManv(long manv);
}
