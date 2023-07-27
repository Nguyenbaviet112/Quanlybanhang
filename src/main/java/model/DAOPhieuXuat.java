package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPhieuXuat {
    public boolean  ThemPhieuXuat(PhieuXuat px)
    {
        Connection connection = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {

                String sql = String.format("INSERT INTO PhieuXuat(Ngaylap, SoTienMua, MaKH, SoTienTruocThanhToan, SoDuConLai) Values('%s', %f,%d,%f,%f)",
                        px.getNgayLap(),px.getSoTienMua(),px.getMaKH(),px.getSoTienTruocThanhToan(),px.getSoDuConLai());

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
        return false;
    }

}
