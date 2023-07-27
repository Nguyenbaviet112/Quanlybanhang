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
import com.mysql.jdbc.PreparedStatement;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author HocVien
 */
public class DataConnectManager {
    
    
    Connection conn = null;
    static String ConnectionString = "jdbc:mysql://localhost/quanlybanhang";
    private PreparedStatement pre;
    
    public Connection getConnection()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "");
            conn = DriverManager.getConnection(ConnectionString, connectionProps);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    
    public ResultSet getDataTable(String strSQL, Connection connection)
    {
        ResultSet rs = null;
        try
        {
            if (conn != null) {
                Statement st = conn.createStatement();
                rs = st.executeQuery(strSQL);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
               
        }
        return rs;
    }
    
    public int Insert(String strSQL, Connection connection)
    {
        try
        {
            if (conn != null) {
               int kq = getPre().executeUpdate();
               
            }
            
        }
        catch(Exception ex)
        {
        
        }
        return 0;
    }

    /**
     * @return the pre
     */
    public PreparedStatement getPre() {
        return pre;
    }

    /**
     * @param pre the pre to set
     */
    public void setPre(PreparedStatement pre) {
        this.pre = pre;
    }
    
}

