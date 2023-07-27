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
import model.QuanLySanPham;
import model.QuanLyLoaiSanPham;
import model.SanPham;
import model.LoaiSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author pmtu
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/Home",method = RequestMethod.GET)
    public String LayDanhSachSanPham(Model model){
     
        QuanLySanPham qlsp = new QuanLySanPham();
        List<SanPham> lst_sp = qlsp.getAllSanPham();
        SanPham spm = qlsp.LaySanPhamMoiNhat();
        
        QuanLyLoaiSanPham qllsp = new QuanLyLoaiSanPham();
        List<LoaiSanPham> lst_lsp = qllsp.getAllLoaiSanPham();
        
        
        model.addAttribute("list_sp", lst_sp);
        model.addAttribute("list_lsp", lst_lsp);
        model.addAttribute("spm", spm);
        
        return "Home";
       
        
    }
}
