package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.MidiaGo;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the MidiaGo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MidiaGoRepository extends JpaRepository<MidiaGo, Long> {}
