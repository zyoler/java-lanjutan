package UtsJavaApotek.ApotekHerdi.services.Imple;

import UtsJavaApotek.ApotekHerdi.dto.KatDto;
import UtsJavaApotek.ApotekHerdi.dto.LoginDto;
import UtsJavaApotek.ApotekHerdi.models.AdminModels;
import UtsJavaApotek.ApotekHerdi.models.KatModels;
import UtsJavaApotek.ApotekHerdi.repositories.AdminRepository;
import UtsJavaApotek.ApotekHerdi.services.LoginServices;
import org.apache.catalina.session.StandardSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginServices {
    @Autowired
    AdminRepository admrepo;
    @Override
    public Map doLogin(LoginDto loginDTO) {
        Map result = new HashMap();
        try {
            AdminModels admin = admrepo.getAdminByEmail(loginDTO.getEmail());
            if (admin != null){
                if (admin.getPassword().equals(loginDTO.getPassword())){
                    //berhasil
                    result.put("responseCode","00");
                    result.put("message","Login Berhasil");

                }else{
                    //gagal
                    result.put("responseCode","99");
                    result.put("message","Password Salah");

                }


            }else  {
                result.put("responseCode","99");
                result.put("message","User Belum Terdaftar");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("responseCode","99");
            result.put("message","Terjadi Kesalahan");
        }

        return result;
    }
}
