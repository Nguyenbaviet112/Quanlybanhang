package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuanLyKhuyenMai {

    public int getMaKM(int MaKH)
    {
        Connection connection = null;
        ResultSet rs = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                String strSQL = String.format("SELECT khkm.MaKM FROM khachhang kh JOIN khachhangkhuyenmai khkm on kh.MaKhachHang = khkm.MaKh"
                        + " WHERE kh.MaKhachHang = %d", MaKH);
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    return rs.getInt("MaKM");
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
        return -1;
    }

    public int getMaKMSP(int MaSP)
    {
        Connection connection = null;
        ResultSet rs = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                String strSQL = String.format("SELECT * from SanPhamKhuyenMai where MaSP = %d", MaSP);
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    return rs.getInt("MaKM");
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
        return -1;
    }

    public String TimTenKhuyenMai(int MaKM)
    {
        Connection connection = null;
        ResultSet rs = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                String strSQL = String.format("SELECT * from KhuyenMai where MaKM = %d", MaKM);
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    return rs.getString("TenKM");
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
        return "";
    }
    
    
    public double LaySoTienKM(int MaKM)
    {
        Connection connection = null;
        ResultSet rs = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                String strSQL = String.format("SELECT SoTienKM FROM khuyenmai where MaKM = %d", MaKM);
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    return rs.getDouble("SoTienKM");
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
        return -1;
    }
    
    
}
