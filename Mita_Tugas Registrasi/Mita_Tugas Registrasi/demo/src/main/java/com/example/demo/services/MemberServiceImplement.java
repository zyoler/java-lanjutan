package com.example.demo.services;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Member;
import com.example.demo.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImplement implements MemberService{
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member insertMember(MemberDto memberDto){
        Member model = new Member();
        Member result = new Member();
        try {
            model.setNama_member(memberDto.getNama_member());
            model.setAlamat(memberDto.getAlamat());
            model.setNo_ktp(memberDto.getNo_ktp());
            model.setTgl_lahir(memberDto.getTgl_lahir());
            model.setJenis_kelamin(memberDto.getJenis_kelamin());
            model.setNo_telpon(memberDto.getNo_telpon());
            model.setFoto_member(memberDto.getFoto_member());

            result = memberRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }
    @Override
    public Boolean deleteMember(int id){
        Member model = memberRepository.getById(id);
        memberRepository.delete(model);
        return true;
    }
    @Override
    public MemberDto getMemberById(int id){
        Member model = memberRepository.getById(id);
        MemberDto dto = new MemberDto();

        dto.setId_member(model.getId_member());
        dto.setNama_member(model.getNama_member());
        dto.setAlamat(model.getAlamat());
        dto.setNo_ktp(model.getNo_ktp());
        dto.setTgl_lahir(model.getTgl_lahir());
        dto.setJenis_kelamin(model.getJenis_kelamin());
        dto.setNo_telpon(model.getNo_telpon());
        dto.setFoto_member(model.getFoto_member());
        return dto;
    }

    @Override
    public Member updateMember(MemberDto memberDto){
        Member model = new Member();
        Member result = new Member();
        try {
            model.setId_member(memberDto.getId_member());
            model.setNama_member(memberDto.getNama_member());
            model.setAlamat(memberDto.getAlamat());
            model.setNo_ktp(memberDto.getNo_ktp());
            model.setTgl_lahir(memberDto.getTgl_lahir());
            model.setJenis_kelamin(memberDto.getJenis_kelamin());
            model.setNo_telpon(memberDto.getNo_telpon());
            model.setFoto_member(memberDto.getFoto_member());
            result = memberRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<Member> searchMember(SearchDto searchDto){
        List<Member> listMember = memberRepository.getMember(searchDto.getCari());

        return listMember;
    }
}
