package com.company.hotel.services;

import com.company.hotel.dto.MailResponseDto;
import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.dto.UserDto;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.repositories.PengunjungRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Setter
@Getter
@Service
public class PengunjungServiceImplement implements PengunjungService{

    @Autowired
    PengunjungRepository pengunjungRepository;

    @Autowired
    private JavaMailSender sender;

    @Override
    public PengunjungDto getPengunjungById(int id) {
        Pengunjung model = pengunjungRepository.getById(id);
        PengunjungDto dto = new PengunjungDto();

        dto.setId(model.getId());
        dto.setNo_ktp(model.getNo_ktp());
        dto.setNama_pengunjung(model.getNama_pengunjung());
        dto.setJenis_kelamin(model.getJenis_kelamin());
        dto.setAlamat(model.getAlamat());
        dto.setEmail(model.getEmail());
        dto.setNo_hp(model.getNo_hp());
        return dto;
    }

    @Override
    public Pengunjung insertPengunjung(PengunjungDto pengunjungDto) {
        Pengunjung model = new Pengunjung();
        Pengunjung result = new Pengunjung();
        try {
            model.setNo_ktp(pengunjungDto.getNo_ktp());
            model.setNama_pengunjung(pengunjungDto.getNama_pengunjung());
            model.setJenis_kelamin(pengunjungDto.getJenis_kelamin());
            model.setAlamat(pengunjungDto.getAlamat());
            model.setNo_hp(pengunjungDto.getNo_hp());
            model.setEmail(pengunjungDto.getEmail());
            result = pengunjungRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public Pengunjung insertCheckInUser(PengunjungDto pengunjungDto) {
        Pengunjung model = new Pengunjung();
        Pengunjung result = new Pengunjung();
        try {
            model.setNo_ktp(pengunjungDto.getNo_ktp());
            model.setNama_pengunjung(pengunjungDto.getNama_pengunjung());
            model.setJenis_kelamin(pengunjungDto.getJenis_kelamin());
            model.setAlamat(pengunjungDto.getAlamat());
            model.setNo_hp(pengunjungDto.getNo_hp());
            model.setEmail(pengunjungDto.getEmail());
            result = pengunjungRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }


    @Override
    public boolean deleteDataPengunjung(int id) {
        Pengunjung model = pengunjungRepository.getById(id);
        pengunjungRepository.delete(model);
        return true;
    }

    @Override
    public Pengunjung updateDataPengunjung(PengunjungDto pengunjungDto) {
        Pengunjung model = new Pengunjung();
        Pengunjung result = new Pengunjung();
        try {
            model.setId(pengunjungDto.getId());
            model.setNo_ktp(pengunjungDto.getNo_ktp());
            model.setNama_pengunjung(pengunjungDto.getNama_pengunjung());
            model.setJenis_kelamin(pengunjungDto.getJenis_kelamin());
            model.setAlamat(pengunjungDto.getAlamat());
            model.setNo_hp(pengunjungDto.getNo_hp());
            model.setEmail(pengunjungDto.getEmail());
            result = pengunjungRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<Pengunjung> searchPengunjung(SearchDto searchDto) {
        List<Pengunjung> listData = pengunjungRepository.getPengunjung(searchDto.getCari());
        return listData;
    }


    public MailResponseDto sendEmail(PengunjungDto pengunjungDto){
        MailResponseDto response = new MailResponseDto();
        MimeMessage message = sender.createMimeMessage();

        try{
            //mengeset tipe media

            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(pengunjungDto.getEmail());
            helper.setSubject("CheckIn Berhasil");
            helper.setFrom("selideslia11@gmail.com");
            helper.setText(
                    "<p><i><b>Terimakasih anda telah CheckIn di Hotel Kami</b></i></p>",true);

            sender.send(message);

            response.setPesan("Email terkirim ke : " + pengunjungDto.getEmail());
            response.setStatus(Boolean.TRUE);
        } catch (MessagingException e) {
            e.printStackTrace();
            response.setPesan("Email gagal dikirim ke : " + pengunjungDto.getEmail());
            response.setStatus(Boolean.FALSE);
        }
        return response;
    }

}
