

package Entity;

public class NhanVien {
    // Khai báo các thuộc tính của lớp NhanVien

    private String MaNV;       // Mã nhân viên
    private String matKhau;    // Mật khẩu
    private String hoTen;      // Họ tên
    private Boolean vaiTro;    // Vai trò (quyền hạn)

    // Constructor mặc định không tham số.
    public NhanVien() {
    }

    // Constructor có tham số để khởi tạo đối tượng NhanVien với các giá trị ban đầu.
    public NhanVien(String MaNV, String matKhau, String hoTen, Boolean vaiTro) {
        this.MaNV = MaNV;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.vaiTro = vaiTro;
    }

    // Getter cho thuộc tính MaNV (mã nhân viên).
    public String getManv() {
        return MaNV;
    }

    // Setter cho thuộc tính MaNV.
    public void setManv(String MaNV) {
        this.MaNV = MaNV;
    }

    // Getter cho thuộc tính matKhau (mật khẩu).
    public String getMatkhau() {
        return matKhau;
    }

    // Setter cho thuộc tính matKhau.
    public void setMatkhau(String matKhau) {
        this.matKhau = matKhau;
    }

    // Getter cho thuộc tính hoTen (họ tên).
    public String getHoten() {
        return hoTen;
    }

    // Setter cho thuộc tính hoTen.
    public void setHoten(String hoTen) {
        this.hoTen = hoTen;
    }

    // Getter cho thuộc tính vaiTro (vai trò).
    public Boolean getVaitro() {
        return vaiTro;
    }

    // Setter cho thuộc tính vaiTro.
    public void setVaitro(Boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    // Phương thức toString để trả về biểu diễn chuỗi của đối tượng NhanVien.
    @Override
    public String toString() {
        return "Staff{" + "MaNV=" + MaNV + ", matKhau=" + matKhau + ", hoTen=" + hoTen + ", vaiTro=" + vaiTro + '}';
    }
}

