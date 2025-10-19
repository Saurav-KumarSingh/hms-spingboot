package com.example.hms.cotrollers;


import com.example.hms.entity.Doctor;
import com.example.hms.service.DoctorService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/")
    public List<Doctor> getAllDoctors(){

        return doctorService.getAllDoctors();
    }

    @PostMapping("/")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }


    @PutMapping("/{id}")
    public Doctor updateDoctorById(@PathVariable Doctor doctor){
        return doctorService.updateDoctorById(doctor);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctorById(@PathVariable Long id){
        return doctorService.deleteDoctorById(id);

    }



}
