/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.LoaiSanPham;
import model.QuanLyLoaiSanPham;
import model.QuanLySanPham;
import model.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author NguyenBaViet
 */
@Controller
public class CategoryController {
    @RequestMapping(value = "/Category",method = RequestMethod.GET)
    public String LayDanhSachSanPhamTheoLoai (Model model, @RequestParam("MaLoaiSanPham") int MaLoaiSanPham){
     
        QuanLySanPham qlsp = new QuanLySanPham();
        List<SanPham> lst_sptl = qlsp.LaySanPhamTheoLoai(MaLoaiSanPham);
        SanPham spm = qlsp.LaySanPhamMoiNhat();
        
        QuanLyLoaiSanPham qllsp = new QuanLyLoaiSanPham();
        List<LoaiSanPham> lst_lsp = qllsp.getAllLoaiSanPham();
        
        
        
        model.addAttribute("list_sp", lst_sptl);
        model.addAttribute("list_lsp", lst_lsp);
        model.addAttribute("spm", spm);
        model.addAttribute("tag", MaLoaiSanPham);
        
        return "Home";
       
        
    }
}
