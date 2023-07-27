/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThinkKING
 */
public class KhachHangDAO {
    public List<KhachHang> getAllKhachHang() {
        Connection connection = null;
        ResultSet rs = null;
        List<KhachHang> list = new ArrayList();

        try {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection = dataConnnectManager.getConnection();

            if (connection != null) {
                String strSQL = String.format("select * from khachhang ");

                rs = dataConnnectManager.getDataTable(strSQL, connection);
                while (rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                    kh.setTenKhachHang(rs.getString("TenKhachHang"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
                    list.add(kh);

                }
            }

        } catch (Exception e) {
        } finally {
            if (connection != null) {
                try {
                    rs.close();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public KhachHang TimKhachHang(int MaKH) {
        Connection connection = null;
        ResultSet rs = null;
        KhachHang kh = new KhachHang();
        try {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection = dataConnnectManager.getConnection();

            if (connection != null) {
                String strSQL = String.format("select * from khachhang where MaKhachHang = %d",MaKH);

                rs = dataConnnectManager.getDataTable(strSQL, connection);
                while (rs.next()) {

                    kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                    kh.setTenKhachHang(rs.getString("TenKhachHang"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
                    return kh;

                }
            }

        } catch (Exception e) {
        } finally {
            if (connection != null) {
                try {
                    rs.close();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kh;
    }
    
    public KhachHang TimKhachHangTheoMaAC(int MaAC)
    {
        
        Connection connection = null;
        ResultSet rs = null;
        KhachHang kh = new KhachHang();
        try {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection = dataConnnectManager.getConnection();

            if (connection != null) {
                String strSQL = String.format("SELECT * FROM accountlogin ac JOIN khachhang kh on ac.MaKhachHang = kh.MaKhachHang where ac.MaAC = %d", MaAC);

                rs = dataConnnectManager.getDataTable(strSQL, connection);
                while (rs.next()) {

                    kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                    kh.setTenKhachHang(rs.getString("TenKhachHang"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
                    return kh;

                }
            }

        } catch (Exception e) {
        } finally {
            if (connection != null) {
                try {
                    rs.close();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kh;
    }

}
