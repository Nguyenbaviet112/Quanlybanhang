/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenBaViet
 */
public class QuanLyHoaDon {


    public List<HoaDon> LayDanhSachHoaDonTheoThang(int Month, int Year)
    {
        Connection connection = null;
        ResultSet rs = null;
        List<HoaDon> lst = new ArrayList<HoaDon>();
        int index = 0;

        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                String strSQL = String.format("SELECT *, SUM(GiaCuoi) as TongTien FROM chitiethd WHERE MONTH(NgayLap) = %d AND YEAR(NgayLap) = %d GROUP BY NgayLap",
                        Month, Year);
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {

                    HoaDon hd = new HoaDon();
                    hd.setMaCTHD(rs.getInt("MaCTHD"));
                    hd.setMaHD(rs.getInt("MaHD"));
                    hd.setGiaGoc(rs.getDouble("GiaGoc"));
                    hd.setTenSP(rs.getString("TenSanPham"));
                    hd.setTenKhachHang(rs.getString("TenKhachHang"));
                    hd.setKhuyenMai(rs.getString("KhuyenMai"));
                    hd.setGiaCuoi(rs.getDouble("GiaCuoi"));
                    hd.setNgayLap(rs.getString("NgayLap"));
                    hd.setSoLuong(rs.getInt("SoLuong"));
                    hd.setMaSP(rs.getInt("MaSP"));
                    hd.setMaKH(rs.getInt("MaKH"));
                    hd.setTongTien(rs.getDouble("TongTien"));
                    hd.setIndex(index);
                    lst.add(hd);
                    index++;
                }
            }



        }
        catch(Exception e)
        {

        }
        finally {
            if (connection != null) {
                try {
                    rs.close();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lst;
    }


    public List<HoaDon> LayDanhSachNam()
    {
        Connection connection = null;
        ResultSet rs = null;
        List<HoaDon> lst = new ArrayList<HoaDon>();

        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                String strSQL = String.format("SELECT DISTINCT YEAR(NgayLap) AS Nam FROM chitiethd ORDER BY YEAR(NgayLap)");
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {

                    HoaDon hd = new HoaDon();
                    hd.setYear(rs.getInt("Nam"));
                    lst.add(hd);
                }
            }



        }
        catch(Exception e)
        {

        }
        finally {
            if (connection != null) {
                try {
                    rs.close();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lst;
    }

    public boolean  ThemHoaDon(int MaKH, double TongGia)
    {
        Connection connection = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {

                String sql = String.format("Insert into HoaDon(MaKH,TongGia) values('%s',%f)",MaKH,TongGia);

                Statement statement = connection.createStatement();
                int n = statement.executeUpdate(sql);

                if (n == 1){
                    return true;
                } else {
                    return false;
                }

            }



        }
        catch(Exception e)
        {

        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }


    public HoaDon LayHoaDonMoiNhat()
    {
        Connection connection = null;
        ResultSet rs = null;
        HoaDon HD = new HoaDon();
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                String strSQL = "SELECT * FROM `HoaDon` WHERE 1 ORDER by MaHD DESC LIMIT 1;";
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    HD.setMaHD(rs.getInt("MaHD"));
                    HD.setMaKH(rs.getInt("MaKH"));
                    HD.setTongTien(rs.getDouble("TongGia"));
                }
            }



        }
        catch(Exception e)
        {

        }
        finally {
            if (connection != null) {
                try {
                    rs.close();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return HD;
    }

}
