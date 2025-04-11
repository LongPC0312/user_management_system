package quanlybanhang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taikhoan")
public class NhanVienController {
	@GetMapping("/nhanvien")
	public String nhanvien() {
		return "nhanvien/nhanvien";
	}
}
