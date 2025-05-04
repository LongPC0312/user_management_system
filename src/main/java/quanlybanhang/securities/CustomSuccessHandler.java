package quanlybanhang.securities;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority auth : authorities) {
            String role = auth.getAuthority();

            if (role.equals("ROLE_ADMIN")) {
                response.sendRedirect("/taikhoan/admin");
                return;
            } else if (role.equals("ROLE_NHANVIEN")) {
                response.sendRedirect("/taikhoan/nhanvien");
                return;
            } else if (role.equals("ROLE_KHACHHANG")) {
                response.sendRedirect("/taikhoan/khachhang");
                return;
            }
        }

        response.sendRedirect("/default");
    }
}
