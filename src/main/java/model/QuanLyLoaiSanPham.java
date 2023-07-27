/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NguyenBaViet
 */


import java.sql.PreparedStatement;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;



public class QuanLyLoaiSanPham {
    
    
    public List<LoaiSanPham> getAllLoaiSanPham()
    {
        Connection connection = null;
        ResultSet rs = null;
        List<LoaiSanPham> lst = new ArrayList<LoaiSanPham>();
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();
            
            if (connection != null)
            {
                String strSQL = "SELECT * FROM loaisanpham";
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    LoaiSanPham lsp = new LoaiSanPham();
                    lsp.setMaLoaiSanPham(rs.getInt("MaLoaiSanPham"));
                    lsp.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
                    lsp.setBiXoa(rs.getInt("BiXoa"));
                    lst.add(lsp);
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
    
}
