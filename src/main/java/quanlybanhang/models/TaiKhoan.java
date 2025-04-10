package quanlybanhang.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tttk")
public class TaiKhoan {
	@Id
	@Column(name="ID")
	private long id;
	@Column(name="TK")
	private String tk;
	@Column(name="MK")
	private String mk;
	@Column(name="VTro")
	private String vaitro;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTk() {
		return tk;
	}
	public void setTk(String tk) {
		this.tk = tk;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	public String getVaitro() {
		return vaitro;
	}
	public void setVaitro(String vaitro) {
		this.vaitro = vaitro;
	}
	
	
}
