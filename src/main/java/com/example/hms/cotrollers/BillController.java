package com.example.hms.controllers;

import com.example.hms.entity.Bill;
import com.example.hms.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @PostMapping("/")
    public Bill createBill(@RequestBody Bill bill) {
        return billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        return billService.getBillById(id);
    }

    @PutMapping("/{id}")
    public Bill updateBillById(@PathVariable Long id, @RequestBody Bill bill) {
        return billService.updateBill(id, bill);
    }

    @DeleteMapping("/{id}")
    public String deleteBillById(@PathVariable Long id) {
        return billService.deleteBill(id);
    }
}
