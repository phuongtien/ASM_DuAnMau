

package Entity;

public class HocVien {
    // Khai báo các thuộc tính của lớp HocVien

    private int MaHV;
    private int MaKH;
    private String MaNH;
    private float diem;

    // Constructor mặc định không tham số.
    public HocVien() {
    }

    // Constructor có tham số để khởi tạo đối tượng HocVien với các giá trị ban đầu.
    public HocVien(int MaHV, int MaKH, String MaNH, float diem) {
        this.MaHV = MaHV;
        this.MaKH = MaKH;
        this.MaNH = MaNH;
        this.diem = diem;
    }

    // Getter cho thuộc tính MaHV.
    public int getMahv() {
        return MaHV;
    }

    // Setter cho thuộc tính MaHV.
    public void setMahv(int MaHV) {
        this.MaHV = MaHV;
    }

    // Getter cho thuộc tính MaKH.
    public int getMakh() {
        return MaKH;
    }

    // Setter cho thuộc tính MaKH.
    public void setMakh(int MaKH) {
        this.MaKH = MaKH;
    }

    // Getter cho thuộc tính MaNH.
    public String getManh() {
        return MaNH;
    }

    // Setter cho thuộc tính MaNH.
    public void setManh(String MaNH) {
        this.MaNH = MaNH;
    }

    // Getter cho thuộc tính diem.
    public float getDiem() {
        return diem;
    }

    // Setter cho thuộc tính diem.
    public void setDiem(float diem) {
        this.diem = diem;
    }

    // Phương thức toString để trả về biểu diễn chuỗi của đối tượng HocVien.
    @Override
    public String toString() {
        return "Students{" + "MaHV=" + MaHV + ", MaKH=" + MaKH + ", MaNH=" + MaNH + ", diem=" + diem + '}';
    }
}

