package com.example.hms.service;

import com.example.hms.entity.Bill;
import com.example.hms.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    // Create a new bill
    public Bill createBill(Bill bill) {
        try {
            return billRepository.save(bill);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create bill: " + e.getMessage());
        }
    }

    // Get all bills
    public List<Bill> getAllBills() {
        try {
            return billRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch bills: " + e.getMessage());
        }
    }

    // Get bill by ID
    public Bill getBillById(Long id) {
        try {
            return billRepository.findById(id)
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch bill: " + e.getMessage());
        }
    }

    // Update bill by ID
    public Bill updateBill(Long id, Bill billDetails) {
        try {
            Bill existingBill = billRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));

            existingBill.setAmount(billDetails.getAmount());
            existingBill.setStatus(billDetails.getStatus());
//            existingBill.setPatientId(billDetails.getPatientId());
            // Add other fields as needed

            return billRepository.save(existingBill);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update bill: " + e.getMessage());
        }
    }

    // Delete bill by ID
    public String deleteBill(Long id) {
        try {
            Bill existingBill = billRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));

            billRepository.delete(existingBill);
            return "Successfully deleted bill with id: " + id;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete bill: " + e.getMessage());
        }
    }
}
