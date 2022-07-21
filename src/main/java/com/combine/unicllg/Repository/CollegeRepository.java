package com.combine.unicllg.Repository;

import com.combine.unicllg.Model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CollegeRepository extends JpaRepository<College,Long> {
    void deleteCollegeById(Long id);

    Optional<College> findCollegeById(Long id);
}
