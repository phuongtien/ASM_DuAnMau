package DAO;

import Entity.KhoaHoc;
import java.util.List;
import JDBCHelper.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhoaHocDAO extends EduSysDAO<KhoaHoc, String> {
    // Lớp KhoaHocDAO kế thừa từ EduSysDAO và sử dụng kiểu KhoaHoc cho đối tượng và String cho khóa chính.

    String insert = "INSERT INTO KHOAHOC(MACD,HOCPHI,THOILUONG,NGAYKG,GHICHU,MANV,NGAYTAO) VALUES(?,?,?,?,?,?,?)";
    String update = "UPDATE KHOAHOC SET MACD = ? , HOCPHI = ? , THOILUONG = ?, NGAYKG = ?, GHICHU = ?, MANV = ? ,NGAYTAO = ? WHERE MAKH = ?";
    String delete = "DELETE FROM KHOAHOC WHERE MAKH = ?";
    String selectAll = "SELECT * FROM KHOAHOC";
    String selectbyId = "SELECT * FROM KHOAHOC WHERE MAKH = ?";

    // Các biến này chứa các câu truy vấn SQL.

    @Override
    public void insert(KhoaHoc entity) {
        // Thực hiện truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng KHOAHOC.
        JDBCHelper.update(insert, entity.getMacd(), entity.getHocphi(), entity.getThoiluong(), entity.getNgaykhaigiang(), entity.getGhichu(),
                 entity.getManv(), entity.getNgaytao());
    }

    @Override
    public void update(KhoaHoc entity) {
        // Thực hiện truy vấn UPDATE để cập nhật thông tin của đối tượng 'entity' trong bảng KHOAHOC.
        JDBCHelper.update(update, entity.getMacd(), entity.getHocphi(), entity.getThoiluong(), entity.getNgaykhaigiang(), entity.getGhichu(),
                entity.getManv(), entity.getNgaytao(), entity.getMakh());
    }

    @Override
    public void delete(String id) {
        // Thực hiện truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng KHOAHOC.
        JDBCHelper.update(delete, id);
    }

    @Override
    public KhoaHoc selectbyId(String id) {
        // Thực hiện truy vấn SELECT để lấy một đối tượng KhoaHoc dựa trên khóa chính 'id'.
        List<KhoaHoc> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        // Thực hiện truy vấn SELECT để lấy danh sách tất cả các đối tượng KhoaHoc từ bảng KHOAHOC.
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<KhoaHoc> selectbySql(String sql, Object... args) {
        // Thực hiện truy vấn SQL chung và trả về danh sách các đối tượng KhoaHoc.
        List<KhoaHoc> list = new ArrayList<KhoaHoc>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                KhoaHoc kh = new KhoaHoc();
                kh.setMakh(rs.getInt("MAKH"));
                kh.setMacd(rs.getString("MACD"));
                kh.setHocphi(rs.getFloat("HOCPHI"));
                kh.setThoiluong(rs.getInt("THOILUONG"));
                kh.setNgaykhaigiang(rs.getDate("NGAYKG"));
                kh.setGhichu(rs.getString("GHICHU"));
                kh.setManv(rs.getString("MANV"));
                kh.setNgaytao(rs.getDate("NGAYTAO"));
                list.add(kh);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhoaHoc> selectbyChuyende(String macd) {
        // Thực hiện truy vấn SELECT để lấy danh sách các đối tượng KhoaHoc dựa trên Mã chuyên đề 'macd'.
        String sql = "SELECT * FROM KHOAHOC WHERE MACD = ?";
        return this.selectbySql(sql, macd);
    }
    
    public List<Integer> selectYear() {
        // Thực hiện truy vấn SELECT để lấy danh sách các năm (được sắp xếp theo thứ tự giảm dần) trong cột NGAYKG của bảng KHOAHOC.
        String sql = "SELECT DISTINCT YEAR(NGAYKG) AS YEAR FROM KHOAHOC ORDER BY YEAR DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

