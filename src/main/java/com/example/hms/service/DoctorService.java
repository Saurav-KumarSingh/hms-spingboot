package com.example.hms.service;

import com.example.hms.entity.Doctor;
import com.example.hms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        try {
            return doctorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch doctors: " + e.getMessage());
        }
    }

    // Get doctor by ID
    public Doctor getDoctorById(Long id) {
        try {
            return doctorRepository.findById(id)
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch doctor: " + e.getMessage());
        }
    }

    // Create a new doctor
    public Doctor createDoctor(Doctor doctor) {
        try {
            return doctorRepository.save(doctor);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create doctor: " + e.getMessage());
        }
    }

    // Update doctor by ID
    public Doctor updateDoctorById(Long id, Doctor doctorDetails) {
        try {
            Doctor existingDoctor = doctorRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

            existingDoctor.setName(doctorDetails.getName());
            existingDoctor.setAge(doctorDetails.getAge());
            existingDoctor.setSpeciality(doctorDetails.getSpeciality());
            // Add other fields as needed

            return doctorRepository.save(existingDoctor);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update doctor: " + e.getMessage());
        }
    }

    // Delete doctor by ID
    public String deleteDoctorById(Long id) {
        try {
            Doctor existingDoctor = doctorRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

            doctorRepository.delete(existingDoctor);
            return "Successfully deleted doctor with id: " + id;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete doctor: " + e.getMessage());
        }
    }
}
