package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.MidiaGoProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the MidiaGoProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MidiaGoProcessRepository extends JpaRepository<MidiaGoProcess, Long> {
    Optional<MidiaGoProcess> findByProcessInstanceId(Long processInstanceId);
}
