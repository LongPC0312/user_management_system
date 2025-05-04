package quanlybanhang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            String role = authentication.getAuthorities().iterator().next().getAuthority();

            String redirectUrl = switch (role) {
                case "ROLE_ADMIN" -> "/taikhoan/admin";
                case "ROLE_NHANVIEN" -> "/taikhoan/nhanvien";
                case "ROLE_KHACHHANG" -> "/taikhoan/khachhang";
                default -> "/";
            };

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("redirectUrl", redirectUrl);

            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", "Sai tài khoản hoặc mật khẩu");
            return ResponseEntity.status(401).body(error);
        }
    }
}
