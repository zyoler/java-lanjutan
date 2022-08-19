package org.pubpasim.mudik.service.common;

import java.util.List;

public interface CommonService<T, Z> {

    T save(T entity);

    T getById(Z pk);

    Boolean delete(Z pk);

    List<T> getAll();

    void deleteAll();

}
