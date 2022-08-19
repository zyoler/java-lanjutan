package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.models.*;
import com.example.demo.repositories.PeminjamanRepository;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class PeminjamanController {
    @Autowired
    private PeminjamanRepository peminjamanRepository;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MobilService mobilService;
    @Autowired
    private SupirService supirService;
    @Autowired
    private PaketService paketService;
    @Autowired
    private PeminjamanService peminjamanService;
    List<Peminjaman> peminjaman = null;
    PeminjamanDto peminjamanDto = new PeminjamanDto();
    MemberDto memberDto= new MemberDto();
    MobilDto mobilDto= new MobilDto();
    SupirDto supirDto=new SupirDto();
    PaketDto paketDto=new PaketDto();
    Peminjaman result = null;
    SearchDto cari = new SearchDto();


    @GetMapping("/dataPeminjaman")
    public String dataPeminjaman(Model model){
        peminjaman = peminjamanRepository.getPeminjaman();
        model.addAttribute("Peminjaman",peminjaman);
        model.addAttribute("cari", cari);
        return "dataPeminjaman";
    }

    @RequestMapping(value = "/createPeminjaman", method = RequestMethod.GET)
    public String doCreatePeminjaman(ModelMap modelMap) throws Exception{
        peminjamanDto= new PeminjamanDto();

        List<Mobil> mobil = peminjamanRepository.getMobil();
        List<Member> member = peminjamanRepository.getMember();
        List<Paket> paket = peminjamanRepository.getPaket();
        List<Supir> supir = peminjamanRepository.getSupir();

        modelMap.addAttribute("Mobil", mobil);
        modelMap.addAttribute("Member",member);
        modelMap.addAttribute("Supir",supir);
        modelMap.addAttribute("Paket",paket);
        modelMap.addAttribute("peminjamanDto",peminjamanDto);
        return "createPeminjaman";
    }

    @RequestMapping(value = "/savePeminjaman", method = RequestMethod.POST)
    public String savePeminjaman(PeminjamanDto peminjamanDto, ModelMap modelMap) throws Exception{

        memberDto = memberService.getMemberById(peminjamanDto.getId_member());
        mobilDto = mobilService.getMobilById(peminjamanDto.getId_mobil());
        supirDto = supirService.getSupirById(peminjamanDto.getId_supir());
        peminjamanDto.setNama_member(memberDto.getNama_member());
        peminjamanDto.setNo_telp(memberDto.getNo_telpon());
        peminjamanDto.setAlamat(memberDto.getAlamat());
        peminjamanDto.setNama_mobil(mobilDto.getNama_mobil());
        peminjamanDto.setNama_supir(supirDto.getNama_supir());
        int total = (supirDto.getHarga_perhari()*peminjamanDto.getLama())+mobilDto.getHarga()-paketDto.getDiskon();
        peminjamanDto.setTotal(total);
        int uangMk=total/100*20;
        peminjamanDto.setUang_muka(uangMk);

        result = peminjamanService.insertPeminjaman(peminjamanDto);
        return "redirect:/dataPeminjaman";
    }


    @RequestMapping(value = "/updatePeminjaman", method = RequestMethod.GET)
    public String updatepeminjaman(ModelMap modelMap, int id) throws Exception{
        peminjamanDto = peminjamanService.getPeminjamanById(id);
        modelMap.addAttribute("peminjamanDto",peminjamanDto);
        return "updatePeminjaman";
    }

    @GetMapping(value="/detailPeminjaman")
    public String detailpeminjaman(ModelMap modelMap,int id){
        peminjamanDto = peminjamanService.getPeminjamanById(id);
        modelMap.addAttribute("peminjamanDto",peminjamanDto);
        return "detailPeminjaman";
    }

    @RequestMapping(value = "/saveUpdatePeminjaman")
    public String updatePeminjaman(PeminjamanDto peminjamanDto) throws  Exception{
        result = peminjamanService.updatePeminjaman(peminjamanDto);
        return "redirect:/dataPeminjaman";
    }

    @RequestMapping(value="/searchPeminjaman", method = RequestMethod.POST)
    public String searchPeminjaman(SearchDto search, ModelMap model) throws Exception{
        peminjaman = peminjamanService.searchPeminjaman(search);

        model.addAttribute("Peminjaman",peminjaman);
        model.addAttribute("cari",cari);

        return "dataPeminjaman";
    }
}
