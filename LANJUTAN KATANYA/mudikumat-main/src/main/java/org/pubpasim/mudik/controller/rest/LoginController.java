package org.pubpasim.mudik.controller.rest;

import org.pubpasim.mudik.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/periksa")
    public ResponseEntity<Map<String, String>> periksa(@RequestParam(value="id") String id) {
        return loginService.periksa(id);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(HttpServletRequest request, @RequestParam(value="id") String id, @RequestParam(value="kataSandi") String kataSandi) {
        return loginService.login(request, id, kataSandi);
    }

}
