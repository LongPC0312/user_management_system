package quanlybanhang.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import quanlybanhang.dtos.TaiKhoanDto;
import quanlybanhang.models.TaiKhoan;
import quanlybanhang.services.TaiKhoanService;

@Controller
@RequestMapping("/taikhoan")
public class TaiKhoanController {
	@Autowired TaiKhoanService taikhoanservice;
	@GetMapping("/dangnhap")
	public String dangnhap(
			@RequestParam(value="error", required = false) String error, 
			@RequestParam(value="logout", required = false) String logout, 
			@RequestParam(value="status", required = false) String status, 
					Model model) {
        if (error != null) {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Bạn đã đăng xuất thành công!");
        }
        if(status !=null) {
        	model.addAttribute("status", "Tài khoản của bạn đã bị khóa!");
        }
		return "taikhoan/dangnhap";
	}
	
	@GetMapping("/dangky")
		public String dangky(Model model) {
		model.addAttribute("taikhoan", new TaiKhoan());
		return "taikhoan/dangky";
	}
	
	@PostMapping("/dangky")
	@ResponseBody
	public Map<String, Object> dangky(@Valid  @RequestBody TaiKhoanDto dto, BindingResult bindingResult) {
		Map<String, Object> response = new HashMap<>();
		if (bindingResult.hasErrors()) {
	        response.put("success", false);
	        response.put("message", bindingResult.getFieldError().getDefaultMessage());
	        return response;
	    }
		try {
			Optional<TaiKhoan> existingTaiKhoan = taikhoanservice.findByUserName(dto.getTk());
			if(existingTaiKhoan.isPresent()) {
				response.put("success", false);
				response.put("message", "tài khoản đã tồn tại");
				return response;
			}
			
			else{
			TaiKhoan newtaikhoan = new TaiKhoan();
			newtaikhoan.setTk(dto.getTk());
			newtaikhoan.setMk(dto.getMk());
			newtaikhoan.setVaitro(dto.getVaitro());
			taikhoanservice.save(newtaikhoan);
			response.put("success", true);
			response.put("message", "Tạo tài khoản thành công");
			response.put("redirectUrl", "/taikhoan/dangnhap");
			return response;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			response.put("success", false);
			response.put("message", "Có sự cố xảy ra ở server");
			return response;	
		}
		
		
	}
}
	