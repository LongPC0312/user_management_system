package quanlybanhang.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private CustomSuccessHandler successHandler;
    
    @Autowired
    private CustomAuthenticationFailureHandler failerHandler;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    new AntPathRequestMatcher("/taikhoan/dangnhap"),
                    new AntPathRequestMatcher("/taikhoan/dangky"),
                    new AntPathRequestMatcher("/css/**")
                ).permitAll()
                .requestMatchers(
                    new AntPathRequestMatcher("/taikhoan/admin/viewkhachhang")
                ).hasAnyRole("ADMIN", "NHANVIEN")
                .requestMatchers(
                	new AntPathRequestMatcher("/taikhoan/admin/**")
                ).hasRole("ADMIN")    //hasRole("ADMIN")
                .requestMatchers(
                	new AntPathRequestMatcher("/taikhoan/nhanvien/**")
                ).hasRole("NHANVIEN")
                .requestMatchers(
                	new AntPathRequestMatcher("/taikhoan/khachhang/**")
                ).hasRole("KHACHHANG")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
            		 .loginPage("/taikhoan/dangnhap")
                     .loginProcessingUrl("/login")
                     .successHandler(successHandler)  // Dùng custom success handler để phân quyền
                     .failureHandler(failerHandler)
                     .permitAll()
            )
            .logout(logout -> logout
                    .logoutUrl("/logout") // URL logout
                    .logoutSuccessUrl("/taikhoan/dangnhap?logout=true") 
                    .invalidateHttpSession(true) // Hủy session hiện tại
                    .deleteCookies("JSESSIONID") // Sau khi logout thành công, quay lại trang đăng nhập
                    .permitAll() // Cho phép tất cả người dùng logout
             );

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder())
            .and()
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Chỉ dùng để test, không mã hóa mật khẩu
    }
}
