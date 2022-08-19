package UtsJavaApotek.ApotekHerdi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="table_unit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitModels implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_unit", nullable = true, unique = true)
    private Integer id_unit;

    @Column(name = "unit")
    private String unit;

    public Integer getId_unit() {
        return id_unit;
    }

    public void setId_unit(Integer id_unit) {
        this.id_unit = id_unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
