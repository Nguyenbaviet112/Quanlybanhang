/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.*;

@Controller
public class Bill {
	
    @RequestMapping(value = "/Bill",method = RequestMethod.GET)
    public String LayDanhSachSanPham(Model model, @RequestParam("TenDangNhap") String TenDangNhap,@RequestParam("TongGia") double TongGia){
        // them phieu xuat
        DAOPhieuXuat daoPhieuXuat = new DAOPhieuXuat();
        PhieuXuat px = new PhieuXuat();
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        QuanLyKhuyenMai quanLyKhuyenMai = new QuanLyKhuyenMai();
        DAOChiTietHoaDon daoChiTietHoaDon = new DAOChiTietHoaDon();
        
        
        KhachHang KH = qlkh.TimKiemKhachHangTheoTenDangNhap(TenDangNhap);
        int MaTaiKhoanDangKetNoi = LoginController.MaTaiKhoanDangKetNoi;
        
        KhachHang kh = khachHangDAO.TimKhachHangTheoMaAC(MaTaiKhoanDangKetNoi);
        
        DAOTaiKhoan DAO_taikhoan = new DAOTaiKhoan();
        TaiKhoan tk = DAO_taikhoan.getSoDu(kh.getMaKhachHang());
        double SoDu = tk.getSoDu();
        
        
        tk.setSoDu( SoDu - TongGia);
        
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        
        qltk.CapNhatTaiKhoan(tk);
        
        
        LocalDate myObj = LocalDate.now();  // Create a date object
        String Date = myObj.toString();
        px.setSoTienMua(TongGia);
        px.setSoTienTruocThanhToan(SoDu);
        px.setSoDuConLai(SoDu - TongGia);
        px.setNgayLap(Date);
        px.setMaKH(KH.getMaKhachHang());
        boolean a = daoPhieuXuat.ThemPhieuXuat(px);

        // them Hoa Dơn
        QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon();
        boolean c = quanLyHoaDon.ThemHoaDon(KH.getMaKhachHang(),TongGia);
        int masp = 0;
        
        
        HoaDon hdmn = quanLyHoaDon.LayHoaDonMoiNhat();
        
        
        // Them Chi Tiet Hoa Don
        QuanLyGioHang qlgh = new QuanLyGioHang();
        Map<String, CartItem> map = qlgh.map1;

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            //sum +=  map.get(key).getGiaSanPham();
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.setMaHD(quanLyHoaDon.LayHoaDonMoiNhat().getMaHD());
            chiTietHoaDon.setGiaCuoi(TongGia);
            chiTietHoaDon.setTenSanPham(map.get(key).getTenSanPham());
            chiTietHoaDon.setGiaGoc(map.get(key).getGiaSanPham());
            chiTietHoaDon.setTenKhachHang(khachHangDAO.TimKhachHang(KH.getMaKhachHang()).getTenKhachHang());
            chiTietHoaDon.setMaKH(KH.getMaKhachHang());
            chiTietHoaDon.setMaSP(Integer.parseInt( map.get(key).getMaSanPham()));
            chiTietHoaDon.setNgayLap(Date);
            chiTietHoaDon.setKhuyenMai(quanLyKhuyenMai.TimTenKhuyenMai(quanLyKhuyenMai.getMaKMSP(Integer.parseInt( map.get(key).getMaSanPham()))));
            chiTietHoaDon.setSoLuong(map.get(key).getSoLuongMua());
            boolean b =    daoChiTietHoaDon.ThemCTHD(chiTietHoaDon);

        }
        
        //Lay Xuat chi tiet hoa don va quy cach
        List<ChiTietHoaDon> chiTietHoaDonList = daoChiTietHoaDon.getAllChiTietHoaDonTheoMAHD(quanLyHoaDon.LayHoaDonMoiNhat().getMaHD());
        DAOQuyCach daoQuyCach = new DAOQuyCach();
        List<ListChiTietHoaDon> listChiTietHoaDons = new ArrayList();
        for (ChiTietHoaDon item:chiTietHoaDonList) {
            ListChiTietHoaDon lst = new ListChiTietHoaDon();
            lst.setCthd(item);
            lst.setQuyCach(daoQuyCach.getQuyCach(item.getMaSP()));
            listChiTietHoaDons.add(lst);
        }

        model.addAttribute("Lst",listChiTietHoaDons);
        map.clear();
        return "Bill";
    }
}
