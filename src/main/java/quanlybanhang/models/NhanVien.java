package quanlybanhang.models;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="nhanvien")
public class NhanVien {
	@Id
	@Column(name="MaNV")
	private long manv;
	@Column(name="HTen")
	private String hoten;
	@Column(name="SoDT")
	private String sdt;
	@Column(name="NgayVL")
	private LocalDate ngayvaolam;
	@Transient
	private String avatarUrl;
	
	public NhanVien() {
		
	}
	
	public NhanVien(String hoten) {
		this.hoten= hoten;
		this.avatarUrl= generateAvatarUrl(hoten);
}

	private String generateAvatarUrl(String hoten) {
		String firstLetter = hoten.substring(0, 1).toUpperCase();
		String randomColor = getRandomHexColor();
		return "https://ui-avatars.com/api/?name=" + firstLetter + 
			       "&background=random&size=150&color= " + randomColor + "&rounded=false";
	}
	
	public String getRandomHexColor() {
		Random rand = new Random();
		int r = rand.nextInt(256);
		int b = rand.nextInt(256);
		int g = rand.nextInt(256);
		return String.format("%02x%02x%02x" , r, b, g);
	}
	
	public long getManv() {
		return manv;
	}

	public void setManv(long manv) {
		this.manv = manv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public LocalDate getNgayvaolam() {
		return ngayvaolam;
	}

	public void setNgayvaolam(LocalDate ngayvaolam) {
		this.ngayvaolam = ngayvaolam;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	
}
