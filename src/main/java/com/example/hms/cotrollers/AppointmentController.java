package com.example.hms.cotrollers;

import com.example.hms.entity.Appointment;
import com.example.hms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping("/")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointmentById(@PathVariable Long id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointmentById(id, appointment);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointmentById(@PathVariable Long id) {
        return appointmentService.deleteAppointmentById(id);
    }
}
