/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.core.Request;
import java.util.List;

@Controller
public class SalesCalendarController {

    @RequestMapping(value = "/SalesCalendar",method = RequestMethod.GET)
    public String LayThongTinTaiKhoan(Model model){

        List<Integer> list_Month = new ArrayList();

        QuanLyHoaDon qlhd = new QuanLyHoaDon();


        for (int i = 1; i < 13; ++i)
        {
            list_Month.add(i);
        }

        List<HoaDon> lst_year = qlhd.LayDanhSachNam();
        model.addAttribute("lst_year", lst_year);

        model.addAttribute("List_lsp", list_Month);

        return "SalesCalendar";
    }


    @RequestMapping(value = "/ViewCalendar",method = RequestMethod.GET)
    public String Them_Tk_PT(Model model, @RequestParam("month") int Month, @RequestParam("year") int Year){

        QuanLyHoaDon qlhd = new QuanLyHoaDon();

        List<HoaDon> lst_hd = qlhd.LayDanhSachHoaDonTheoThang(Month, Year);

        List<HoaDon> lst_year = qlhd.LayDanhSachNam();
        model.addAttribute("lst_year", lst_year);

        List<Integer> list_Month = new ArrayList();

        for (int i = 1; i < 13; ++i)
        {
            list_Month.add(i);
        }


        model.addAttribute("List_lsp", list_Month);

        model.addAttribute("lst_hd", lst_hd);

        return "SalesCalendar";
    }
}
