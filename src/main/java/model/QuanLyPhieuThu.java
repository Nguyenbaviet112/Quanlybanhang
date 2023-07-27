/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenBaViet
 */
public class QuanLyPhieuThu {
    public boolean ThemPhieuThu(PhieuThu pt)
    {
        Connection connection = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                
                String sql = String.format("INSERT INTO phieuthu(NgayLap, SoTienNop, MaKH) Values('%s', %f, %d)",
                       pt.getNgayNhap(),pt.getSoTienNop(), pt.getMaKH());

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
}
