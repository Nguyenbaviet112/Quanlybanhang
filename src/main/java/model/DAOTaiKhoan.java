package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOTaiKhoan {
    
    public TaiKhoan getSoDu(int MaKH) {
        Connection connection = null;
        ResultSet rs = null;
        TaiKhoan TK = new TaiKhoan();
        try {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection = dataConnnectManager.getConnection();

            if (connection != null) {
                String strSQL = String.format("SELECT * FROM taikhoan tk JOIN khachHang kh on tk.MaKH = kh.MaKhachHang WHERE kh.MaKhachHang = %d", MaKH);

                rs = dataConnnectManager.getDataTable(strSQL, connection);
                while (rs.next()) {
                    TK.setMaKH(rs.getInt("MaKH"));
                    TK.setMaTK(rs.getInt("MaTK"));
                    TK.setSoDu(rs.getDouble("SoDu"));
                    return TK;

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
    
    


}
