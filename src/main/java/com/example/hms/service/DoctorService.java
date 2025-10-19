package com.example.hms.service;

import com.example.hms.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    public Doctor updateDoctorById(Doctor doctor) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    public List<Doctor> getAllDoctors() {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }

    public String deleteDoctorById(Long id) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }
    }
}
