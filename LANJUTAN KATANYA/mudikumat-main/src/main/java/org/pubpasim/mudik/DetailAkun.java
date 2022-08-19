package org.pubpasim.mudik;

import org.pubpasim.mudik.model.Akun;
import org.pubpasim.mudik.model.JabatanAkun;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class DetailAkun implements UserDetails {

    private final Akun akun;

    public DetailAkun(Akun akun) {
        this.akun = akun;
    }

    @Override
    public String getPassword() {
        return akun.getKataSandi();
    }

    @Override
    public String getUsername() {
        return akun.getNamaPengguna();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Akun getAkun() {
        return akun;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<JabatanAkun> daftarJabatan = akun.getJabatan();
        List<SimpleGrantedAuthority> otoritas = new ArrayList<>();

        otoritas.add(new SimpleGrantedAuthority("ROLE_USER"));
        for (JabatanAkun jabatanAkun : daftarJabatan) {
            if (jabatanAkun.getJabatan().getId() <= 3 && (jabatanAkun.getAkhirMenjabat() == null || jabatanAkun.getAkhirMenjabat() >= MudikUmatApplication.periode + 1)) {
                otoritas.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        }

        return otoritas;
    }

}