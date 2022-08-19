package org.neophyte.pertemuan1.services;

import org.neophyte.pertemuan1.model.Admin;

public interface loginService {
    public Admin login(String username, String password);
}
