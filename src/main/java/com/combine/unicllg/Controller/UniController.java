package com.combine.unicllg.Controller;

import com.combine.unicllg.Model.Uni;
import com.combine.unicllg.Services.UniServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/uni")
public class UniController {
    private final UniServices universityService;
    public UniController(UniServices universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Uni>> getAllUniversities(){
        List<Uni> universities=universityService.findAllUniversities();
        return new ResponseEntity<>(universities, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Uni> getUniversityById(@PathVariable("id") Long id){
        Uni university=universityService.findUniversityById(id);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Uni> addUniversity(@RequestBody Uni university){
        Uni newUniversity = universityService.addUniversity(university);
        return new ResponseEntity<>(newUniversity, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Uni> updateUniversity(@RequestBody Uni university){
        Uni updateUniversity = universityService.updateUniversity(university);
        return new ResponseEntity<>(updateUniversity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUniversity(@PathVariable("id") Long id){
        universityService.deleteUniversity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
