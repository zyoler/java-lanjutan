package UtsJavaApotek.ApotekHerdi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrafikDto {
    String month;
    Integer total;
    String tahun_beli;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTahun_beli() {
        return tahun_beli;
    }

    public void setTahun_beli(String tahun_beli) {
        this.tahun_beli = tahun_beli;
    }
}
