package org.pubpasim.mudik.dto;

import lombok.Getter;
import lombok.Setter;
import org.pubpasim.mudik.model.Kabupaten;

import java.util.List;

@Getter
@Setter
public class ProvinsiDto {
    private String id;
    private String nama;
    private List<Kabupaten> kabupaten;
}
