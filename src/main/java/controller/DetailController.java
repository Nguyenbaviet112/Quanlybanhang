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
public class DetailController {
    @RequestMapping(value = "/Detail",method = RequestMethod.GET)
    public String LayChiTietSanPham (Model model, @RequestParam("MaSanPham") String MaSanPham){
     
        QuanLySanPham qlsp = new QuanLySanPham();
        SanPham ctsp = qlsp.LayChiTietSanPham(MaSanPham);
        SanPham spm = qlsp.LaySanPhamMoiNhat();
        
        QuanLyLoaiSanPham qllsp = new QuanLyLoaiSanPham();
        List<LoaiSanPham> lst_lsp = qllsp.getAllLoaiSanPham();
        
        
        
        model.addAttribute("ctsp", ctsp);
        model.addAttribute("list_lsp", lst_lsp);
        model.addAttribute("spm", spm);
        model.addAttribute("tag", MaSanPham);
        
        
        return "Detail";
    }
}
