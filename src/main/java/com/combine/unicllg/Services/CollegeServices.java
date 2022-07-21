package com.combine.unicllg.Services;

import com.combine.unicllg.Exception.UserNotFoundException;
import com.combine.unicllg.Model.College;
import com.combine.unicllg.Repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class CollegeServices {
    private final CollegeRepository collegeRepository;

    @Autowired
    public CollegeServices(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public College addcollege(College college) {
        college.setCode(UUID.randomUUID().toString());
        return collegeRepository.save(college);
    }

    public List<College> findAllColleges() {

        return collegeRepository.findAll();
    }

    public College updateCollege(College college) {

        return collegeRepository.save(college);
    }

    public College findCollegeById(Long id) {
        return collegeRepository.findCollegeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by Id" + id + "was not found"));
    }

    public void deleteCollege(Long id) {

        collegeRepository.deleteCollegeById(id);
    }
}