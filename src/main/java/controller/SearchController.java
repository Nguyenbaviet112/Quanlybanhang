/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


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
 * @author NguyenBaViet
 */
@Controller
public class SearchController {
    @RequestMapping(value = "/Search",method = RequestMethod.GET)
    public String TimKiemSanPham(Model model, @RequestParam("txtsearch") String txtSearch){
        
        QuanLySanPham qlsp = new QuanLySanPham();
        SanPham spm = qlsp.LaySanPhamMoiNhat();
        List<SanPham> lst = qlsp.TimKiemSanPham(txtSearch);

        QuanLyLoaiSanPham qllsp = new QuanLyLoaiSanPham();
        List<LoaiSanPham> lst_lsp = qllsp.getAllLoaiSanPham();
        
        
        
        model.addAttribute("list_sp", lst);
        model.addAttribute("list_lsp", lst_lsp);
        model.addAttribute("spm", spm);
        return "Home";
       
        
    }
    
    
    @RequestMapping(value = "/SearchSP",method = RequestMethod.GET)
    public String TimKiemSanPhamManger(Model model, @RequestParam("txtsearch") String txtSearch){
        
        String Trang = "1";
        QuanLySanPham qlsp = new QuanLySanPham();
        List<SanPham> lst = qlsp.TimKiemSanPham(txtSearch);

        QuanLyLoaiSanPham qllsp = new QuanLyLoaiSanPham();
        List<LoaiSanPham> lst_lsp = qllsp.getAllLoaiSanPham();
        
        
        
        List<model.Trang> ListT = qlsp.GetTrang(Trang);

        
        
        model.addAttribute("list_sp", lst);
        model.addAttribute("list_T", ListT);
        model.addAttribute("List_lsp", lst_lsp);
        
        return "ManagerProduct";
       
        
    }
    
}
