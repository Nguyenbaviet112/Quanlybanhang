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
 * @author ThinkKING
 */
public class UserDAO {

    public User FindUser(String user, String pass) {
        Connection connection = null;
        ResultSet rs = null;
        User userr = new User();
        try {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection = dataConnnectManager.getConnection();

            if (connection != null) {
                String strSQL = String.format("select * from accountlogin where tendangnhap = '%s' and matkhau='%s' ", user, pass);

                rs = dataConnnectManager.getDataTable(strSQL, connection);
                while (rs.next()) {
              
                    userr.setMaAC(rs.getInt("MaAC"));
                    userr.setTendangnhap(rs.getString("tendangnhap"));
                    userr.setMatkhau(rs.getString("matkhau"));
                    userr.setTenhienthi(rs.getString("tenhienthi"));
                    userr.setMaloaitaikhoan(rs.getInt("maloaitaikhoan"));
                    return userr;

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
        return null;
    }
    
     public int AddUser(String username , String password){
         Connection connection = null;
      int check =0;
        User userr = new User();
        try {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection = dataConnnectManager.getConnection();

            if (connection != null) {
                String strSQL = String.format("insert into  accountlogin(tendangnhap,matkhau) values( '%s','%s')",username,password);
                Statement statement = connection.createStatement();
               check = statement.executeUpdate(strSQL);
                
            }              
          
        } catch (Exception e) {
        } finally {
            if (connection != null) {
                try {
                   
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       return check;            
    }
    public String gettenDangNhap(int MaAC) {
        Connection connection = null;
        ResultSet rs = null;
        User userr = new User();
        try {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection = dataConnnectManager.getConnection();

            if (connection != null) {
                String strSQL = String.format("select * from accountlogin where MaAC = %d ", MaAC);

                rs = dataConnnectManager.getDataTable(strSQL, connection);
                while (rs.next()) {

                    userr.setMaAC(rs.getInt("MaAC"));
                    userr.setTendangnhap(rs.getString("tendangnhap"));
                    userr.setMatkhau(rs.getString("matkhau"));
                    userr.setTenhienthi(rs.getString("tenhienthi"));
                    userr.setBixoa(rs.getInt("bixoa"));
                    userr.setMaloaitaikhoan(rs.getInt("maloaitaikhoan"));
                    return userr.getTendangnhap();

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
        return null;
    }


    public boolean CheckUser(String user) {
        Connection connection = null;
        ResultSet rs = null;
        User userr = new User();
        try {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection = dataConnnectManager.getConnection();

            if (connection != null) {
                String strSQL = String.format("select * from accountlogin where tendangnhap = '%s' ", user);

                rs = dataConnnectManager.getDataTable(strSQL, connection);

                if (!rs.isBeforeFirst()) {
                    return false;
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
        return true;
    }


}
