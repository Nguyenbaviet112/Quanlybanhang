/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.LoginController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author NguyenBaViet
 */
public class QuanLyGioHang {
    
    private Map<String, CartItem> map = new HashMap<String, CartItem>();
    public static Map<String, CartItem> map1;
    public void add(CartItem item)
    {
        CartItem existedItem = map.get(item.getMaSanPham());
        
        if (existedItem != null)
        {
            existedItem.setSoLuongMua(item.getSoLuongMua() + existedItem.getSoLuongMua());
        }
        else
        {
            map.put(item.getMaSanPham(), item);
        }
        map1 = map;
        
    }
    
    public void remove(String MaSanPham)
    {
        map.remove(MaSanPham);
        map1 = map;
    }
    
    public Collection<CartItem> getCartItem()   
    {
        return map.values();
    }
    
    public Map<String, CartItem> getMap(){return map;}
    public void clear()
    {
        map.clear();
    }
    
    
    public void update(String MaSanPham, int SoLuongMua)
    {
        CartItem item = map.get(MaSanPham);
        QuanLySanPham qlsp = new QuanLySanPham();
        SanPham sp = qlsp.TimKiemSanPhamTheoId(MaSanPham);
        double giasp = sp.getGiaSanPham();
        
        if (SoLuongMua > item.getSoLuongMua())
        {
            item.setSoLuongMua(SoLuongMua);
            item.setGiaSanPham(item.getGiaSanPham() + giasp);
        }
        else
        {
            item.setSoLuongMua(SoLuongMua);
            
            item.setGiaSanPham(item.getGiaSanPham() - giasp);
        }
        
        
        
        if (item.getSoLuongMua() <= 0)
        {
            map.remove(MaSanPham);
        }
        map1 = map;
    }
    public int getCount()
    {
        if (map.isEmpty())
            return 0;
        return map.values().size();
    }
    
    
    public double getAmount()
    {
        double sum = 0;
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            sum +=  map.get(key).getGiaSanPham();
        }
        return sum;
    }
    public double getTiemMuaSanPhamSauKhuyenMai(int MaSP, int soluong, double gia)
    {
        QuanLyKhuyenMai km = new QuanLyKhuyenMai();
        DAOQuyCach  daoQuyCach = new DAOQuyCach();
        int sl = soluong;
        double sum = 0;
        QuyCach qc = daoQuyCach.getQuyCach(MaSP);
        int MaKM = km.getMaKMSP(MaSP);
        
        double SoTienKM = km.LaySoTienKM(MaKM);
        
        if(qc.getSoluong() <= sl )
        {
            sl = soluong - qc.getSoluong();
            sum += qc.getGiatien();
        }

            for (int i = 0; i < sl; i++) {
                if(SoTienKM != -1)
                {
                    sum = SoTienKM > 1 ? (sum+= SoTienKM): - (sum= sum * SoTienKM);
                }
            }
        
        
        return ((gia*soluong)-sum);
    }
    public double getTienKhuyenMai(int MaSP, int soluong, double gia)
    {
        QuanLyKhuyenMai km = new QuanLyKhuyenMai();
        DAOQuyCach  daoQuyCach = new DAOQuyCach();
        int sl = soluong;
        double sum = 0;
        QuyCach qc = daoQuyCach.getQuyCach(MaSP);
        int MaKM = km.getMaKMSP(MaSP);
        
        double SoTienKM = km.LaySoTienKM(MaKM);
        
        if(qc.getSoluong() <= sl )
        {
            sl = soluong - qc.getSoluong();
            sum += qc.getGiatien();
        }

            for (int i = 0; i < sl; i++) {
                if(SoTienKM != -1)
                {
                    sum = SoTienKM > 1 ? (sum+= SoTienKM): - (sum= sum * SoTienKM);
                }
            }
        
        
        return sum;
    }

    public double getGiaCuoi(CartItem cartItem)
    {
        return getTiemMuaSanPhamSauKhuyenMai(Integer.parseInt(cartItem.getMaSanPham()),cartItem.getSoLuongMua(),cartItem.getGiaSanPham());
    }
    
    public double TongTienKhuyenMai()
    {
        double sum = 0;
        Set<String> keySet = map.keySet();
        QuanLySanPham qlsp = new QuanLySanPham();
        for (String key : keySet) {
            double giasp = qlsp.TimKiemSanPhamTheoId(map.get(key).getMaSanPham()).getGiaSanPham();
            sum +=  getTienKhuyenMai(Integer.parseInt(map.get(key).getMaSanPham()),map.get(key).getSoLuongMua(),giasp);
        }
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        int MaAC = LoginController.MaTaiKhoanDangKetNoi;
        
        KhachHangDAO khdao = new KhachHangDAO();
        KhachHang kh = khdao.TimKhachHangTheoMaAC(MaAC);
        
        QuanLyKhuyenMai km = new QuanLyKhuyenMai();
        
        int makmtk = qltk.getMakhuyenMaiChoTaiKhoan(kh.getMaKhachHang());
        double tongTienSanPhamSauKhuyenmai = 0;
        double SoTienKM = km.LaySoTienKM(makmtk);
        for (String key : keySet) {
            double giasp = qlsp.TimKiemSanPhamTheoId(map.get(key).getMaSanPham()).getGiaSanPham();
            tongTienSanPhamSauKhuyenmai +=  getTiemMuaSanPhamSauKhuyenMai(Integer.parseInt(map.get(key).getMaSanPham()),map.get(key).getSoLuongMua(),giasp);
        }
         
        if(MaAC != -1)
        {
                if(SoTienKM != -1)
                {
                    tongTienSanPhamSauKhuyenmai = SoTienKM > 1 ? SoTienKM: (tongTienSanPhamSauKhuyenmai * SoTienKM);
                }
                else
                    tongTienSanPhamSauKhuyenmai = 0;
        }
        return sum + tongTienSanPhamSauKhuyenmai;
    }

    public double TongTienSauKhuyenMai()
    {
        // tien khuyen mai cho sp
        double sum = 0;
        Set<String> keySet = map.keySet();
        QuanLySanPham qlsp = new QuanLySanPham();
        for (String key : keySet) {
            double giasp = qlsp.TimKiemSanPhamTheoId(map.get(key).getMaSanPham()).getGiaSanPham();
            sum +=  getTiemMuaSanPhamSauKhuyenMai(Integer.parseInt(map.get(key).getMaSanPham()),map.get(key).getSoLuongMua(),giasp);
        }
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        int MaAC = LoginController.MaTaiKhoanDangKetNoi;
        
        KhachHangDAO khdao = new KhachHangDAO();
        KhachHang kh = khdao.TimKhachHangTheoMaAC(MaAC);
        
        QuanLyKhuyenMai km = new QuanLyKhuyenMai();
        
        int makmtk = qltk.getMakhuyenMaiChoTaiKhoan(kh.getMaKhachHang());
        double SoTienKM = km.LaySoTienKM(makmtk);
        if(MaAC != -1)
        {
                if(SoTienKM != -1)
                {
                    sum = SoTienKM > 1 ? (sum+= SoTienKM): (sum= sum * SoTienKM);
                }
                else
                    sum = sum;
        }
        
        return sum;
    }
    
    public double TongTienSanPhamSauKhuyenMai()
    {
        // tien khuyen mai cho sp
        double sum = 0;
        Set<String> keySet = map.keySet();
        QuanLySanPham qlsp = new QuanLySanPham();
        for (String key : keySet) {
            double giasp = qlsp.TimKiemSanPhamTheoId(map.get(key).getMaSanPham()).getGiaSanPham();
            sum +=  getTiemMuaSanPhamSauKhuyenMai(Integer.parseInt(map.get(key).getMaSanPham()),map.get(key).getSoLuongMua(),giasp);
        }
        return sum;
    }
    
}
