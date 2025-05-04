package quanlybanhang.securities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import quanlybanhang.models.TaiKhoan;

public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
    private final TaiKhoan taiKhoan;

    public CustomUserDetails(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + taiKhoan.getVaitro()));
    }

    @Override
    public String getPassword() {
        return taiKhoan.getMk();
    }

    @Override
    public String getUsername() {
        return taiKhoan.getTk();
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}

