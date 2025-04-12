package quanlybanhang.controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import quanlybanhang.models.NhanVien;
import quanlybanhang.services.NhanVienService;

@Controller
@RequestMapping("/taikhoan")
public class AdminController {
	@Autowired NhanVienService nhanvienservice;
	@GetMapping("/admin")
	public String admin() {
		return "admin/admin";
	}
	
	@GetMapping("/admin/viewnhanvien")
	public String hienThiDanhSachNhanVien(Model model) {
	    model.addAttribute("listNhanVien", nhanvienservice.findAllNhanVien());
	    return "admin/viewnhanvien"; 
	    }
	
	@GetMapping("/admin/addnhanvien")
	public String addNhanVien(Model model) {
		model.addAttribute("nhanVien", new NhanVien());		
		return "admin/addnhanvien";
	}
	
	@PostMapping("/admin/addnhanvien")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> themNhanVien(@RequestBody NhanVien nhanvien) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        nhanvienservice.save(nhanvien);
	        response.put("success", true);
	        response.put("redirectUrl", "/taikhoan/admin/viewnhanvien"); 
	        return ResponseEntity.ok(response); // ✅ Bọc response vào ResponseEntity
	    } catch (Exception e) {
	        response.put("success", false);
	        response.put("Lỗi", "Đã xảy ra lỗi");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // ✅ Bọc vào ResponseEntity với mã lỗi
	    }
	}
}
