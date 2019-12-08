package bai2;

import java.sql.SQLException;
import java.util.ArrayList;

public interface INhanVienController {
    public NhanVien nhapNhanVien() throws SQLException;
    public void inNhanViens() throws SQLException;
    public void queryGetTenNhaVienFromMaNhanVien(String maNV) throws SQLException;
    public void queryDeteletNhaVienFromMaNhanVien(String maNV) throws SQLException;
    public void queryUpdateTenNhaVienFromMaNhanVien(String maNV, String tenNV) throws SQLException;

}
