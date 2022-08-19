package org.neophyte.pertemuan1.controllers;

import org.neophyte.pertemuan1.Repositories.MahasiswaRepository;
import org.neophyte.pertemuan1.dto.MahasiswaDto;
import org.neophyte.pertemuan1.dto.SearchDto;
import org.neophyte.pertemuan1.model.Mahasiswa;
import org.neophyte.pertemuan1.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class MahasiswaController {


//    @Autowired
//    MahasiswaRepository mahasiswaRefository;
//
//    List<Mahasiswa> mahasiswa = null;
//
//
//    @GetMapping("/GetAllMahasiswa")
//    public List<Mahasiswa> getAllMahasiswa(){
//        return mahasiswaRefository.findAll();
//    }
//
//    @PostMapping("/CreateMahasiswa")
//    public Mahasiswa createmahasiswa(@RequestBody Mahasiswa mahasiswa){
//        return mahasiswaRefository.save(mahasiswa);
//    }
    @Autowired
MahasiswaRepository mahasiswaRefository;

    @Autowired
    private  MahasiswaService mahasiswaService;
    Mahasiswa result = null;
    List<Mahasiswa> mahasiswa = null;
    MahasiswaDto mahasiswaDto = new MahasiswaDto();
    SearchDto cari = new SearchDto();

    @GetMapping("/getMahasiswa")
    public String getMahasiswa(Model model) throws Exception{
        mahasiswa = mahasiswaRefository.getMahasiswa();

        model.addAttribute("Mahasiswa", mahasiswa);
        model.addAttribute("MhsDto",mahasiswaDto);
         model.addAttribute("cari",cari);
        return "Mahasiswa";
    }
    @RequestMapping(value = "/InsertMahasiswa", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        model.addAttribute("mhsDto", mahasiswaDto);
        return "Insert";
    }

    @RequestMapping(value = "/saveMahasiswa", method = RequestMethod.POST)
    public String InsertMahasiswa(MahasiswaDto mhsDto, ModelMap model) throws Exception{
        result = mahasiswaService.insertDosen(mhsDto);

        return "redirect:/getMahasiswa";
    }

    @RequestMapping(value = "/updateMahasiswa",method = RequestMethod.GET)
    public String updateMahasiswa(ModelMap model,int id)throws Exception{
        mahasiswaDto = mahasiswaService.getMahasiswaById(id);

        model.addAttribute("mhsDto",mahasiswaDto);

        return  "update";
    }
    @RequestMapping(value = "/saveUpdateMahasiswa", method = RequestMethod.POST)
    public String updateMahasiswa(MahasiswaDto mhsDto, ModelMap model) throws Exception{
        result = mahasiswaService.updateMahasiswa(mhsDto);

        return "redirect:/getMahasiswa";
    }

    @GetMapping("/deleteDataMahasiswa")
    public String delete(int id){

        mahasiswaService.deleteMahasiswa(id);
        return "redirect:/getMahasiswa";
    }

    @RequestMapping(value="/searchMahasiswa",method = RequestMethod.POST)
    public String searchMahasiswa(SearchDto search,ModelMap model)throws Exception{
        mahasiswa = mahasiswaService.searchMahasiswa(search);

        model.addAttribute("Mahasiswa",mahasiswa);
        model.addAttribute("cari",cari);

        return "Mahasiswa";
    }
}
