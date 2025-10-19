package com.example.hms.service;

import com.example.hms.entity.Appointment;
import com.example.hms.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Create a new appointment
    public Appointment createAppointment(Appointment appointment) {
        try {
            return appointmentRepository.save(appointment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create appointment: " + e.getMessage());
        }
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        try {
            return appointmentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch appointments: " + e.getMessage());
        }
    }

    // Get appointment by ID
    public Appointment getAppointmentById(Long id) {
        try {
            return appointmentRepository.findById(id)
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch appointment: " + e.getMessage());
        }
    }

    // Update appointment by ID
    public Appointment updateAppointmentById(Long id, Appointment appointmentDetails) {
        try {
            Appointment existingAppointment = appointmentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));

            existingAppointment.setDate(appointmentDetails.getDate());
            existingAppointment.setDoctorId(appointmentDetails.getDoctorId());
            existingAppointment.setPatientId(appointmentDetails.getPatientId());

            return appointmentRepository.save(existingAppointment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update appointment: " + e.getMessage());
        }
    }

    // Delete appointment by ID
    public String deleteAppointmentById(Long id) {
        try {
            Appointment existingAppointment = appointmentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));

            appointmentRepository.delete(existingAppointment);
            return "Successfully deleted appointment with id: " + id;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete appointment: " + e.getMessage());
        }
    }
}
