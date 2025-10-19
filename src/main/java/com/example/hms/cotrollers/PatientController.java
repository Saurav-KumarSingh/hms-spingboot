package com.example.hms.cotrollers;


import com.example.hms.entity.Patient;
import com.example.hms.service.PatientService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping("/")
    public List<Patient> getAllPatients(){

        return patientService.getAllPatients();
    }

    @PostMapping("/")
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }


    @PutMapping("/{id}")
    public Patient updatePatientById(@PathVariable Long id,@RequestBody Patient patient){
        return patientService.updatePatientById(id,patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatientById(@PathVariable Long id){
        return patientService.deletePatientById(id);
    }



}
