package com.example.hms.service;

import com.example.hms.entity.Patient;
import com.example.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Get all patients
    public List<Patient> getAllPatients() {
        try {
            return patientRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch patients: " + e.getMessage());
        }
    }

    // Get patient by ID
    public Patient getPatientById(Long id) {
        try {
            return patientRepository.findById(id)
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch patient: " + e.getMessage());
        }
    }

    // Create a new patient
    public Patient createPatient(Patient patient) {
        try {
            return patientRepository.save(patient);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create patient: " + e.getMessage());
        }
    }

    // Update patient by ID
    public Patient updatePatientById(Long id, Patient patientDetails) {
        try {
            Patient existingPatient = patientRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

            existingPatient.setName(patientDetails.getName());
            existingPatient.setAge(patientDetails.getAge());
            // Add other fields as needed

            return patientRepository.save(existingPatient);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update patient: " + e.getMessage());
        }
    }

    // Delete patient by ID
    public String deletePatientById(Long id) {
        try {
            Patient existingPatient = patientRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

            patientRepository.delete(existingPatient);
            return "Successfully deleted patient with id: " + id;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete patient: " + e.getMessage());
        }
    }
}
