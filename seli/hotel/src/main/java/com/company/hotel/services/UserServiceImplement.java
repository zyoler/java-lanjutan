package com.company.hotel.services;

import com.company.hotel.dto.MailResponseDto;
import com.company.hotel.dto.UserDto;
import com.company.hotel.model.User;
import com.company.hotel.repositories.UserRepositori;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Setter
@Getter
@Service
public class UserServiceImplement implements UserService{
    @Autowired
    UserRepositori userRepositori;

    @Autowired
    private JavaMailSender sender;

    @Autowired
    public UserServiceImplement(JavaMailSender mailSender){
        this.sender = mailSender;
    }


    @Override
    public User insertUser(UserDto userDto) {
        User model = new User();
        User result = new User();
        try {
            model.setUsername(userDto.getUsername());
            model.setPassword(userDto.getPassword());
            model.setEmail(userDto.getEmail());
            result = userRepositori.save(model);
        }catch (Exception e){

        }
        return result;
    }

    public MailResponseDto sendEmail(UserDto request){
        MailResponseDto response = new MailResponseDto();
        MimeMessage message = sender.createMimeMessage();

        try{
            //mengeset tipe media

            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(request.getEmail());
            helper.setSubject("Registrasi Akun Berhasil");
            helper.setFrom("selideslia11@gmail.com");
            helper.setText(
                    "<p><i><b>Registrasi "+request.getUsername()+" Berhasil</b></i></p>",true);

            sender.send(message);

            response.setPesan("Email terkirim ke : " + request.getEmail());
            response.setStatus(Boolean.TRUE);
        } catch (MessagingException e) {
            e.printStackTrace();
            response.setPesan("Email gagal dikirim ke : " + request.getEmail());
            response.setStatus(Boolean.FALSE);
        }
        return response;
    }



}
