package org.pubpasim.mudik.service;

import org.pubpasim.mudik.DetailAkun;
import org.pubpasim.mudik.repository.AkunRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DetailAkunService implements UserDetailsService {

    private final AkunRepository akunRepository;

    public DetailAkunService(AkunRepository akunRepository) {
        this.akunRepository = akunRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return akunRepository.findById(id).map(DetailAkun::new).orElseThrow(() -> new UsernameNotFoundException("Akun tidak ditemukan."));
    }

}