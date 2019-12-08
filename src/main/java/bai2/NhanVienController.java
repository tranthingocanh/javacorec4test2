package bai2;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class NhanVienController implements INhanVienController{

    public NhanVien nhapNhanVien() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap Ma NV: ");
        String maNV = sc.nextLine();

        System.out.println("Nhap Ten NV: ");
        String tenNV = sc.nextLine();

        NhanVien nhanVien = new NhanVien(maNV, tenNV);

        Connection connection = ConnectionUtils.getOracleConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO TEST2 VALUES("+"'"+nhanVien.getMaNV()+"'"+","
                +"'"+nhanVien.getTenNV()+"'"+")";
        ResultSet rs = statement.executeQuery(sql);
        System.out.println("Success Nhan Vien moi vao database");
        System.out.println(nhanVien.toString());


        connection.close();

        return nhanVien;
    }

    public void inNhanViens() throws SQLException {

        Connection connection = ConnectionUtils.getOracleConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM TEST2";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String maNV = rs.getString(1);
            String tenNV = rs.getString(2);
            System.out.println("--------------------");
            System.out.println("Ma NV:" + maNV);
            System.out.println("Ten NV:" + tenNV);
        }
        connection.close();
    }

    public void queryGetTenNhaVienFromMaNhanVien(String maNV) throws SQLException {
        Connection connection = ConnectionUtils.getOracleConnection();
        Statement statement = connection.createStatement();

        String sql = String.format("SELECT TEN_NV FROM TEST2 WHERE MA_NV ='%s'", maNV);

        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            System.out.println("Ten NV:" + rs.getString(1));
        }

        connection.close();
    }

    public void queryDeteletNhaVienFromMaNhanVien(String maNV) throws SQLException {
        Connection connection = ConnectionUtils.getOracleConnection();

        Statement statement = connection.createStatement();
        String sql = String.format("DELETE FROM TEST2 WHERE MA_NV ='%s'", maNV);

        ResultSet rs = statement.executeQuery(sql);

        System.out.println("Delete Success!!!");

        connection.close();

    }

    public void queryUpdateTenNhaVienFromMaNhanVien(String maNV, String tenNV) throws SQLException {
        Connection connection = ConnectionUtils.getOracleConnection();
        Statement statement = connection.createStatement();

        String sql = String.format("UPDATE TEST2 SET TEN_NV = '%s' WHERE MA_NV = '%s'", tenNV, maNV);
        ResultSet rs = statement.executeQuery(sql);

        System.out.println("Update Success!!!");

        connection.close();
    }
}
