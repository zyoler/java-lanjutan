package org.pubpasim.mudik.service;

import org.pubpasim.mudik.dto.common.MudikDto;
import org.pubpasim.mudik.service.common.CommonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MudikService implements CommonService<MudikDto, Long> {

    @Override
    public MudikDto save(MudikDto entity) {
        return null;
    }

    @Override
    public MudikDto getById(Long pk) {
        return null;
    }

    @Override
    public Boolean delete(Long pk) {
        return null;
    }

    @Override
    public List<MudikDto> getAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
