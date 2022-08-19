package com.example.demo.controller;

import com.example.demo.dto.MobilDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Mobil;
import com.example.demo.repositories.MobilRepository;
import com.example.demo.services.MobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class MobilController {
    @Autowired
    private MobilRepository mobilRepository;

    @Autowired
    private MobilService mobilService;

    List<Mobil> mobil = null;
    MobilDto mobilDto = new MobilDto();
    Mobil result = null;
    SearchDto cari = new SearchDto();


    @GetMapping("/berandaMobil")
    public String berandaMobil(Model model){
        mobil = mobilRepository.getMobil();
        model.addAttribute("Mobil",mobil);
        model.addAttribute("cari", cari);
        return "berandaMobil";
    }


    @RequestMapping(value = "/createMobil", method = RequestMethod.GET)
    public String doCreateMobil(ModelMap modelMap) throws Exception{
        modelMap.addAttribute("mobilDto",mobilDto);
        return "createMobil";
    }
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/images";

    @RequestMapping(value = "/saveMobil", method = RequestMethod.POST)
    public String saveMobil(@RequestParam("fileimage") MultipartFile multipartFile, MobilDto mobilDto, ModelMap modelMap) throws Exception{
        String filename = mobilDto.getId_mobil()+mobilDto.getNama_mobil() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().length()-4);
        Path filenameAndPath = Paths.get(uploadDirectory,filename);

        try {
            Files.write(filenameAndPath, multipartFile.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
        mobilDto.setFoto_mobil(filename);

        result = mobilService.insertMobil(mobilDto);
        return "redirect:/berandaMobil";
    }

    @GetMapping(value = "/deleteMobil")
    public String deleteMobil(int id){
        mobilService.deleteMobil(id);
        return "redirect:/berandaMobil";
    }
    @RequestMapping(value = "/updateMobil", method = RequestMethod.GET)
    public String updateMobil(ModelMap modelMap, int id) throws Exception{
        mobilDto = mobilService.getMobilById(id);
        modelMap.addAttribute("mobilDto",mobilDto);
        return "updateMobil";
    }

    @GetMapping(value="/detailMobil")
    public String detailMobil(ModelMap modelMap,int id){
        mobilDto = mobilService.getMobilById(id);
        modelMap.addAttribute("mobilDto",mobilDto);
        return "detailMobil";
    }

    @RequestMapping(value = "/saveUpdateMobil")
    public String updateMobil(MobilDto mobilDto) throws  Exception{
        result = mobilService.updateMobil(mobilDto);
        return "redirect:/berandaMobil";
    }

    @RequestMapping(value="/searchMobil", method = RequestMethod.POST)
    public String searchMobil(SearchDto search, ModelMap model) throws Exception{
        mobil = mobilService.searchMobil(search);

        model.addAttribute("Mobil",mobil);
        model.addAttribute("cari",cari);

        return "berandaMobil";
    }
}

