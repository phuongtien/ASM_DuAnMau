package DAO;

import Entity.ChuyenDe;
import java.util.List;
import JDBCHelper.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChuyenDeDAO extends EduSysDAO<ChuyenDe, String> {
    // Các câu truy vấn SQL được lưu trong các biến dưới đây

    String insert = "INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES(?,?,?,?,?,?)";
    String update = "UPDATE CHUYENDE SET TENCD = ? , HOCPHI = ? , THOILUONG = ?, HINH = ?, MOTA = ? WHERE MACD = ?";
    String delete = "DELETE FROM CHUYENDE WHERE MACD = ?";
    String selectAll = "SELECT *FROM CHUYENDE";
    String selectbyId = "SELECT *FROM CHUYENDE WHERE MACD = ?";

    @Override
    public void insert(ChuyenDe entity) {
        // Thực hiện câu truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng CHUYENDE
        JDBCHelper.update(insert, entity.getMacd(), entity.getTencd(), entity.getHocphi(), entity.getThoiluong(), entity.getHinh(), entity.getMota());
    }

    @Override
    public void update(ChuyenDe entity) {
        // Thực hiện câu truy vấn UPDATE để cập nhật thông tin của đối tượng 'entity' trong bảng CHUYENDE
        JDBCHelper.update(update, entity.getTencd(), entity.getHocphi(), entity.getThoiluong(), entity.getHinh(), entity.getMota(), entity.getMacd());
    }

    @Override
    public void delete(String id) {
        // Thực hiện câu truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng CHUYENDE
        JDBCHelper.update(delete, id);
    }

    @Override
    public ChuyenDe selectbyId(String id) {
        // Thực hiện câu truy vấn SELECT để lấy một đối tượng CHUYENDE dựa trên khóa chính 'id'
        List<ChuyenDe> list = this.selectbySql(selectbyId, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        // Thực hiện câu truy vấn SELECT để lấy danh sách tất cả các đối tượng CHUYENDE từ bảng CHUYENDE
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<ChuyenDe> selectbySql(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<ChuyenDe>();
        try {
            // Thực hiện truy vấn SQL sử dụng câu truy vấn 'sql' và các đối số 'args'

            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng ChuyenDe từ kết quả truy vấn

                ChuyenDe cd = new ChuyenDe();
                cd.setMacd(rs.getString("MACD"));
                cd.setTencd(rs.getString("TENCD"));
                cd.setThoiluong(rs.getInt("THOILUONG"));
                cd.setHocphi(rs.getFloat("HOCPHI"));
                cd.setHinh(rs.getString("HINH"));
                cd.setMota(rs.getString("MOTA"));
                list.add(cd);
            }
            // Đóng kết nối và trả về danh sách các đối tượng ChuyenDe

            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
        // Xử lý ngoại lệ nếu có lỗi xảy ra

            throw new RuntimeException(e);
        }
    }

}
