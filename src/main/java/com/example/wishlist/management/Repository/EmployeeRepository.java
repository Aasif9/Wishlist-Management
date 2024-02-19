package com.example.wishlist.management.Repository;

import com.example.wishlist.management.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

    /**
     * Finds an employee by email.
     *
     * @param email the email of the employee to find
     * @return the found Employee object, or null if not found
     */

    Employee findByEmail(String email);

    /**
     * Finds an employee by verification code.
     *
     * @param code the verification code to search for
     * @return the found Employee object, or null if not found
     */
    Employee findByVerificationCode(String code);
}