package quanlybanhang.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlybanhang.models.TaiKhoan;
import quanlybanhang.repositories.TaiKhoanRepository;
import quanlybanhang.services.TaiKhoanService;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
	@Autowired TaiKhoanRepository taikhoanrepository;
	@Override
	public Optional<TaiKhoan> kiemTraDangNhap(String tk, String mk) {
		Optional<TaiKhoan> taikhoan = taikhoanrepository.findUsernameByTk(tk);
		if(taikhoan.isPresent() && taikhoan.get().getMk().equals(mk)) {
			return taikhoan;
		}
		return Optional.empty();
	}
	@Override
	public Optional<TaiKhoan> findByUserName(String tk) {
		return taikhoanrepository.findUsernameByTk(tk);
	}
	@Override
	public void save(TaiKhoan taikhoan) {
		taikhoanrepository.save(taikhoan);
		
	}
	@Override
	public List<TaiKhoan> findAll() {
		return taikhoanrepository.findAll();
	}
	@Override
	public Optional<TaiKhoan> findById(long id) {
		
		return taikhoanrepository.findById(id);
	}
	
}
