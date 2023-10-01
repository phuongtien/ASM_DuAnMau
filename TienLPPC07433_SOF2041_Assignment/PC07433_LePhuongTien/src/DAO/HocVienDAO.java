package DAO;

import Entity.HocVien;
import java.util.List;
import JDBCHelper.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HocVienDAO extends EduSysDAO<HocVien, String> {
    // Lớp HocVienDAO kế thừa từ EduSysDAO và sử dụng kiểu HocVien cho đối tượng và String cho khóa chính.

    String insert = "INSERT INTO HOCVIEN(MAKH, MANH, DIEM) VALUES(?,?,?)";
    String update = "UPDATE HOCVIEN SET DIEM = ? WHERE MAHV = ?";
    String delete = "DELETE FROM HOCVIEN WHERE MAHV = ?";
    String selectAll = "SELECT * FROM HOCVIEN";
    String selectbyId = "SELECT * FROM HOCVIEN WHERE MAHV = ?";

    // Các biến này chứa các câu truy vấn SQL.

    @Override
    public void insert(HocVien entity) {
        // Thực hiện truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng HOCVIEN.
        JDBCHelper.update(insert, entity.getMakh(), entity.getManh(), entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        // Thực hiện truy vấn UPDATE để cập nhật thông tin của đối tượng 'entity' trong bảng HOCVIEN.
        JDBCHelper.update(update, entity.getDiem(), entity.getMahv());
    }

    @Override
    public void delete(String id) {
        // Thực hiện truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng HOCVIEN.
        JDBCHelper.update(delete, id);
    }

    @Override
    public HocVien selectbyId(String id) {
        // Thực hiện truy vấn SELECT để lấy một đối tượng HocVien dựa trên khóa chính 'id'.
        List<HocVien> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HocVien> selectAll() {
        // Thực hiện truy vấn SELECT để lấy danh sách tất cả các đối tượng HocVien từ bảng HOCVIEN.
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<HocVien> selectbySql(String sql, Object... args) {
        // Thực hiện truy vấn SQL chung và trả về danh sách các đối tượng HocVien.
        List<HocVien> list = new ArrayList<HocVien>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                HocVien hv = new HocVien();
                hv.setMahv(rs.getInt("MAHV"));
                hv.setMakh(rs.getInt("MAKH"));
                hv.setManh(rs.getString("MANH"));
                hv.setDiem(rs.getFloat("DIEM"));
                list.add(hv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<HocVien> selectByKhoahoc(int makh) {
        // Thực hiện truy vấn SELECT để lấy danh sách các đối tượng HocVien dựa trên Mã khoá học 'makh'.
        String sql = "SELECT * FROM HOCVIEN WHERE MAKH = ?";
        return this.selectbySql(sql, makh);
    }
}

