package quanlybanhang.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlybanhang.models.KhachHang;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long>{

	Optional<KhachHang> findByHoten(String hoten);

}
