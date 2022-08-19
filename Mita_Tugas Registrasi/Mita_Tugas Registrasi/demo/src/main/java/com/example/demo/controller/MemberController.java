package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.dto.SupirDto;
import com.example.demo.models.Member;
import com.example.demo.repositories.MemberRepository;
import com.example.demo.services.MemberService;
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
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    List<Member> member = null;
    MemberDto memberDto = new MemberDto();
    Member result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/berandaMember")
    public String berandaMember(Model model){
        member = memberRepository.getMember();
        model.addAttribute("Member", member);
        model.addAttribute("cari", cari);
        return "berandaMember";
    }

    @RequestMapping(value = "/createMember", method = RequestMethod.GET)
    public String doCreateMember(ModelMap modelMap) throws Exception{
        modelMap.addAttribute("memberDto",memberDto);
        return "createMember";
    }

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/images";

    @RequestMapping(value = "/saveMember", method = RequestMethod.POST)
    public String saveMember(@RequestParam("fileimage") MultipartFile multipartFile, MemberDto memberDto, ModelMap modelMap) throws Exception{
        String filename = memberDto.getId_member()+memberDto.getNama_member() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().length()-4);
        Path filenameAndPath = Paths.get(uploadDirectory,filename);

        try {
            Files.write(filenameAndPath, multipartFile.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
        memberDto.setFoto_member(filename);
        result = memberService.insertMember(memberDto);
        return "redirect:/berandaMember";
    }
    @GetMapping(value="/detailMember")
    public String detailMember(ModelMap modelMap,int id) {
        memberDto = memberService.getMemberById(id);
        modelMap.addAttribute("memberDto", memberDto);
        return "detailMember";
    }
    @GetMapping(value = "/deleteMember")
    public String deleteMember(int id){
        memberService.deleteMember(id);
        return "redirect:/berandaMember";
    }

    @RequestMapping(value = "/updateMember", method = RequestMethod.GET)
    public String updateMember(ModelMap modelMap, int id) throws Exception{
        memberDto = memberService.getMemberById(id);
        modelMap.addAttribute("memberDto",memberDto);
        return "updateMember";
    }

    @RequestMapping(value = "/saveUpdateMember")
    public String updateMember(MemberDto memberDto) throws  Exception{
        result = memberService.updateMember(memberDto);
        return "redirect:/berandaMember";
    }

    @RequestMapping(value="/searchMember", method = RequestMethod.POST)
    public String searchMember(SearchDto search, ModelMap model) throws Exception{
        member = memberService.searchMember(search);

        model.addAttribute("Member",member);
        model.addAttribute("cari",cari);

        return "berandaMember";
    }
}
