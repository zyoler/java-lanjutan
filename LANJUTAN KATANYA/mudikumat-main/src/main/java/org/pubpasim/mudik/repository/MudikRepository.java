package org.pubpasim.mudik.repository;

import org.pubpasim.mudik.model.Mudik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MudikRepository extends JpaRepository<Mudik, String> {}