/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author NguyenBaViet
 */

import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.core.Request;
import java.util.List;

@Controller
public class ManagerCustomerController {
    int k = 0;
    @RequestMapping(value = "/ManagerCustomer",method = RequestMethod.GET)
    public String LayDanhSachKhachHang(Model model , @RequestParam("Trang") String Trang){

        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        QuanLySanPham qlsp = new QuanLySanPham();
        List<model.Trang> ListT = qlsp.GetTrang(Trang);
        List<KhachHang> lst_kh = qlkh.LayKhachHangTheoTrang(qlsp.PageFocus(Trang, 1));
        List<LoaiSanPham> lst_lsp = qlsp.getAllLoaiSanPham();
        model.addAttribute("list_kh", lst_kh);
        model.addAttribute("list_T", ListT);
        model.addAttribute("List_lsp", lst_lsp);
        return "ManagerCustomer";
    }
    
    
    @RequestMapping(value = "/AddAccount",method = RequestMethod.GET)
    public String ThemKhachHang(Model model , @RequestParam("name") String TenKhachHang, @RequestParam("address") String DiaChi, @RequestParam("phone") String DienThoai,
    @RequestParam("email") String Email)
    {
        String Trang = "1";
        KhachHang kh = new KhachHang();
        kh.setTenKhachHang(TenKhachHang);
        kh.setDiaChi(DiaChi);
        kh.setDienThoai(DienThoai);
        kh.setEmail(Email);
        
        QuanLySanPham qlsp = new QuanLySanPham();
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        qlkh.ThemKhachHang(kh);
        
        List<model.Trang> ListT = qlsp.GetTrang(Trang);
        List<KhachHang> lst_sp = qlkh.LayKhachHangTheoTrang(qlsp.PageFocus(Trang, 1));

        model.addAttribute("list_kh", lst_sp);
        model.addAttribute("list_T", ListT);

        
        
        return "ManagerCustomer";
    }
    
    
    
    @RequestMapping(value = "/EditAccount",method = RequestMethod.GET)
    public String LayKhachHangTheoMa(Model model , @RequestParam("MaKhachHang") int MaKhachHang)
    {


        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        KhachHang kh = qlkh.TimKiemKhachHangTheoMa(MaKhachHang);
        model.addAttribute("kh", kh);
        
        
        return "EditAccount";
    }
    
    
    @RequestMapping(value = "/editAccount",method = RequestMethod.GET)
    public String CapNhatKhachHang(Model model , @RequestParam("MaKhachHang") int MaKhachHang, @RequestParam("TenKhachHang") String TenKhachHang, @RequestParam("DiaChi") String DiaChi,
            @RequestParam("DienThoai") String DienThoai, @RequestParam("Email") String Email)
    {
       String Trang = "1";
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(MaKhachHang);
        kh.setTenKhachHang(TenKhachHang);
        kh.setDiaChi(DiaChi);
        kh.setDienThoai(DienThoai);
        kh.setEmail(Email);
        
        QuanLySanPham qlsp = new QuanLySanPham();
        
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        qlkh.CapNhatKhachHang(kh);
        
        List<model.Trang> ListT = qlsp.GetTrang(Trang);
        List<KhachHang> lst_kh = qlkh.LayKhachHangTheoTrang(qlsp.PageFocus(Trang, 1));

        model.addAttribute("list_kh", lst_kh);
        model.addAttribute("list_T", ListT);

        
        
        return "ManagerCustomer";
    }
    
    
    @RequestMapping(value = "/DeleteAccount",method = RequestMethod.GET)
    public String LayDanhSachSanPham(Model model , @RequestParam("MaKhachHang") int MaKhachHang)
    {
        String Trang = "1";
        
        
        QuanLySanPham qlsp = new QuanLySanPham();
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        qlkh.XoaKhachHang(MaKhachHang);
        
        List<model.Trang> ListT = qlsp.GetTrang(Trang);
        List<KhachHang> lst_kh = qlkh.LayKhachHangTheoTrang(qlsp.PageFocus(Trang, 1));

        model.addAttribute("list_kh", lst_kh);
        model.addAttribute("list_T", ListT);
        
        
        return "ManagerCustomer";
    }
    
    
    @RequestMapping(value = "/SearchAccount",method = RequestMethod.GET)
    public String TimKiemSanPham(Model model, @RequestParam("txtsearch") String txtSearch){
        
        String Trang = "1";
        
        QuanLySanPham qlsp = new QuanLySanPham();
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        
        List<KhachHang> lst_kh = qlkh.TimKiemKhachHang(txtSearch);

        List<model.Trang> ListT = qlsp.GetTrang(Trang);

        model.addAttribute("list_kh", lst_kh);
        model.addAttribute("list_T", ListT);
        
        

        return "ManagerCustomer";
       
        
    }
    
}
