package org.neophyte.pertemuan1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.SecondaryTable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponseDto {
    private String pesan;
    private boolean status;
}
