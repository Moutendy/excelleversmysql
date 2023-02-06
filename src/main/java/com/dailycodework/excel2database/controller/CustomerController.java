package com.dailycodework.excel2database.controller;

import com.dailycodework.excel2database.domain.Customer;
import com.dailycodework.excel2database.service.CustomerService;
import com.dailycodework.excel2database.service.servicexcel;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    servicexcel servi;
    
    @PostMapping("/excel")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file")MultipartFile file){
    
        this.customerService.saveCustomersToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message" , " Customers data uploaded and saved to database successfully"));
    }

    @GetMapping("")
    public void getCustomers(){
    	servi.CreateExcelFileWithCell();
    }
}
