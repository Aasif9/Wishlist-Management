package com.example.wishlist.management.Controller;


import com.example.wishlist.management.Model.Employee;
import com.example.wishlist.management.Model.dto.EmployeeDto;
import com.example.wishlist.management.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@Validated
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //This Is The API For Registering a new User

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody EmployeeDto employeeDto) {
        try {
            Employee employee = employeeService.addEmployee(employeeDto);
            if (employee == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong..");
            } else {
                return ResponseEntity.ok("Registered Successfully");
            }
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        }
    }

}