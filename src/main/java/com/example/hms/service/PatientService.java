package com.example.hms.service;

import com.example.hms.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService {

    public List<Patient> getAllPatients(){
        try {

            return null;

        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id){
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }
    public Patient createPatient(Patient patient){
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    public Patient updatePatientById(Patient patient) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    public String deletePatientById(Long id) {
        try {
           return null;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }
}
