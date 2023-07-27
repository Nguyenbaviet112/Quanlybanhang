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
public class QuanLyTaiKhoan {
    
    public List<TaiKhoan> LayDanSachTaiKhoan()
    {
        Connection connection = null;
        ResultSet rs = null;
        List<TaiKhoan> lst = new ArrayList<TaiKhoan>();
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();
            
            if (connection != null)
            {
                String strSQL = "SELECT * FROM taikhoan";
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    TaiKhoan tk = new TaiKhoan();
                    tk.setMaTK(rs.getInt("MaTK"));
                    tk.setSoDu(rs.getDouble("SoDu"));
                    tk.setMaKH(rs.getInt("MaKH"));
                    lst.add(tk);
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

    public int getMakhuyenMaiChoTaiKhoan(int MaAC)
    {
        QuanLyKhuyenMai km = new QuanLyKhuyenMai();
        return  km.getMaKM(MaAC);
    }
    
    
    public boolean ThemTaiKhoan(TaiKhoan taikhoan)
    {
        Connection connection = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                
                String sql = String.format("INSERT INTO taikhoan(SoDu, MaKH) Values(%f, %d)",
                       taikhoan.getSoDu(),taikhoan.getMaTK()); 

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
    
   
    public boolean CapNhatTaiKhoan(TaiKhoan tk)
    {
        Connection connection = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                
                String sql = String.format("update  taikhoan set SoDu = %f"
                        + " where MaTK = %d", tk.getSoDu(), tk.getMaTK());

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
    
    
    public TaiKhoan LayTaiKhoanTheoMa(int MaTK)
    {
        Connection connection = null;
        ResultSet rs = null;
        TaiKhoan tk = new TaiKhoan();
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();
            
            if (connection != null)
            {
                String strSQL = String.format("SELECT * FROM taikhoan where MaTK = %d", MaTK);
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    tk.setMaTK(rs.getInt("MaTK"));
                    tk.setSoDu(rs.getDouble("SoDu"));
                    tk.setMaKH(rs.getInt("MaKH"));
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
        return tk;
    }
    
}
