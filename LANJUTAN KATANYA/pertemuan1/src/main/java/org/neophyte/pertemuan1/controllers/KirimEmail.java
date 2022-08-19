package org.neophyte.pertemuan1.controllers;



import org.neophyte.pertemuan1.dto.MailRequestDto;
import org.neophyte.pertemuan1.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class KirimEmail {

    @Autowired
    private EmailService emailServices;;
    MailRequestDto mailRequestDto = new MailRequestDto();


    @RequestMapping(value = "/Email", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{

        model.addAttribute("mailRequestDto",mailRequestDto);

        return "kirimEmail";
    }

    @RequestMapping(value = "/saveEmail", method = RequestMethod.POST)
    public String kirimEmail(MailRequestDto requestDto){
        emailServices.sendEmail(requestDto);
        return "redirect:/Email";
    }


}
