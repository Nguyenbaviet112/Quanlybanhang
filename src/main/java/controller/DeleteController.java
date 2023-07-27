/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import java.util.List;
import model.*;
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
public class DeleteController {
    @RequestMapping(value = "/Delete",method = RequestMethod.GET)
    public String LayDanhSachSanPham(Model model , @RequestParam("MaSanPham") int MaSanPham)
    {
        String Trang = "1";
        
        
        QuanLySanPham qlsp = new QuanLySanPham();
        qlsp.XoaSanPham(MaSanPham);
        
        List<model.Trang> ListT = qlsp.GetTrang(Trang);
        List<SanPham> lst_sp = qlsp.getSanPhamTheoTrang(qlsp.PageFocus(Trang, 1));
        List<LoaiSanPham> lst_lsp = qlsp.getAllLoaiSanPham();
        model.addAttribute("list_sp", lst_sp);
        model.addAttribute("list_T", ListT);
        model.addAttribute("List_lsp", lst_lsp);
        
        
        return "ManagerProduct";
    }
}
