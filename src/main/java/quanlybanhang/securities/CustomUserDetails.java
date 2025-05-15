package quanlybanhang.securities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import quanlybanhang.models.TaiKhoan;

public class CustomUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private final TaiKhoan taikhoan ;
	
	public CustomUserDetails(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + taikhoan.getVaitro()));
	}

	@Override
	public String getPassword() {		
		return taikhoan.getMk();
	}

	@Override
	public String getUsername() {
		return taikhoan.getTk();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}

	@Override
	public boolean isEnabled() {
		return taikhoan.isTrangthai();
	}

}
