package org.neophyte.pertemuan1.dto;

import lombok.Data;

@Data
public class MailRequestDto {
    private String to;
    private String text;
    private String jenis_kelamin;
    private String nama;
    private String nim;
}
