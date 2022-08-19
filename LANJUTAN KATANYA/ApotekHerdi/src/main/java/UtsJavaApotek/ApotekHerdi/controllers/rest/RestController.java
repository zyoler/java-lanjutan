package UtsJavaApotek.ApotekHerdi.controllers.rest;
import UtsJavaApotek.ApotekHerdi.dto.GrafikDto;
import UtsJavaApotek.ApotekHerdi.dto.LoginDto;
import UtsJavaApotek.ApotekHerdi.dto.ObatDto;
import UtsJavaApotek.ApotekHerdi.dto.RestDto;
import UtsJavaApotek.ApotekHerdi.services.LoginServices;
import UtsJavaApotek.ApotekHerdi.services.ObatServices;
import UtsJavaApotek.ApotekHerdi.services.RestServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("Rest-data")
public class RestController{
    @Autowired
    RestServices restserv;

    @Autowired
    LoginServices logservice;

    @RequestMapping("getObats")
    public Object getObats(RestDto restDto){
        Map result = restserv.getObat(restDto);
//        System.out.println(result);
        if(result.get("responseCode").equals("00")){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @RequestMapping("getobatRow")
    public Object getObatsRow(RestDto restDto){
        Map result = restserv.getObatRow(restDto);
        if(result.get("responseCode").equals("00")){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @RequestMapping("getobatrowbynama")
    public Object getObatsRowByNama(RestDto restDto){
        Map result = restserv.getObatRowByNama(restDto);
        if(result.get("responseCode").equals("00")){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @RequestMapping("getChartData")
    public Object getChartByYear(GrafikDto grafikDto){
        Map result = restserv.getChartByYear(grafikDto);

        if(result.get("responseCode").equals("00")){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @RequestMapping("getChartPurchaseData")
    public Object getPurchaseByYear(GrafikDto grafikDto){
        Map result = restserv.getChartBeliByYear(grafikDto);
        if(result.get("responseCode").equals("00")){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @RequestMapping("getChartInvoiceData")
    public Object getInvoiceByYear(GrafikDto grafikDto){
        Map result = restserv.getChartJualByYear(grafikDto);
        if(result.get("responseCode").equals("00")){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @RequestMapping("getChartUnitData")
    public Object getChartUnit(){
        Map result = restserv.getChartUnit();
        if(result.get("responseCode").equals("00")){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }
//
//
//    @RequestMapping("do-login")
//    public Object doLogin(@RequestBody LoginDto loginDTO){
//        Map result = logservice.doLogin(loginDTO);
//        if(result.get("responseCode").equals("00")){
//            return ResponseEntity.ok(result);
//        }else {
//            return ResponseEntity.badRequest().body(result);
//        }
//    }
}
