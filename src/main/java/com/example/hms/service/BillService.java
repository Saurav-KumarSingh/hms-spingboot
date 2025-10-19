package com.example.hms.service;

import com.example.hms.entity.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    public Bill createBill(Bill bill) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<Bill> getAllBills() {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Bill updateBill(Long id, Bill billDetails) {
        try {

            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public String deleteBill(Long id) {
        try {

            return "Bill deleted successfully";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
