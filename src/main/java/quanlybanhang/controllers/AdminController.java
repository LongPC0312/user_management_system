package quanlybanhang.controllers;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import quanlybanhang.models.KhachHang;
import quanlybanhang.models.NhanVien;
import quanlybanhang.services.KhachHangService;
import quanlybanhang.services.NhanVienService;

@Controller
@RequestMapping("/taikhoan")
public class AdminController {
	// Nhanvien 
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
	public String addNhanVien() {
		return "admin/addnhanvien";
	}
	
	@GetMapping("/admin/updatenhanvien/{manv}")
	public String capNhatNhanVien(@PathVariable("manv") Long manv, Model model) {
	    Optional<NhanVien> optionalNhanVien = nhanvienservice.findByMaNV(manv);
	    
	    if (optionalNhanVien.isPresent()) {
	        model.addAttribute("nhanvien", optionalNhanVien.get());  // 
	    } else {
	        
	        model.addAttribute("error", "Nhân viên không tồn tại");
	    }
	    
	    return "admin/updatenhanvien";
	}

	
	@PostMapping("/admin/addnhanvien")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> themNhanVien(@RequestBody NhanVien nhanvien) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        nhanvienservice.save(nhanvien);
	        response.put("success", true);
	        response.put("redirectUrl", "/taikhoan/admin/viewnhanvien"); 
	        return ResponseEntity.ok(response); 
	    } catch (Exception e) {
	        response.put("success", false);
	        response.put("Lỗi", "Đã xảy ra lỗi");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); 
	    }
	}
	
	@PutMapping("/admin/updatenhanvien/{manv}")
	@ResponseBody
	public Map<String, Object> updateNhanVien(@PathVariable("manv") Long manv,@RequestBody NhanVien nhanVien) {

	    Map<String, Object> response = new HashMap<>();
	    try {  
	        nhanVien.setManv(manv);      
	        nhanvienservice.save(nhanVien);
	        response.put("success", true);
	        response.put("redirectUrl", "/taikhoan/admin/viewnhanvien");
	    } catch (Exception e) {
	        response.put("success", false);
	        response.put("message", e.getMessage());
	    }

	    return response;
	}

	
	@DeleteMapping("/admin/deletenhanvien/{manv}")
	public ResponseEntity<Map<String, Object>> deleteNhanVien(@PathVariable long manv) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        boolean deleted = nhanvienservice.deleteByManv(manv);
	        
	        if (deleted) {
	            response.put("success", true);
	            response.put("message", "Xóa nhân viên thành công");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("success", false);
	            response.put("message", "Không tìm thấy nhân viên");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } catch (Exception e) {
	        response.put("success", false);
	        response.put("message", "Lỗi server: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
	
	// ---------------------------------------------------------------------------------------------
	// KhachHang
	@Autowired KhachHangService khachhangservice;
	@GetMapping("/admin/viewkhachhang")
	public String viewKhachHang(Model model) {
		model.addAttribute("listKhachHang", khachhangservice.findAll());
		return "admin/viewkhachhang";
	}
	
	@GetMapping("/admin/addkhachhang")
	public String addKhachHang() {
		return "admin/addkhachhang";
	}
	
	@GetMapping("/admin/updatekhachhang/{makh}")
	public String updateKhachHang(@PathVariable("makh") long makh, Model model) {
		Optional<KhachHang> khachhang = khachhangservice.findByMakh(makh);
		if(khachhang.isPresent()){
			model.addAttribute("khachhang", khachhang.get());	
		}
		else {
			model.addAttribute("error", "Nhân viên không tồn tại");
		}
		return "admin/updatekhachhang";
	}
	
	@PostMapping("/admin/addkhachhang")
	@ResponseBody
	public Map<String, Object> themKhachHang(@RequestBody KhachHang khachhang){
		Map<String, Object> response = new HashMap<>();
		try {
			khachhangservice.save(khachhang);
			response.put("success", true);
			response.put("redirectUrl", "/taikhoan/admin/viewkhachhang");
		}
		catch(Exception e){
			response.put("success", false);
			response.put("message", e.getMessage());
		}
		return response;
	}
	
	@PutMapping("/admin/updatekhachhang/{makh}")
	@ResponseBody
	public Map<String, Object> capNhapKhachHang(@PathVariable("makh") long makh, @RequestBody KhachHang khachhang){
		Map<String, Object> response = new HashMap<>();
		try {
			khachhang.setMakh(makh);
			khachhangservice.save(khachhang);
			response.put("success", true);
			response.put("redirectUrl", "/taikhoan/admin/viewkhachhang");
			}
		catch(Exception e){
			response.put("success", false);
			response.put("message", e.getMessage());
		}
		return response;
	}
	
	@DeleteMapping("/admin/deletekhachhang/{makh}")
	@ResponseBody
	public Map<String, Object> deleteKhachHang(@PathVariable long makh ){
		Map<String, Object> response = new HashMap<>();
		boolean delete = khachhangservice.deleteByMakh(makh);
		try {
		if(delete) {
			response.put("success", true);
			response.put("message", "Xóa khách hàng thành công");
		}
		else {
			response.put("success", false);
			response.put("message", "Có lỗi khi xóa khách hàng");
		}
		return response;
		}
		catch (Exception e) {
	        e.printStackTrace(); // In lỗi ra console để dễ debug
	        return response;
	    }
	}
}
