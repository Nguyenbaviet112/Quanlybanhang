package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOQuyCach {
    public QuyCach getQuyCach(int MaSP)
    {
        Connection connection = null;
        ResultSet rs = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {
                String strSQL = String.format("SELECT * from QuyCach where MaSP = %d", MaSP);
                rs =  dataConnnectManager.getDataTable(strSQL, connection);
                while(rs.next())
                {
                    QuyCach qc = new QuyCach();
                    qc.setGiatien(rs.getDouble("GiaTien"));
                    qc.setMaQC(rs.getInt("MaQC"));
                    qc.setSoluong(rs.getInt("SoLuong"));
                    qc.setMaSP(rs.getInt("MaSP"));
                    return qc;
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
        return null;
    }
}
