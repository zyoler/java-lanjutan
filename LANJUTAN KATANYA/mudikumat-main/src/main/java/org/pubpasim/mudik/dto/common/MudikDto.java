package org.pubpasim.mudik.dto.common;

import lombok.Getter;
import lombok.Setter;
import org.pubpasim.mudik.model.Kabupaten;

import java.util.Date;

@Getter
@Setter
public class MudikDto extends ReferenceBaseDto {

    private String id;
    private Date berangkat;
    private Date kembali;
    private Kabupaten tujuan;

}
