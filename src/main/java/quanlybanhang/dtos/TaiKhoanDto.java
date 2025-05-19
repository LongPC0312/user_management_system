package quanlybanhang.dtos;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
public class TaiKhoanDto {
	@NotBlank(message = "Tên tài khoản không được để trống")
	@Size(min = 6, max = 18, message = "Tên tài khoản phải từ 6 đến 18 ký tự")
	@Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{6,18}$",
			 message = "Tài khoản phải có ít nhất 1 chữ thường, 1 chữ hoa, 1 số")
    private String tk;

	@NotBlank(message = "Tên tài khoản không được để trống")
	@Size(min = 6, max = 18, message = "Mật khẩu phải từ 6 đến 18 ký tự")
	@Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*+=])[a-zA-Z0-9!@#$%^&*+=]{6,18}$",
	 message = "Mật khẩu phải có ít nhất 1 chữ thường, 1 chữ hoa, 1 số, 1 ký tự đặc biệt")
    private String mk;

	@NotBlank(message = "Tên tài khoản không được để trống")
    private String vaitro;
      
}
