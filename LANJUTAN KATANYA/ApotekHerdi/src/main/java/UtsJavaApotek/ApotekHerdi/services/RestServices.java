package UtsJavaApotek.ApotekHerdi.services;

import UtsJavaApotek.ApotekHerdi.dto.GrafikDto;
import UtsJavaApotek.ApotekHerdi.dto.RestDto;

import java.util.Map;

public interface RestServices {
    Map getObat(RestDto restDTO);
    Map getObatRow(RestDto restDTO);
    Map getObatRowByNama(RestDto restDTO);
    Map getChartByYear(GrafikDto grafikDto);
    Map getChartJualByYear(GrafikDto grafikDto);
    Map getChartBeliByYear(GrafikDto grafikDto);
    Map getChartUnit();
}
