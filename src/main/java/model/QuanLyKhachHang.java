/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class QuanLyKhachHang {
    public List<KhachHang> LayDanSachKhachHang()
    {
        Connection connection = null;
        ResultSet rs = null;
        List<KhachHang> lst = new ArrayList<KhachHang>();
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();
            
            if (connection != null)
            {
                String strSQL = "SELECT * FROM khachhang";
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    KhachHang kh = new KhachHang();
                    kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                    kh.setTenKhachHang(rs.getString("TenKhachHang"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
                    lst.add(kh);
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
                    Logger.getLogger(QuanLyLoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lst;
    }
        
        
        
     public List<KhachHang> LayKhachHangTheoTrang(int Trang)
    {
        Connection connection = null;
        ResultSet rs = null;
        List<KhachHang> lst = new ArrayList<KhachHang>();
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                String strSQL = String.format("SELECT * FROM khachhang\n" +
                        "LIMIT 5 OFFSET %d", Trang*5 - 5);
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    KhachHang kh = new KhachHang();
                    kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                    kh.setTenKhachHang(rs.getString("TenKhachHang"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
                    lst.add(kh);
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
     
     
     public boolean ThemKhachHang(KhachHang khachhang)
    {
        Connection connection = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                
                String sql = String.format("INSERT INTO khachhang(TenKhachHang, DiaChi, DienThoai, Email) Values('%s','%s',%s,'%s')",
                       khachhang.getTenKhachHang(),khachhang.getDiaChi(),khachhang.getDienThoai(),khachhang.getEmail());

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
     
     
    public KhachHang TimKiemKhachHangTheoMa(int MaKhachHang)
    {
        Connection connection = null;
        ResultSet rs = null;
        KhachHang kh = new KhachHang();
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();
            
            if (connection != null)
            {
                String strSQL = String.format("SELECT * FROM khachhang WHERE MaKhachHang = %d", MaKhachHang);
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                    kh.setTenKhachHang(rs.getString("TenKhachHang"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
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
        return kh;
    }


    public KhachHang TimKiemKhachHangTheoTenDangNhap(String TenDangNhap)
    {
        Connection connection = null;
        ResultSet rs = null;
        KhachHang kh = new KhachHang();
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                String strSQL = String.format("SELECT * FROM accountlogin ac JOIN khachhang kh on ac.MaKhachHang = kh.MaKhachHang where ac.TenDangNhap = '%s'", TenDangNhap);
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                    kh.setTenKhachHang(rs.getString("TenKhachHang"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
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
        return kh;
    }
     
    
    public boolean CapNhatKhachHang(KhachHang kh)
    {
        Connection connection = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                
                String sql = String.format("update  KhachHang set TenKhachHang = '%s', DiaChi = '%s', DienThoai = '%s', Email = '%s'"
                        + " where MaKhachHang = '%d'", kh.getTenKhachHang(), kh.getDiaChi(), kh.getDienThoai(), kh.getEmail(), kh.getMaKhachHang());

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
     
    
    public boolean XoaKhachHang(int MaKhachHang)
    {
        Connection connection = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                
                String sql = String.format("delete from khachhang where MaKhachHang = %d", MaKhachHang);

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
    
    public List<KhachHang> TimKiemKhachHang(String SearchName)
    {
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement smt = null;
        List<KhachHang> lst = new ArrayList<KhachHang>();
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();
            
            if (connection != null)
            {
                
                /*String strSQL = "SELECT * FROM sanpham WHERE TenSanPham ='"+SearchName+"'";
                connection =  dataConnnectManager.getConnection();*/
                String strSQL = "SELECT * FROM khachhang WHERE TenKhachHang LIKE ?";
                smt = connection.prepareStatement(strSQL);
                smt.setString(1, "%"+ SearchName +"%");
                rs = smt.executeQuery();
                while(rs.next())
                {                  
                    KhachHang kh = new KhachHang();
                    kh.setMaKhachHang(rs.getInt("MaKhachHang"));
                    kh.setTenKhachHang(rs.getString("TenKhachHang"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
                    lst.add(kh);
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
     
}
