

package Entity;

import java.util.Date;


public class NguoiHoc {
    // Khai báo các thuộc tính của lớp NguoiHoc

    private String MaNH;
    private String hoTen;
    private Boolean gioiTinh;
    private String ngaySinh;
    private String email;
    private String dienThoai;
    private String ghiChu;
    private String MaNV;
    private String ngayDangKy;

    // Constructor mặc định không tham số.
    public NguoiHoc() {
    }

    // Constructor có tham số để khởi tạo đối tượng NguoiHoc với các giá trị ban đầu.
    public NguoiHoc(String MaNH, String hoTen, Boolean gioiTinh, String ngaySinh, String email, String dienThoai, String ghiChu, String MaNV, String ngayDangKy) {
        this.MaNH = MaNH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.dienThoai = dienThoai;
        this.ghiChu = ghiChu;
        this.MaNV = MaNV;
        this.ngayDangKy = ngayDangKy;
    }

    // Getter cho thuộc tính MaNH.
    public String getManh() {
        return MaNH;
    }

    // Setter cho thuộc tính MaNH.
    public void setManh(String MaNH) {
        this.MaNH = MaNH;
    }

    // Getter cho thuộc tính hoTen.
    public String getHoten() {
        return hoTen;
    }

    // Setter cho thuộc tính hoTen.
    public void setHoten(String hoTen) {
        this.hoTen = hoTen;
    }

    // Getter cho thuộc tính gioiTinh (giới tính).
    public Boolean getGioitinh() {
        return gioiTinh;
    }

    // Setter cho thuộc tính gioiTinh.
    public void setGioitinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    // Getter cho thuộc tính ngaySinh (ngày sinh).
    public String getNgaysinh() {
        return ngaySinh;
    }

    // Setter cho thuộc tính ngaySinh.
    public void setNgaysinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    // Getter cho thuộc tính email.
    public String getEmail() {
        return email;
    }

    // Setter cho thuộc tính email.
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter cho thuộc tính dienThoai (điện thoại).
    public String getDienthoai() {
        return dienThoai;
    }

    // Setter cho thuộc tính dienThoai.
    public void setDienthoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    // Getter cho thuộc tính ghiChu.
    public String getGhichu() {
        return ghiChu;
    }

    // Setter cho thuộc tính ghiChu.
    public void setGhichu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    // Getter cho thuộc tính MaNV (mã nhân viên).
    public String getManv() {
        return MaNV;
    }

    // Setter cho thuộc tính MaNV.
    public void setManv(String MaNV) {
        this.MaNV = MaNV;
    }

    // Getter cho thuộc tính ngayDangKy (ngày đăng ký).
    public String getNgaydangky() {
        return ngayDangKy;
    }

    // Setter cho thuộc tính ngayDangKy.
    public void setNgaydangky(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    // Phương thức toString để trả về biểu diễn chuỗi của đối tượng NguoiHoc.
    @Override
    public String toString() {
        return "Learner{" + "MaNH=" + MaNH + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", email=" + email + ", dienThoai=" + dienThoai + ", ghiChu=" + ghiChu + ", MaNV=" + MaNV + ", ngayDangKy=" + ngayDangKy + '}';
    }
}

