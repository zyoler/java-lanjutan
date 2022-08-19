package org.pubpasim.mudik.dto.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReferenceBaseDto extends AuditableBaseDto {

    private Integer versi;
    private Boolean dihapus;

}
