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

import javax.ws.rs.core.Request;
import java.util.List;

@Controller
public class PayController {
    
    @RequestMapping(value = "/Pay",method = RequestMethod.GET)
    public String LayThongTinTaiKhoan(Model model){

        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        List<TaiKhoan> List_tk = qltk.LayDanSachTaiKhoan();

        model.addAttribute("list_tk", List_tk);
        
        
        return "Pay";
    }
    
    
    
    @RequestMapping(value = "/AddPay",method = RequestMethod.GET)
    public String Them_Tk_PT(Model model, @RequestParam("taikhoan") int MaTK, @RequestParam("money") double SoTien, @RequestParam("date") String NgayLap){

        QuanLyPhieuThu qlpt = new QuanLyPhieuThu();
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        
        
         TaiKhoan tk = qltk.LayTaiKhoanTheoMa(MaTK);
        
        
        
        PhieuThu pt = new PhieuThu();
        pt.setMaKH(tk.getMaKH());
        pt.setNgayNhap(NgayLap);
        pt.setSoTienNop(SoTien);
        
        boolean ktpt = qlpt.ThemPhieuThu(pt);
        
        
        
        tk.setSoDu(SoTien + tk.getSoDu());
            
        
        boolean kt = qltk.CapNhatTaiKhoan(tk);

        
        if (kt == true && ktpt == true)
        {
            String show = "Bạn đã nạp tiền thành công";
            model.addAttribute("show", show);
        
        }
        
        
        
        return "ShowSuccess";
    }
    
}
