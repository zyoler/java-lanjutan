package com.example.demo.services;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Member;

import java.util.List;

public interface MemberService {
    public Member insertMember(MemberDto memberDto);
    public Boolean deleteMember(int id);
    public MemberDto getMemberById(int id);
    public Member updateMember(MemberDto memberDto);
    List<Member> searchMember(SearchDto searchDto);
}
