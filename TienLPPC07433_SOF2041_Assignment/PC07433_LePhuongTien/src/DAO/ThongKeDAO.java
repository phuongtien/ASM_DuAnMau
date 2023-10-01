
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import JDBCHelper.JDBCHelper;

public class ThongKeDAO {
    // Class ThongKeDAO không kế thừa từ EduSysDAO, nó là một class độc lập để thực hiện các truy vấn thống kê.

    public List<Object[]> getListofArray(String sql,String[] cols, Object... args) {
        // Phương thức này thực hiện truy vấn SQL chung và trả về một danh sách các mảng đối tượng (Object[]) dựa trên các cột được chỉ định (cols).
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JDBCHelper.query(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Object[]> getBangDiem(Integer MAKH) {
        // Phương thức này thực hiện truy vấn lấy bảng điểm của các học viên trong một khóa học cụ thể (MAKH).
        // Nó sử dụng một stored procedure (sp_Bangdiem) để lấy dữ liệu và trả về một danh sách các mảng đối tượng (Object[]).
        String sql = "{CALL sp_Bangdiem(?)}";
        String[] cols = {"MANH","HOTEN","DIEM"};
        return this.getListofArray(sql, cols, MAKH);
    }
    
    public List<Object[]> getLuongNguoiHoc(){
        // Phương thức này thực hiện truy vấn để thống kê lượng người học theo năm.
        // Nó sử dụng một stored procedure (sp_Thongkenguoihoc) để lấy dữ liệu và trả về một danh sách các mảng đối tượng (Object[]).
        String sql = "{CALL sp_Thongkenguoihoc}";
        String[] cols = {"NAM","SOLUONG","DAUTIEN","CUOICUNG"};
        return this.getListofArray(sql, cols);
    }
    
    public List<Object[]> getDiemChuyenDe(){
        // Phương thức này thực hiện truy vấn để thống kê điểm của các chuyên đề.
        // Nó sử dụng một stored procedure (sp_Thongkediem) để lấy dữ liệu và trả về một danh sách các mảng đối tượng (Object[]).
        String sql = "{CALL sp_Thongkediem}";
        String[] cols = {"TENCHUYENDE","SOHV","DIEMTN","DIEMCN","DIEMTB"};
        return this.getListofArray(sql, cols);
    }    
    
    public List<Object[]> getDoanhThu(int NAM){
        // Phương thức này thực hiện truy vấn để thống kê doanh thu theo năm.
        // Nó sử dụng một stored procedure (sp_Thongkedoanhthu) để lấy dữ liệu và trả về một danh sách các mảng đối tượng (Object[]).
        String sql = "{CALL sp_Thongkedoanhthu(?)}";
        String[] cols = {"TENCHUYENDE","SOKH","SOHV","DOANHTHU","DTHUTN","DTHUCN","HPHITB"};
        return this.getListofArray(sql, cols, NAM);
    }
}
