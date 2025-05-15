package quanlybanhang.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import quanlybanhang.models.TaiKhoan;
import quanlybanhang.repositories.TaiKhoanRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired TaiKhoanRepository taikhoanrepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoan taikhoan = taikhoanrepository.findUsernameByTk(username)
				.orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản" + username));
		return new CustomUserDetails(taikhoan);
	}

}
