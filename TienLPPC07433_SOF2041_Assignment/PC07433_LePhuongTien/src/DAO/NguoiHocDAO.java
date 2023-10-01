
package DAO;

import Entity.NguoiHoc;
import java.util.List;
import JDBCHelper.JDBCHelper;
import Utils.Auth;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String> {
    // Lớp NguoiHocDAO kế thừa từ EduSysDAO và sử dụng kiểu NguoiHoc cho đối tượng và String cho khóa chính.

    String insert = "INSERT INTO NGUOIHOC(MANH,HOTEN,GIOITINH,NGAYSINH,EMAIL,DIENTHOAI,GHICHU,MANV) VALUES(?,?,?,?,?,?,?,?)";
    String update = "UPDATE NGUOIHOC SET HOTEN = ?,GIOITINH=?,NGAYSINH=?,EMAIL=?,DIENTHOAI=?,GHICHU=? WHERE MANH = ? ";
    String delete = "DELETE FROM NGUOIHOC WHERE MANH = ? ";
    String selectAll = "SELECT * FROM NGUOIHOC";
    String selectbyId = "SELECT * FROM NGUOIHOC WHERE MANH = ?";    
    
    // Các biến này chứa các câu truy vấn SQL.

    @Override
    public void insert(NguoiHoc entity) {
        // Thực hiện truy vấn INSERT để chèn dữ liệu của đối tượng 'entity' vào bảng NGUOIHOC.
        JDBCHelper.update(insert,entity.getManh(),entity.getHoten(),entity.getGioitinh(),entity.getNgaysinh(),entity.getEmail(),entity.getDienthoai(),
               entity.getGhichu(),Auth.user.getManv());
    }

    @Override
    public void update(NguoiHoc entity) {
        // Thực hiện truy vấn UPDATE để cập nhật thông tin của đối tượng 'entity' trong bảng NGUOIHOC.
        JDBCHelper.update(update, entity.getHoten(),entity.getGioitinh(),entity.getNgaysinh(),entity.getEmail(),entity.getDienthoai(),entity.getGhichu(),
        entity.getManh());    
    }

    @Override
    public void delete(String id) {
        // Thực hiện truy vấn DELETE để xóa đối tượng có khóa chính 'id' khỏi bảng NGUOIHOC.
        JDBCHelper.update(delete, id);
    }

    @Override
    public NguoiHoc selectbyId(String id) {
        // Thực hiện truy vấn SELECT để lấy một đối tượng NguoiHoc dựa trên khóa chính 'id'.
        List<NguoiHoc> list = this.selectbySql(selectbyId, id);
        if(list.isEmpty()){
            return null;
        } 
        return list.get(0);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        // Thực hiện truy vấn SELECT để lấy danh sách tất cả các đối tượng NguoiHoc từ bảng NGUOIHOC.
        return this.selectbySql(selectAll);
    }

    @Override
    protected List<NguoiHoc> selectbySql(String sql, Object... args) {
        // Thực hiện truy vấn SQL chung và trả về danh sách các đối tượng NguoiHoc.
        List<NguoiHoc> list = new ArrayList<NguoiHoc>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while(rs.next()) {
                NguoiHoc ln = new NguoiHoc();
                ln.setDienthoai(rs.getString("DIENTHOAI"));
                ln.setEmail(rs.getString("EMAIL"));
                ln.setGhichu(rs.getString("GHICHU"));
                ln.setGioitinh(rs.getBoolean("GIOITINH"));
                ln.setHoten(rs.getString("HOTEN"));
                ln.setManh(rs.getString("MANH"));
                ln.setManv(rs.getString("MANV"));
                ln.setNgaydangky(rs.getDate("NGAYDK").toString());
                ln.setNgaysinh(rs.getDate("NGAYSINH").toString());
                list.add(ln);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<NguoiHoc> selectbyKeyword(String keyword) {
        // Thực hiện truy vấn SELECT để lấy danh sách các đối tượng NguoiHoc dựa trên từ khóa 'keyword' trong tên.
        String sql = "SELECT * FROM NGUOIHOC WHERE HOTEN LIKE ?";
        return this.selectbySql(sql,"%"+keyword+"%");
    }
    
    public List<NguoiHoc> selectNotinCourse(int makh, String keyword) {
        // Thực hiện truy vấn SELECT để lấy danh sách các đối tượng NguoiHoc dựa trên từ khóa 'keyword' trong tên và không nằm trong khoá học có mã 'makh'.
        String sql = "SELECT * FROM NGUOIHOC WHERE HOTEN LIKE ? AND MANH NOT IN "
                + "(SELECT MANH FROM HOCVIEN WHERE MAKH = ?)";
        return this.selectbySql(sql,"%"+keyword+"%",makh);
    }    
}
