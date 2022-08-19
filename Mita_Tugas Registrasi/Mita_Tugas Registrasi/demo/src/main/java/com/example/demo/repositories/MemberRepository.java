package com.example.demo.repositories;

import com.example.demo.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query("FROM Member")
    public List<Member> getMember();

    @Query(value = "select * from member where id_member like %:cariParam% or no_ktp like %:cariParam% or nama_member like %:cariParam% or tgl_lahir like %:cariParam% or no_telpon like %:cariParam% or jenis_kelamin like %:cariParam% or alamat like %:cariParam%", nativeQuery = true)
    public List<Member> getMember(@Param("cariParam")String cari);

}
