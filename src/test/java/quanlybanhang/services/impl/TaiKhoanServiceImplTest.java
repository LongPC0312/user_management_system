package quanlybanhang.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import quanlybanhang.repositories.TaiKhoanRepository;

@ExtendWith(MockitoExtension.class)
public class TaiKhoanServiceImplTest {
	 	@Mock
	    private TaiKhoanRepository taiKhoanRepository;

	    @InjectMocks
	    private TaiKhoanServiceImpl taiKhoanService;

	    @Test
	    public void testFindById() {
}
