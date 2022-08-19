package com.example.demo.controllers;

import com.example.demo.Dto.MahasiswaDto;
import com.example.demo.Dto.SearchDto;
import com.example.demo.Model.Mahasiswa;
import com.example.demo.Repositories.MahasiswaRepository;
import com.example.demo.Service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
//@RestController
//@RequestMapping("/API/Mahasiswa")

@Controller
public class MahasiswaController {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    private MahasiswaService mahasiswaService;

    List<Mahasiswa> mahasiswa = null;
    MahasiswaDto mahasiswaDto = new MahasiswaDto();
    Mahasiswa result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/getMahasiswa")
    public String getMahasiswa(Model model) throws Exception{
        mahasiswa = mahasiswaRepository.getMahasiswa();

        model.addAttribute("Mahasiswa", mahasiswa);
        model.addAttribute("MhsDto",mahasiswaDto);

        model.addAttribute("cari", cari);
//        model.addAttribute("title", "prlatihan java");

        return "mahasiswa"; // view
    }

    @RequestMapping(value = "/InsertMahasiswa", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{

        model.addAttribute("mhsDto", mahasiswaDto);

        return "insert";
    }

    @RequestMapping(value = "/saveMahasiswa", method = RequestMethod.POST)
    public String InsertMahasiswa(MahasiswaDto mhsDto, ModelMap model) throws Exception{
        result = mahasiswaService.insertDosen(mhsDto);

        return "redirect:/getMahasiswa";
    }

    @RequestMapping(value = "/updateMahasiswa", method = RequestMethod.GET)
    public String updateMahasiswa(ModelMap model, int id) throws Exception{
        mahasiswaDto = mahasiswaService.getMahasiswaById(id);
        model.addAttribute("mhsDto", mahasiswaDto);
        return "update";
    }

    @RequestMapping(value = "/saveUpdateMahasiswa", method = RequestMethod.POST)
    public String updateMahasiswa(MahasiswaDto mhsDto) throws Exception{
        result = mahasiswaService.updateMahasiswa(mhsDto);
        return "redirect:/getMahasiswa";
    }

    @GetMapping("/deleteDataMahasiswa")
    public String delete(int id){
        mahasiswaService.deleteMahasiswa(id);
        return "redirect:/getMahasiswa";
    }

    @RequestMapping(value = "/searchMahasiswa", method = RequestMethod.POST)
    public  String searchMahasiswa(SearchDto search, ModelMap model) throws Exception{
        mahasiswa = mahasiswaService.searchMahasiswa(search);

        model.addAttribute("Mahasiswa", mahasiswa);
        model.addAttribute("cari", cari);

        return "mahasiswa";
    }

    @GetMapping("/GetAllMahasiswa")
    public List<Mahasiswa> getAllMahasiswa(){
        return mahasiswaRepository.findAll();
    }

    @PostMapping("/CreateMahasiswa")
    public Mahasiswa createmahasiswa(@RequestBody Mahasiswa mahasiswa){
        return mahasiswaRepository.save(mahasiswa);
    }
}
