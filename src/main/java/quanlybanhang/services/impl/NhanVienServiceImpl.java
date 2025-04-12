package quanlybanhang.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.models.NhanVien;
import quanlybanhang.repositories.NhanVienRepository;
import quanlybanhang.services.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService{
	@Autowired NhanVienRepository nhanvienrepository;
	
	@Override
	public Optional<NhanVien> findByMaNV(long manv) {
		
		return nhanvienrepository.findById(manv);
	}

	@Override
	public Optional<NhanVien> findByHoten(String hoten) {
		// TODO Auto-generated method stub
		return nhanvienrepository.findByHoten(hoten);
	}
	
	@Override
	public List<NhanVien> findAllNhanVien() {
		
		return nhanvienrepository.findAll();
	}

	@Override
	public void save(NhanVien nhanvien) {
		nhanvienrepository.save(nhanvien);
		
	}
}
