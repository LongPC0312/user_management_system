package quanlybanhang.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlybanhang.models.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long>{

	Optional<NhanVien> findByHoten(String hoten);
	Optional<NhanVien> findById(long manv);
	
	
}
