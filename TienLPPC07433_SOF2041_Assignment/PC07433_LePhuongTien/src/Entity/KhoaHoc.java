
package Entity;

import java.util.Date;

public class KhoaHoc {
    // Khai báo các thuộc tính của lớp KhoaHoc

    private int MaKH;
    private String MaCD;
    private float hocPhi;
    private int thoiLuong;
    private Date ngayKG;
    private String ghiChu;
    private String MaNV;
    private Date ngayTao;

    // Constructor mặc định không tham số.
    public KhoaHoc() {
    }

    // Constructor có tham số để khởi tạo đối tượng KhoaHoc với các giá trị ban đầu.
    public KhoaHoc(int MaKH, String MaCD, float hocPhi, int thoiLuong, Date ngayKG, String ghiChu, String MaNV, Date ngayTao) {
        this.MaKH = MaKH;
        this.MaCD = MaCD;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.ngayKG = ngayKG;
        this.ghiChu = ghiChu;
        this.MaNV = MaNV;
        this.ngayTao = ngayTao;
    }

    // Getter cho thuộc tính MaKH.
    public int getMakh() {
        return MaKH;
    }

    // Setter cho thuộc tính MaKH.
    public void setMakh(int MaKH) {
        this.MaKH = MaKH;
    }

    // Getter cho thuộc tính MaCD.
    public String getMacd() {
        return MaCD;
    }

    // Setter cho thuộc tính MaCD.
    public void setMacd(String MaCD) {
        this.MaCD = MaCD;
    }

    // Getter cho thuộc tính hocPhi.
    public float getHocphi() {
        return hocPhi;
    }

    // Setter cho thuộc tính hocPhi.
    public void setHocphi(float hocPhi) {
        this.hocPhi = hocPhi;
    }

    // Getter cho thuộc tính thoiLuong.
    public int getThoiluong() {
        return thoiLuong;
    }

    // Setter cho thuộc tính thoiLuong.
    public void setThoiluong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    // Getter cho thuộc tính ngayKG (ngày khai giảng).
    public Date getNgaykhaigiang() {
        return ngayKG;
    }

    // Setter cho thuộc tính ngayKG.
    public void setNgaykhaigiang(Date ngayKG) {
        this.ngayKG = ngayKG;
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

    // Getter cho thuộc tính ngayTao (ngày tạo).
    public Date getNgaytao() {
        return ngayTao;
    }

    // Setter cho thuộc tính ngayTao.
    public void setNgaytao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    // Phương thức toString để trả về biểu diễn chuỗi của đối tượng KhoaHoc.
    @Override
    public String toString() {
        return MaCD + " (" + ngayKG + ")";
    }
}

