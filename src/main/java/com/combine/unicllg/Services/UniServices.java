package com.combine.unicllg.Services;

import com.combine.unicllg.Exception.UserNotFoundException;
import com.combine.unicllg.Model.Uni;
import com.combine.unicllg.Repository.UniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UniServices {
    private final UniRepository universityRepo;

    @Autowired
    public UniServices(UniRepository universityRepo) {
        this.universityRepo = universityRepo;
    }

    public Uni addUniversity(Uni university) {
        university.setUniversityCode(UUID.randomUUID().toString());
        return universityRepo.save(university);
    }

    public List<Uni> findAllUniversities(){
        return universityRepo.findAll();
    }

    public Uni updateUniversity(Uni university){
        return universityRepo.save(university);
    }

    public Uni findUniversityById(Long id){
        return universityRepo.findUniversityById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found"));
    }

    public void deleteUniversity(Long id){
        universityRepo.deleteUniversityById(id);
    }
}
