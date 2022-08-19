package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.MobilDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.dto.SupirDto;
import com.example.demo.models.Supir;
import com.example.demo.repositories.SupirRepository;
import com.example.demo.services.SupirService;
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
public class SupirController {
    @Autowired
    private SupirRepository supirRepository;

    @Autowired
    private SupirService supirService;

    List<Supir> supir = null;
    SupirDto supirDto = new SupirDto();
    Supir result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/berandaSupir")
    public String berandaSupir(Model model){
        supir = supirRepository.getSupir();
        model.addAttribute("Supir",supir);
        model.addAttribute("cari", cari);
        return "berandaSupir";
    }

    @RequestMapping(value = "/createSupir", method = RequestMethod.GET)
    public String doCreateSupir(ModelMap modelMap) throws Exception{
        modelMap.addAttribute("supirDto",supirDto);
        return "createSupir";
    }

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/images";

    @RequestMapping(value = "/saveSupir", method = RequestMethod.POST)
    public String saveSupir(@RequestParam("fileimage") MultipartFile multipartFile, SupirDto supirDto, ModelMap modelMap) throws Exception{
        String filename = supirDto.getId_supir()+supirDto.getNama_supir() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().length()-4);
        Path filenameAndPath = Paths.get(uploadDirectory,filename);

        try {
            Files.write(filenameAndPath, multipartFile.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
        supirDto.setFoto_supir(filename);

        result = supirService.insertSupir(supirDto);
        return "redirect:/berandaSupir";
    }
    @GetMapping(value="/detailSupir")
    public String detailSupir(ModelMap modelMap,int id) {
        supirDto = supirService.getSupirById(id);
        modelMap.addAttribute("supirDto", supirDto);
        return "detailSupir";
    }
    @GetMapping(value = "/deleteSupir")
    public String deleteSupir(int id){
        supirService.deleteSupir(id);
        return "redirect:/berandaSupir";
    }
    @RequestMapping(value = "/updateSupir", method = RequestMethod.GET)
    public String updateSupir(ModelMap modelMap, int id) throws Exception{
        supirDto = supirService.getSupirById(id);
        modelMap.addAttribute("supirDto",supirDto);
        return "updateSupir";
    }

    @RequestMapping(value = "/saveUpdateSupir")
    public String updateSupir(SupirDto supirDto) throws  Exception{
        result = supirService.updateSupir(supirDto);
        return "redirect:/berandaSupir";
    }

    @RequestMapping(value="/searchSupir", method = RequestMethod.POST)
    public String searchSupir(SearchDto search, ModelMap model) throws Exception{
        supir = supirService.searchSupir(search);

        model.addAttribute("Supir",supir);
        model.addAttribute("cari",cari);

        return "berandaSupir";
    }
}
