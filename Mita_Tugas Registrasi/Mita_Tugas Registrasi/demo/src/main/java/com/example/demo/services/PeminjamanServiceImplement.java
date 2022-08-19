package com.example.demo.services;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.PeminjamanDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Member;
import com.example.demo.models.Peminjaman;
import com.example.demo.repositories.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeminjamanServiceImplement implements PeminjamanService{
    @Autowired
    PeminjamanRepository peminjamanRepository;

    @Override
    public Peminjaman insertPeminjaman(PeminjamanDto peminjamanDto){
        Peminjaman model = new Peminjaman();
        Peminjaman result = new Peminjaman();

        try {
            model.setId_member(peminjamanDto.getId_member());
            model.setId_paket(peminjamanDto.getId_paket());
            model.setId_mobil(peminjamanDto.getId_mobil());
            model.setId_supir(peminjamanDto.getId_supir());
            model.setTgl_peminjaman(peminjamanDto.getTgl_peminjaman());
            model.setTgl_kembali(peminjamanDto.getTgl_kembali());
            model.setTotal(peminjamanDto.getTotal());
            model.setUang_muka(peminjamanDto.getUang_muka());
            model.setDiskon(peminjamanDto.getDiskon());
            model.setDenda(peminjamanDto.getDenda());
            model.setLama(peminjamanDto.getLama());
            model.setStatus(peminjamanDto.getStatus());
            model.setNama_member(peminjamanDto.getNama_member());
            model.setNo_telp(peminjamanDto.getNo_telp());
            model.setAlamat(peminjamanDto.getAlamat());
            model.setNama_mobil(peminjamanDto.getNama_mobil());
            model.setNama_supir(peminjamanDto.getNama_supir());

            result = peminjamanRepository.save(model);

        }catch (Exception e){

        }
        return result;
    }
    @Override
    public PeminjamanDto getPeminjamanById(int id){
        Peminjaman model = peminjamanRepository.getById(id);
        PeminjamanDto dto = new PeminjamanDto();

        dto.setId_member(model.getId_member());
        dto.setId_paket(model.getId_paket());
        dto.setId_mobil(model.getId_mobil());
        dto.setId_supir(model.getId_mobil());
        dto.setTgl_peminjaman(model.getTgl_peminjaman());
        dto.setTgl_kembali(model.getTgl_kembali());
        dto.setTotal(model.getTotal());
        dto.setUang_muka(model.getUang_muka());
        dto.setDiskon(model.getDiskon());
        dto.setDenda(model.getDenda());
        dto.setLama(model.getLama());
        dto.setStatus(model.getStatus());
        dto.setNama_member(model.getNama_member());
        dto.setNo_telp(model.getNo_telp());
        dto.setAlamat(model.getAlamat());
        dto.setNama_supir(model.getNama_supir());
        dto.setNama_mobil(model.getNama_mobil());

        return dto;
    }

    @Override
    public Peminjaman updatePeminjaman(PeminjamanDto peminjamanDto){
        Peminjaman model = new Peminjaman();
        Peminjaman result = new Peminjaman();
        try {
            model.setId_peminjaman(peminjamanDto.getId_peminjaman());
            model.setId_member(peminjamanDto.getId_member());
            model.setId_paket(peminjamanDto.getId_paket());
            model.setId_mobil(peminjamanDto.getId_mobil());
            model.setId_supir(peminjamanDto.getId_supir());
            model.setTgl_peminjaman(peminjamanDto.getTgl_peminjaman());
            model.setTgl_kembali(peminjamanDto.getTgl_kembali());
            model.setTotal(peminjamanDto.getTotal());
            model.setUang_muka(peminjamanDto.getUang_muka());
            model.setDiskon(peminjamanDto.getDiskon());
            model.setDenda(peminjamanDto.getDenda());
            model.setLama(peminjamanDto.getLama());
            model.setStatus(peminjamanDto.getStatus());
            model.setNama_member(peminjamanDto.getNama_member());
            model.setNo_telp(peminjamanDto.getNo_telp());
            model.setAlamat(peminjamanDto.getAlamat());
            model.setNama_mobil(peminjamanDto.getNama_mobil());
            model.setNama_supir(peminjamanDto.getNama_supir());

            result = peminjamanRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<Peminjaman> searchPeminjaman(SearchDto searchDto){
        List<Peminjaman> listPeminjaman = peminjamanRepository.getPeminjaman(searchDto.getCari());

        return listPeminjaman;
    }
}
