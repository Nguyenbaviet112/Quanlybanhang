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
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CartItem;
import model.QuanLyGioHang;
import model.User;
import model.UserDAO;
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

public class LoginController {


    public static int MaTaiKhoanDangKetNoi= -1;
    @RequestMapping(value = "/login")
    public ModelAndView login(){
        
        return new ModelAndView("Login");
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("user") String user, @RequestParam("pass") String pass,HttpServletRequest request, Model model){
        
        UserDAO data = new UserDAO();
         ModelAndView modelAndView = new ModelAndView();
        //tim user trong db
        User userr = data.FindUser(user, pass);
        String mess = "Wrong user or pass";
        MaTaiKhoanDangKetNoi = userr.getMaAC();
        if(userr==null) {
            //khong co bao loi
           
           return new ModelAndView("Login","mess",mess);
        }
        else
        {
            // la nguoi dung va tro ve trang home
                
           HttpSession session  = request.getSession();
           session.setAttribute("user", userr);
//           modelAndView.addObject("user",userr.getTendangnhap());
//           modelAndView.setViewName("Home");
        QuanLySanPham qlsp = new QuanLySanPham();
        List<SanPham> lst_sp = qlsp.getAllSanPham();
        SanPham spm = qlsp.LaySanPhamMoiNhat();
        
        QuanLyLoaiSanPham qllsp = new QuanLyLoaiSanPham();
        List<LoaiSanPham> lst_lsp = qllsp.getAllLoaiSanPham();
        
        
        model.addAttribute("list_sp", lst_sp);
        model.addAttribute("list_lsp", lst_lsp);
        model.addAttribute("spm", spm);
           return new ModelAndView("Home");
             
        }
      
        
        //return new ModelAndView("Login");
       
    }
    
     @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ModelAndView signup(@RequestParam("user") String user, @RequestParam("pass") String pass,@RequestParam("repass") String repass){
         UserDAO data = new UserDAO();
         String mess = "sign up failed";
//         return new ModelAndView("hello","ten",repass);
         
         if (pass.equals(repass)) {
//              return new ModelAndView("hello","ten",repass);
             if (!data.CheckUser(user)) {
                 //dang nhap thanh cong
                 data.AddUser(user, pass);
                  return new ModelAndView("Home");
             }
             else{
                 // tai khoan bi trung
                  return new ModelAndView("Login","mess",mess);
             }
         }
         else{
             // mat khau khong trung  nhau
             
              return new ModelAndView("Login","mess",mess);
         }
        //return new ModelAndView("hello");
    }
    
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        
        QuanLySanPham qlsp = new QuanLySanPham();
        List<SanPham> lst_sp = qlsp.getAllSanPham();
        SanPham spm = qlsp.LaySanPhamMoiNhat();
        
        QuanLyLoaiSanPham qllsp = new QuanLyLoaiSanPham();
        List<LoaiSanPham> lst_lsp = qllsp.getAllLoaiSanPham();
        
        QuanLyGioHang qlgh = new QuanLyGioHang();
        Map<String, CartItem> map = qlgh.map1;
        
        if (map != null)
        {
            map.clear();
        }
        
        model.addAttribute("list_sp", lst_sp);
        model.addAttribute("list_lsp", lst_lsp);
        model.addAttribute("spm", spm);

        return new ModelAndView("Home");
    }
    

    
     @RequestMapping(value = "/admin")
    public ModelAndView admin(){
        
        return new ModelAndView("ManagerProduct");
    }

    
}
