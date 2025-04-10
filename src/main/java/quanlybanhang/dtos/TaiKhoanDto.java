package quanlybanhang.dtos;

import org.springframework.lang.NonNull;

public class TaiKhoanDto {
	@NonNull
    private String tk;

    @NonNull
    private String mk;

    @NonNull
    private String vaitro;

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
