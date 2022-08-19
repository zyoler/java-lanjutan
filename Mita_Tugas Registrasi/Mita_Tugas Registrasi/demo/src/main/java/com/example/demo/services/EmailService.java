package com.example.demo.services;

import com.example.demo.dto.AnggotaDto;
import com.example.demo.dto.MallRequest;
import com.example.demo.dto.MallResponse;
import com.example.demo.models.Anggota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;

    @Autowired
    public EmailService(JavaMailSender mailSender){
        this.sender = mailSender;
    }

    public MallResponse sendEmail(Anggota request){
        MallResponse response = new MallResponse();
        MimeMessage message = sender.createMimeMessage();

//        LocalDateTime now = LocalDateTime.now();
//        String skrg = now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL.withLocale(new Locale())));
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo("mitairuz@gmail.com");
            helper.setSubject("Login Admin");
            helper.setFrom("mitairuz1210@gmail.com");
            helper.setText("<div><b>"+ request.getUsername()+"</b> telah melakukan login!", true);

            sender.send(message);

            response.setPesan("Email terkirim ke : " + request.getEmail());
            response.setStatus(Boolean.TRUE);

        }catch (Exception e){
            e.printStackTrace();
            response.setPesan("Email gagal dikirim ke : " + request.getEmail());
            response.setStatus(Boolean.FALSE);
        }
        return response;
    }
}
