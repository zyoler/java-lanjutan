package com.example.demo.controller;

import com.example.demo.dto.MahasiswaDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Mahasiswa;
import com.example.demo.repositories.MahasiswaRepository;
import com.example.demo.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BerandaController {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    private MahasiswaService mahasiswaService;

    List<Mahasiswa> mahasiswa = null;
    MahasiswaDto mahasiswaDto = new MahasiswaDto();
    Mahasiswa result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/beranda")
    public String beranda(Model model) {
        mahasiswa = mahasiswaRepository.getMahasiswa();

        model.addAttribute("Mahasiswa", mahasiswa);
        model.addAttribute("MhsDto", mahasiswaDto);
        model.addAttribute("cari", cari);

        return "beranda";
    }

    @RequestMapping(value = "/createMahasiswa", method = RequestMethod.GET)
    public String doCreateData(ModelMap model) throws Exception{
        model.addAttribute("mhsDto",mahasiswaDto);
        return "create";
    }

    @RequestMapping (value = "/saveMahasiswa", method = RequestMethod.POST)
    public String InsertMahasiswa(MahasiswaDto mhsDto, ModelMap model) throws Exception{
        result = mahasiswaService.insertMahasiswa(mhsDto);
        return "redirect:/beranda";
    }

    @RequestMapping (value = "/updateMahasiswa", method = RequestMethod.GET)
    public String updateMahasiswa(ModelMap model, int id) throws Exception{
        mahasiswaDto=mahasiswaService.getMahasiswaById(id);
        model.addAttribute("mhsDto",mahasiswaDto);
        return "update";
    }

    @RequestMapping (value = "/saveUpdateMahasiswa", method = RequestMethod.POST)
    public String updateMahasiswa(MahasiswaDto mhsDto) throws Exception{
        result = mahasiswaService.updateMahasiswa(mhsDto);
        return "redirect:/beranda";
    }

    @GetMapping(value = "/deleteMahasiswa")
    public String delete(int id){
        mahasiswaService.deleteMahasiswa(id);

        return "redirect:/beranda";
    }

    @RequestMapping(value = "/searchMahasiswa", method = RequestMethod.POST)
    public String searchMahasiswa(SearchDto search, ModelMap model) throws Exception{
        mahasiswa = mahasiswaService.searchMahasiswa(search);

        model.addAttribute("Mahasiswa", mahasiswa);
        model.addAttribute("cari", cari);

        return "beranda";
    }
}
