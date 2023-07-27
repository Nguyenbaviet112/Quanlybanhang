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
import java.util.List;
import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AddController {
    @RequestMapping(value = "/Add",method = RequestMethod.GET)
    public String LayDanhSachSanPham(Model model , @RequestParam("name") String TenSanPham, @RequestParam("image") String HinhURL, @RequestParam("price") double GiaSanPham,
    @RequestParam("title") String MoTa, @RequestParam("DateAdded") String NgayNhap, @RequestParam("category") int MaLoaiSanPham)
    {

        String Trang = "1";
        SanPham sp = new SanPham();
        sp.setTenSanPham(TenSanPham);
        sp.setHinhURL(HinhURL);
        sp.setGiaSanPham(GiaSanPham);
        sp.setMoTa(MoTa);
        sp.setNgayNhap(NgayNhap);
        sp.setMaLoaiSanPham(MaLoaiSanPham);
        
        QuanLySanPham qlsp = new QuanLySanPham();
        qlsp.AddSanpham(sp);
        
        List<model.Trang> ListT = qlsp.GetTrang(Trang);
        List<SanPham> lst_sp = qlsp.getSanPhamTheoTrang(qlsp.PageFocus(Trang, 1));
        List<LoaiSanPham> lst_lsp = qlsp.getAllLoaiSanPham();
        model.addAttribute("list_sp", lst_sp);
        model.addAttribute("list_T", ListT);
        model.addAttribute("List_lsp", lst_lsp);
        
        
        return "ManagerProduct";
    }
}
