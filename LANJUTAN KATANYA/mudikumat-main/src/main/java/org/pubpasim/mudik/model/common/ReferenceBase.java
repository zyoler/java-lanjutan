package org.pubpasim.mudik.model.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@Getter
@Setter
@MappedSuperclass
public class ReferenceBase extends AuditableBase {

    @Version
    @Column(name = "versi")
    private Integer versi;

    @Column(name = "dihapus")
    private Boolean dihapus;

    @PreUpdate
    private void preUpdate() {
        this.versi = getVersi() + 1;
    }

}
