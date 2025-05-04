package quanlybanhang.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.models.KhachHang;
import quanlybanhang.repositories.KhachHangRepository;
import quanlybanhang.services.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService{
	@Autowired KhachHangRepository khachhangrepository;
	@Override
	public Optional<KhachHang> findByHoten(String hoten) {
		
		return khachhangrepository.findByHoten(hoten);
	}
	@Override
	public List<KhachHang> findAll() {
		
		return khachhangrepository.findAll();
	}
	@Override
	public void save(KhachHang khachhang) {
		khachhangrepository.save(khachhang);
		
	}
	@Override
	public boolean deleteByMakh(long makh) {
		Optional<KhachHang> khachhang = khachhangrepository.findById(makh);
		if(khachhang.isPresent()) {
			khachhangrepository.delete(khachhang.get());
			return true;
		}
		return false;
	}
	@Override
	public Optional<KhachHang> findByMakh(long makh) {
		
		return khachhangrepository.findById(makh);
	}

}
