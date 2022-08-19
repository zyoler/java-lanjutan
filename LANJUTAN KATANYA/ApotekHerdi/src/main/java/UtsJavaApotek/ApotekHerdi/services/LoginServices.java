package UtsJavaApotek.ApotekHerdi.services;

import UtsJavaApotek.ApotekHerdi.dto.LoginDto;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface LoginServices {
    Map doLogin(LoginDto loginDTO);
}
