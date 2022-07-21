package com.combine.unicllg.Repository;

import com.combine.unicllg.Model.Uni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UniRepository extends JpaRepository<Uni,Long> {
    void deleteUniversityById(Long id);

    Optional<Uni> findUniversityById(Long id);

}
