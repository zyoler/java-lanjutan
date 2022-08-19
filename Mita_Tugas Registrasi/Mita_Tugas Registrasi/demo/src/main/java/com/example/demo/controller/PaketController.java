package com.example.demo.controller;

import com.example.demo.dto.SearchDto;
import com.example.demo.dto.PaketDto;
import com.example.demo.models.Paket;
import com.example.demo.repositories.PaketRepository;
import com.example.demo.services.PaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PaketController {
    @Autowired
    private PaketRepository paketRepository;

    @Autowired
    private PaketService paketService;

    List<Paket> paket = null;
    PaketDto paketDto = new PaketDto();
    Paket result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/berandaPaket")
    public String berandaPaket(Model model){
        paket = paketRepository.getPaket();
        model.addAttribute("Paket",paket);
        model.addAttribute("cari", cari);
        return "berandaPaket";
    }

    @RequestMapping(value = "/createPaket", method = RequestMethod.GET)
    public String doCreatePaket(ModelMap modelMap) throws Exception{
        modelMap.addAttribute("paketDto",paketDto);
        return "createPaket";
    }

    @RequestMapping(value = "/savePaket", method = RequestMethod.POST)
    public String savePaket(PaketDto paketDto, ModelMap modelMap) throws Exception{
        result = paketService.insertPaket(paketDto);
        return "redirect:/berandaPaket";
    }

    @GetMapping(value = "/deletePaket")
    public String deletePaket(int id){
        paketService.deletePaket(id);
        return "redirect:/berandaPaket";
    }
    @RequestMapping(value = "/updatePaket", method = RequestMethod.GET)
    public String updatePaket(ModelMap modelMap, int id) throws Exception{
        paketDto = paketService.getPaketById(id);
        modelMap.addAttribute("paketDto",paketDto);
        return "updatePaket";
    }

    @RequestMapping(value = "/saveUpdatePaket")
    public String updatePaket(PaketDto paketDto) throws  Exception{
        result = paketService.updatePaket(paketDto);
        return "redirect:/berandaPaket";
    }

    @RequestMapping(value="/searchPaket", method = RequestMethod.POST)
    public String searchPaket(SearchDto search, ModelMap model) throws Exception{
        paket = paketService.searchPaket(search);

        model.addAttribute("Paket",paket);
        model.addAttribute("cari",cari);

        return "berandaPaket";
    }
}
