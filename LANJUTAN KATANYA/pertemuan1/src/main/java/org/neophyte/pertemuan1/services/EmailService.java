package org.neophyte.pertemuan1.services;

import org.neophyte.pertemuan1.dto.MailResponseDto;
import org.neophyte.pertemuan1.dto.MailRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;

    @Autowired
    public EmailService(JavaMailSender mailSender){
        this.sender = mailSender;
    }

    public MailResponseDto sendEmail(MailRequestDto request){
        MailResponseDto response = new MailResponseDto();
        MimeMessage message = sender.createMimeMessage();

        try{
            //mengeset tipe media

            MimeMessageHelper helper = new MimeMessageHelper(message);
            String nama = request.getNama();
            String nim = request.getNim();
            String jk = request.getJenis_kelamin();
            helper.setTo(request.getTo());
            helper.setFrom("mitairuz1210@gmail.com");
            helper.setText(
                    "<p><i><b>Nama  :"+request.getNama()+"</b></i></p>"+"<p><i><b>NIM :"+request.getNim()+"</b></i></p>"+"<p><i><b>Jenis Kelamin :"+request.getJenis_kelamin()+"</b></i></p>",true);

            sender.send(message);

            response.setPesan("Email terkirim ke : " + request.getTo());
            response.setStatus(Boolean.TRUE);
        } catch (MessagingException e) {
            e.printStackTrace();
            response.setPesan("Email gagal dikirim ke : " + request.getTo());
            response.setStatus(Boolean.FALSE);
        }
        return response;
    }

}
