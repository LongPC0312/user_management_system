package quanlybanhang.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import quanlybanhang.models.TaiKhoan;
import quanlybanhang.repositories.TaiKhoanRepository;

@SpringBootTest
@ActiveProfiles("test")
public class TaiKhoanServiceImplTest {
	    @Autowired private TaiKhoanRepository taikhoanrepository;

	    @Test
	    public void testSaveAndFind() {
	        TaiKhoan tk = new TaiKhoan();
	        tk.setTk("admin");
	        tk.setMk("123456");
	        tk.setVaitro("ROLE_ADMIN");
	        taikhoanrepository.save(tk);

	        Optional<TaiKhoan> found = taikhoanrepository.findByTk("admin");
	        System.out.print("Tài Khoản"+ "tk=" + found.get().getTk()+ ",mk=" + found.get().getMk() + ",vai trò" + found.get().getVaitro());
	        assertTrue(found.isPresent());
	        assertEquals("admin", found.get().getTk());
	   }	
}
