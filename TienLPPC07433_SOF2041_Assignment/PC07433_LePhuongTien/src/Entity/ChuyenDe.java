

package Entity;

public class ChuyenDe {
    private String MaCD;
    private String TenCD;
    private float hocPhi;
    private int thoiLuong;
    private String hinh;
    private String moTa;

    // Constructor mặc định không tham số.
    public ChuyenDe() {
    }

    // Constructor có tham số để khởi tạo đối tượng ChuyenDe với các giá trị ban đầu.
    public ChuyenDe(String MaCD, String TenCD, float hocPhi, int thoiLuong, String hinh, String moTa) {
        this.MaCD = MaCD;
        this.TenCD = TenCD;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.hinh = hinh;
        this.moTa = moTa;
    }

    // Getter và Setter cho thuộc tính MaCD.
    public String getMacd() {
        return MaCD;
    }

    public void setMacd(String MaCD) {
        this.MaCD = MaCD;
    }

    // Getter và Setter cho thuộc tính TenCD.
    public String getTencd() {
        return TenCD;
    }

    public void setTencd(String TenCD) {
        this.TenCD = TenCD;
    }

    // Getter và Setter cho thuộc tính hocPhi.
    public float getHocphi() {
        return hocPhi;
    }

    public void setHocphi(float hocPhi) {
        this.hocPhi = hocPhi;
    }

    // Getter và Setter cho thuộc tính thoiLuong.
    public int getThoiluong() {
        return thoiLuong;
    }

    public void setThoiluong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    // Getter và Setter cho thuộc tính hinh.
    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    // Getter và Setter cho thuộc tính moTa.
    public String getMota() {
        return moTa;
    }

    public void setMota(String moTa) {
        this.moTa = moTa;
    }

    // Phương thức toString để trả về biểu diễn chuỗi của đối tượng ChuyenDe.
    @Override
    public String toString() {
        return TenCD;
    }

    // Phương thức equals để so sánh hai đối tượng ChuyenDe dựa trên MaCD.
    @Override
    public boolean equals(Object obj) {
        ChuyenDe other = (ChuyenDe) obj;
        return other.getMacd().equals(this.getMacd());
    }
}

