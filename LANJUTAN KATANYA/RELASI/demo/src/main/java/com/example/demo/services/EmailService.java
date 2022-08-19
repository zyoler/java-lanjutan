package com.example.demo.services;

import com.example.demo.dto.MailRequest;
import com.example.demo.dto.MailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;

    @Autowired
    public EmailService(JavaMailSender mailSender){
        this.sender=mailSender;
    }
    public MailResponse sendEmail(MailRequest request){
        MailResponse response = new MailRequest();
        MineMassage massage = sender.createMineMassage();

        try {
            MineMessageHelper helper = new MineMassageHelper(massage);

            helper.setTo(request.getTo());
            helper.setText(request.getText());
            helper.setSubject(request.getSubject());
            helper.setFrom(request.getFrom());
            sender.send(message);

            response.setPesan("Email Terkirim ke  : "+ request.getTo());
            response.setStatus(Boolean.TRUE);

        }catch(Exception e){
            e.printStackTrace();
            response.setPesan("Email Gagal dikirim ke : "+request.getTo());
            response.setStatus(Boolean.FALSE);
        }
        return response;
    }
}
