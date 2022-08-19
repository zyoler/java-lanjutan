package org.pubpasim.mudik.dto.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AuditableBaseDto extends EntityBaseDto {

    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;

}
