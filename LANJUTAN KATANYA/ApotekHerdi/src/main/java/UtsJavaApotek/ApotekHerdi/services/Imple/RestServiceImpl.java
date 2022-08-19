package UtsJavaApotek.ApotekHerdi.services.Imple;

import UtsJavaApotek.ApotekHerdi.dto.GrafikDto;
import UtsJavaApotek.ApotekHerdi.dto.RestDto;
import UtsJavaApotek.ApotekHerdi.models.ObatModels;
import UtsJavaApotek.ApotekHerdi.repositories.BeliRepository;
import UtsJavaApotek.ApotekHerdi.repositories.JualRepository;
import UtsJavaApotek.ApotekHerdi.repositories.ObatRepository;
import UtsJavaApotek.ApotekHerdi.repositories.UnitRepository;
import UtsJavaApotek.ApotekHerdi.services.RestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestServiceImpl implements RestServices {
    @Autowired
    ObatRepository obatrepo;

    @Autowired
    JualRepository jualrepo;

    @Autowired
    BeliRepository belirepo;

    @Autowired
    UnitRepository unitrepo;

    @Override
    public Map getObat(RestDto restDTO) {
        Map result = new HashMap();
        try {
            List<ObatModels> obat = obatrepo.getObatByNamaPemasok(restDTO.getNama_pemasok());
            Map obatrest = new HashMap();
            if (obat != null){
                    result.put("responseCode","00");
                    result.put("message","Data Berhasil Diambil");
                    result.put("nama_pemasok",obat);

            }else{
                    //gagal
                    result.put("responseCode","99");
                    result.put("message","Data Gagal Diambil");

            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("responseCode","99");
            result.put("message","Terjadi Kesalahan");
        }
        return result;
    }

    @Override
    public Map getObatRow(RestDto restDTO) {
        Map result = new HashMap();
        try {
            List<ObatModels> obat = obatrepo.getObatByNama(restDTO.getNama_obat());
            Map obatrest = new HashMap();
            //System.out.println("nilai dari implement : " + obat);
            if (obat != null){
                result.put("responseCode","00");
                result.put("message","Data Berhasil Diambil");
                result.put("nama_obat",obat);

            }else{
                //gagal
                result.put("responseCode","99");
                result.put("message","Data Gagal Diambil");

            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("responseCode","99");
            result.put("message","Terjadi Kesalahan");
        }
        return result;
    }

    @Override
    public Map getObatRowByNama(RestDto restDTO) {
        Map result = new HashMap();
        try {
            List<ObatModels> obat = obatrepo.getObatByNamaObat(restDTO.getNama_obat());
            //System.out.println("nilai dari implement : " + obat);
            if (obat != null){
                result.put("responseCode","00");
                result.put("message","Data Berhasil Diambil");
                result.put("nama_obat",obat);

            }else{
                //gagal
                result.put("responseCode","99");
                result.put("message","Data Gagal Diambil");

            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("responseCode","99");
            result.put("message","Terjadi Kesalahan");
        }
        return result;
    }

    @Override
    public Map getChartByYear(GrafikDto grafikDto) {
        Map result = new HashMap();
        try {
            if (jualrepo.getChart(grafikDto.getTahun_beli()) != null){
                result.put("responseCode","00");
                result.put("message","Data Berhasil Diambil");
                result.put("charts",jualrepo.getChart(grafikDto.getTahun_beli()));
            }else{
                //gagal
                result.put("responseCode","99");
                result.put("message","Data Gagal Diambil");

            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("responseCode","99");
            result.put("message","Terjadi Kesalahan");
        }
        return result;
    }

    @Override
    public Map getChartJualByYear(GrafikDto grafikDto) {
        Map result = new HashMap();
        try {
            if (jualrepo.getInvoiceChart(grafikDto.getTahun_beli()) != null){
                result.put("responseCode","00");
                result.put("message","Data Berhasil Diambil");
                result.put("chartJual",jualrepo.getInvoiceChart(grafikDto.getTahun_beli()));
                result.put("highestEarn",jualrepo.getHighestInvoice(grafikDto.getTahun_beli()));
                result.put("lowestEarn",jualrepo.getlowestInvoice(grafikDto.getTahun_beli()));
                result.put("leastEarn",jualrepo.leastInvoice(grafikDto.getTahun_beli()));
                result.put("topEarn",jualrepo.topInvoice(grafikDto.getTahun_beli()));

            }else{
                //gagal
                result.put("responseCode","99");
                result.put("message","Data Gagal Diambil");

            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("responseCode","99");
            result.put("message","Terjadi Kesalahan");
        }
        return result;
    }

    @Override
    public Map getChartBeliByYear(GrafikDto grafikDto) {
        Map result = new HashMap();
        try {
            if (belirepo.getPurchaseChart(grafikDto.getTahun_beli()) != null){
                result.put("responseCode","00");
                result.put("message","Data Berhasil Diambil");
                result.put("chartBeli",belirepo.getPurchaseChart(grafikDto.getTahun_beli()));
                result.put("highestPurchase",belirepo.getHighestPurchase(grafikDto.getTahun_beli()));
                result.put("lowestPurchase",belirepo.getlowestPurchase(grafikDto.getTahun_beli()));
                result.put("leastPurchase",belirepo.leastPurchase(grafikDto.getTahun_beli()));
                result.put("topPurchase",belirepo.topPurchase(grafikDto.getTahun_beli()));

            }else{
                //gagal
                result.put("responseCode","99");
                result.put("message","Data Gagal Diambil");

            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("responseCode","99");
            result.put("message","Terjadi Kesalahan");
        }
        return result;
    }

    @Override
    public Map getChartUnit() {
        Map result = new HashMap();
        try {
            if (unitrepo.getChartUnitNative() != null){
                result.put("responseCode","00");
                result.put("message","Data Berhasil Diambil");
                result.put("chartUnit",unitrepo.getChartUnitNative());

            }else{
                //gagal
                result.put("responseCode","99");
                result.put("message","Data Gagal Diambil");

            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("responseCode","99");
            result.put("message","Terjadi Kesalahan");
        }
        return result;
    }

}
