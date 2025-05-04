package quanlybanhang.models;

import java.time.LocalDate;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="khachhang")
public class KhachHang {
	@Id
	@Column(name="MaKH")
	private long makh;
	
	@Column(name="HTen")
	private String hoten;
	
	@Column(name="DChi")
	private String diachi;
	
	@Column(name="SoDT")
	private String sdt;
	
	@Column(name="NgayS")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngaysinh;
	
	@Column(name="NgayDK")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngaydangky;
	
	@Column(name="DSo")
	private long doanhso;
	
	@Transient
	private String avatarUrl;
	
	public KhachHang() {
		
	}
	
	public KhachHang(String hoten) {
		this.hoten= hoten;
		this.avatarUrl= genaratedAvatarUrl(hoten);
	}
	
	public String genaratedAvatarUrl(String hoten) {
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
		return String.format("%02x%02x%02x", r, b, g);
	}

	public long getMakh() {
		return makh;
	}

	public void setMakh(long makh) {
		this.makh = makh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public LocalDate getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(LocalDate ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public LocalDate getNgaydangky() {
		return ngaydangky;
	}

	public void setNgaydangky(LocalDate ngaydangky) {
		this.ngaydangky = ngaydangky;
	}

	public long getDoanhso() {
		return doanhso;
	}

	public void setDoanhso(long doanhso) {
		this.doanhso = doanhso;
	}

	public String getAvatarUrl() {
		if(avatarUrl == null || avatarUrl.isEmpty()) {
			this.avatarUrl= genaratedAvatarUrl(this.hoten);
		}
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
}
