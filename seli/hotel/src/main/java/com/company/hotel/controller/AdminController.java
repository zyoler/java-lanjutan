package com.company.hotel.controller;

import com.company.hotel.dto.AdminDto;
import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.Admin;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.repositories.AdminRepository;
import com.company.hotel.repositories.PengunjungRepository;
import com.company.hotel.services.AdminService;
import com.company.hotel.services.PengunjungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private AdminService adminService;
    Admin result = null;
    List<Admin> admin = null;
    AdminDto adminDto = new AdminDto();
    SearchDto cari = new SearchDto();

    @GetMapping("/admin")
    public String getAdmin(Model model) throws Exception{
        admin = adminRepository.getAdmin();

        model.addAttribute("Admin", admin);
        model.addAttribute("adminDto",adminDto);
        model.addAttribute("cari",cari);
        return "admin";
    }

    @RequestMapping(value = "/insertAdmin", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        model.addAttribute("adminDto", adminDto);
        return "insertAdmin";
    }

    @RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
    public String InsertAdmin(AdminDto adminDto, ModelMap model ) throws Exception{
        result = adminService.insertAdmin(adminDto);
        return "redirect:/admin";
    }

    @GetMapping("/deleteDataAdmin")
    public String delete(int id){

        adminService.deleteDataAdmin(id);
        return "redirect:/admin";
    }
    @RequestMapping(value = "/updateDataAdmin",method = RequestMethod.GET)
    public String updateDataAdmin(ModelMap model,int id)throws Exception{
        adminDto = adminService.getAdminById(id);

        model.addAttribute("adminDto",adminDto);

        return  "updateAdmin";
    }
    @RequestMapping(value = "/saveUpdateAdmin", method = RequestMethod.POST)
    public String updateDataAdmin(AdminDto adminDto, ModelMap model) throws Exception{
        result = adminService.updateDataAdmin(adminDto);

        return "redirect:/admin";
    }

    @RequestMapping(value="/searchAdmin",method = RequestMethod.POST)
    public String searchAdmin(SearchDto search, ModelMap model)throws Exception{
        admin = adminService.searchAdmin(search);

        model.addAttribute("Admin",admin);
        model.addAttribute("cari",cari);

        return "admin";
    }
}
