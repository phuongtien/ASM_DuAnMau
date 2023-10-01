
package DAO;
import Entity.NhanVien;
import java.util.List;
import JDBCHelper.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
public class NhanVienDAO extends EduSysDAO<NhanVien, String> {
    // Lớp NhanVienDAO kế thừa từ EduSysDAO và sử dụng kiểu NhanVien cho đối tượng và String cho khóa chính.

    String insert = "INSERT INTO NHANVIEN(MANV,MATKHAU,HOTEN,VAITRO) VALUES(?,?,?,?)";
    String update = "UPDATE NHANVIEN SET MATKHAU = ? , HOTEN = ? , VAITRO = ? WHERE MANV = ?";
    String delete = "DELETE FROM NHANVIEN WHERE MANV = ?";
    String selectAll = "SELECT * FROM NHANVIEN";
    String selectbyId = "SELECT * FROM NHANVIEN WHERE MANV = ?";
    
    // Các biến này chứa các câu truy vấn SQL.

    @Override
    public void insert(NhanVien entity) {
        // Thực hiện truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng NHANVIEN.
        JDBCHelper.update(insert, entity.getManv(),entity.getMatkhau(),entity.getHoten(),entity.getVaitro() );
    }

    @Override
    public void update(NhanVien entity) {
        // Thực hiện truy vấn UPDATE để cập nhật thông tin của đối tượng 'entity' trong bảng NHANVIEN.
        JDBCHelper.update(update,entity.getMatkhau(),entity.getHoten(),entity.getVaitro(),entity.getManv() );
    }

    @Override
    public void delete(String id) {
        // Thực hiện truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng NHANVIEN.
        JDBCHelper.update(delete, id);
    }

    @Override
    public NhanVien selectbyId(String id) {
        // Thực hiện truy vấn SELECT để lấy một đối tượng NhanVien dựa trên khóa chính 'id'.
        List<NhanVien> list = this.selectbySql(selectbyId, id);
        if(list.isEmpty()){
            return null;
        } 
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        // Thực hiện truy vấn SELECT để lấy danh sách tất cả các đối tượng NhanVien từ bảng NHANVIEN.
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<NhanVien> selectbySql(String sql, Object... args) {
        // Thực hiện truy vấn SQL chung và trả về danh sách các đối tượng NhanVien.
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while(rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setManv(rs.getString("MANV"));
                nv.setHoten(rs.getString("HOTEN"));
                nv.setMatkhau(rs.getString("MATKHAU"));
                nv.setVaitro(rs.getBoolean("VAITRO"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
