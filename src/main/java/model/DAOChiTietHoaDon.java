package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOChiTietHoaDon {
    public boolean ThemCTHD(ChiTietHoaDon CTHD)
    {
        Connection connection = null;
        try
        {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection =  dataConnnectManager.getConnection();

            if (connection != null)
            {

                String sql = String.format("Insert into chitiethd(TenKhachHang,TenSanPham,SoLuong,GiaGoc,KhuyenMai,GiaCuoi,NgayLap,MaHD,MaKH,MaSP) values('%s','%s',%d,%f,'%s',%f,'%s',%d,%d,%d)",CTHD.getTenKhachHang(),CTHD.getTenSanPham(),CTHD.getSoLuong(),CTHD.getGiaGoc(),CTHD.getKhuyenMai(),CTHD.getGiaCuoi(),CTHD.getNgayLap(),CTHD.getMaHD(),CTHD.getMaKH(),CTHD.getMaSP());

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

    public List<ChiTietHoaDon> getAllChiTietHoaDonTheoMAHD(int MAHD) {
        Connection connection = null;
        ResultSet rs = null;
        List<ChiTietHoaDon> list = new ArrayList();

        try {
            DataConnectManager dataConnnectManager = new DataConnectManager();
            connection = dataConnnectManager.getConnection();

            if (connection != null) {
                String strSQL = String.format("select * from chitiethd where MaHD = %d",MAHD);

                rs = dataConnnectManager.getDataTable(strSQL, connection);
                while (rs.next()) {
                    ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                    chiTietHoaDon.setTenKhachHang(rs.getString("TenKhachHang"));
                    chiTietHoaDon.setTenSanPham(rs.getString("TenSanPham"));
                    chiTietHoaDon.setSoLuong(rs.getInt("SoLuong"));
                    chiTietHoaDon.setGiaGoc(rs.getDouble("GiaGoc"));
                    chiTietHoaDon.setKhuyenMai(rs.getString("KhuyenMai"));
                    chiTietHoaDon.setGiaCuoi(rs.getDouble("GiaCuoi"));
                    chiTietHoaDon.setNgayLap(rs.getString("NgayLap"));
                    chiTietHoaDon.setMaHD(rs.getInt("MaHD"));
                    chiTietHoaDon.setMaKH(rs.getInt("MaKH"));
                    chiTietHoaDon.setMaSP(rs.getInt("MaSP"));
                    list.add(chiTietHoaDon);

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
        return list;
    }
}
