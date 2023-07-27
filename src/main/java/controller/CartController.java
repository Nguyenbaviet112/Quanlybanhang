/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.stream.events.DTD;


/**
 *
 * @author NguyenBaViet
 */
@Controller

public class CartController {
	
    QuanLyGioHang qlgh = new QuanLyGioHang();

    @RequestMapping(value = "Cart")
    public String Cart(Model model)
    {
        Collection<CartItem> cartItems = qlgh.getCartItem();
        int soLuongMua = qlgh.getCount();
        model.addAttribute("slm", soLuongMua);
        model.addAttribute("TongTien", qlgh.getAmount());
        model.addAttribute("khuyenmai", qlgh.TongTienKhuyenMai());
        model.addAttribute("sum", (qlgh.getAmount() - qlgh.TongTienKhuyenMai()));
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("TTSanPhamSauKM", qlgh.TongTienSanPhamSauKhuyenMai());
        return "Cart";
    }

    @RequestMapping(value = "CartAdd",method = RequestMethod.GET)
    public String list(Model model, @RequestParam("MaSanPham") String MaSanPham, @RequestParam("ac") String action)
    {

        if (action.equals("add"))
        {
            add(MaSanPham);
        }

        else if (action.equals("remove"))
        {
            remove(MaSanPham);
        }


        Collection<CartItem> cartItems = qlgh.getCartItem();

        int MaTaiKhoanDangKetNoi = LoginController.MaTaiKhoanDangKetNoi;
        if(MaTaiKhoanDangKetNoi != -1)
        {
            
            KhachHangDAO khdao = new KhachHangDAO();
            KhachHang kh = khdao.TimKhachHangTheoMaAC(MaTaiKhoanDangKetNoi);
            DAOTaiKhoan DAO_taikhoan = new DAOTaiKhoan();
            UserDAO us = new UserDAO();
            TaiKhoan tk = DAO_taikhoan.getSoDu(kh.getMaKhachHang());
            double SoDu = tk.getSoDu();
            double sum = qlgh.getAmount();
            double SoDuConLai = SoDu - sum;
            model.addAttribute("sodu", SoDu);
            model.addAttribute("Tendangnhap", us.gettenDangNhap(MaTaiKhoanDangKetNoi));
            model.addAttribute("soduconlai", SoDuConLai);
        }
        else {
            model.addAttribute("sodu", 0);
            model.addAttribute("Tendangnhap", "Chưa Login");
            model.addAttribute("soduconlai", 0);
        }
        LocalDate myObj = LocalDate.now();  // Create a date object
        String Date = myObj.toString();
        int soLuongMua = qlgh.getCount();
        model.addAttribute("date", Date);
        model.addAttribute("TongTien", qlgh.getAmount());
        model.addAttribute("TTSanPhamSauKM", qlgh.TongTienSanPhamSauKhuyenMai());
        double tongtienkm = (qlgh.getAmount() - qlgh.TongTienSauKhuyenMai());
        model.addAttribute("khuyenmai", qlgh.TongTienKhuyenMai());
        model.addAttribute("sum", (qlgh.getAmount() - qlgh.TongTienKhuyenMai()));
        model.addAttribute("slm", soLuongMua);
        model.addAttribute("cartItems", cartItems);


        return "Cart";
    }


    @RequestMapping(value = "CartUpdate",method = RequestMethod.GET)
        public String CartUpdate(Model model, @RequestParam("MaSanPham") String MaSanPham, @RequestParam("SoLuongMua") int slm)
    {

        int MaTaiKhoanDangKetNoi = LoginController.MaTaiKhoanDangKetNoi;
        DAOTaiKhoan DAO_taikhoan = new DAOTaiKhoan();
        UserDAO us = new UserDAO();
        
        KhachHangDAO khdao = new KhachHangDAO();
        KhachHang kh = khdao.TimKhachHangTheoMaAC(MaTaiKhoanDangKetNoi);
        
        TaiKhoan tk = DAO_taikhoan.getSoDu(kh.getMaKhachHang());
        double SoDu = tk.getSoDu();
        update(MaSanPham, slm);
        Collection<CartItem> cartItems = qlgh.getCartItem();
        
        
        double ttskm = qlgh.TongTienSauKhuyenMai();
        
        
        model.addAttribute("TongTien", qlgh.getAmount());
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("sum", qlgh.TongTienSauKhuyenMai());
        double SoDuConLai = SoDu - qlgh.getAmount();
        LocalDate myObj = LocalDate.now();  // Create a date object
        String Date = myObj.toString();
        int soLuongMua = qlgh.getCount();
        model.addAttribute("date", Date);
        model.addAttribute("sodu", SoDu);
        model.addAttribute("Tendangnhap", us.gettenDangNhap(MaTaiKhoanDangKetNoi));
        model.addAttribute("soduconlai", SoDuConLai);
        model.addAttribute("khuyenmai", qlgh.TongTienKhuyenMai());
        
        model.addAttribute("sum", (qlgh.getAmount() - qlgh.TongTienKhuyenMai()));
        model.addAttribute("slm", soLuongMua);
        model.addAttribute("TTSanPhamSauKM", qlgh.TongTienSanPhamSauKhuyenMai());
        return "Cart";
    }

    public void add(String MaSanPham)
    {

        QuanLySanPham qlsp = new QuanLySanPham();
        SanPham sp = new SanPham();
        sp = qlsp.TimKiemSanPhamTheoId(MaSanPham);


        if (sp != null)
        {
            CartItem item = new CartItem();
            BeanUtils.copyProperties(sp, item);
            item.setSoLuongMua(1);
            qlgh.add(item);
        }

    }

    public void remove(String MaSanPham)
    {
        qlgh.remove(MaSanPham);
    }

    public String update(String MaSanPham, int SoLuongMua)
    {
        qlgh.update(MaSanPham, SoLuongMua);
        return "Cart";
    }

}
