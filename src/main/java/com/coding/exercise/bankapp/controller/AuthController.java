package com.coding.exercise.bankapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.exercise.bankapp.domain.CustomerDetails;
import com.coding.exercise.bankapp.model.UserAccount;
import com.coding.exercise.bankapp.service.BankingServiceImpl;
import com.coding.exercise.bankapp.service.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private BankingServiceImpl bankingService;

    /**
     * Register a new user. Creates both a login account and a customer profile.
     * Body: { username, password, firstName, lastName, middleName,
     *         customerNumber, status, email, homePhone, workPhone,
     *         address1, address2, city, state, zip, country }
     */
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Map<String, Object> body) {
        try {
            String username       = getString(body, "username");
            String password       = getString(body, "password");
            String firstName      = getString(body, "firstName");
            String lastName       = getString(body, "lastName");
            String middleName     = getString(body, "middleName");
            Long   customerNumber = getLong(body, "customerNumber");
            String status         = getString(body, "status", "ACTIVE");
            String email          = getString(body, "email");
            String homePhone      = getString(body, "homePhone");
            String workPhone      = getString(body, "workPhone");
            String address1       = getString(body, "address1");
            String address2       = getString(body, "address2");
            String city           = getString(body, "city");
            String state          = getString(body, "state");
            String zip            = getString(body, "zip");
            String country        = getString(body, "country");

            if (username == null || username.isBlank())   return error("Username is required.");
            if (password == null || password.length() < 4) return error("Password must be at least 4 characters.");
            if (firstName == null || firstName.isBlank()) return error("First name is required.");
            if (lastName  == null || lastName.isBlank())  return error("Last name is required.");
            if (customerNumber == null)                   return error("Customer number is required.");

            // 1. Create the login account
            String fullName = firstName + " " + lastName;
            userService.registerUser(username, password, "ROLE_USER", customerNumber, fullName, email);

            // 2. Create the customer profile in the banking system
            com.coding.exercise.bankapp.domain.AddressDetails addr =
                com.coding.exercise.bankapp.domain.AddressDetails.builder()
                    .address1(address1).address2(address2)
                    .city(city).state(state).zip(zip).country(country).build();

            com.coding.exercise.bankapp.domain.ContactDetails contact =
                com.coding.exercise.bankapp.domain.ContactDetails.builder()
                    .emailId(email).homePhone(homePhone).workPhone(workPhone).build();

            CustomerDetails customer = CustomerDetails.builder()
                .firstName(firstName).lastName(lastName).middleName(middleName)
                .customerNumber(customerNumber).status(status)
                .customerAddress(addr).contactDetails(contact).build();

            bankingService.addCustomer(customer);

            Map<String, Object> result = new HashMap<>();
            result.put("message", "Account created successfully.");
            result.put("username", username);
            result.put("customerNumber", customerNumber);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);

        } catch (IllegalArgumentException e) {
            return error(e.getMessage());
        } catch (Exception e) {
            return error("Registration failed: " + e.getMessage());
        }
    }

    /**
     * Returns the currently authenticated user's profile.
     * The frontend calls this after Basic Auth login to get user info.
     */
    @GetMapping("/me")
    public ResponseEntity<Object> me(Authentication auth) {
        if (auth == null || !auth.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authenticated.");
        }
        String username = auth.getName();
        Map<String, Object> info = new HashMap<>();
        info.put("username", username);

        // Try to find user in DB (registered users)
        UserAccount account = userService.findByUsername(username);
        if (account != null) {
            info.put("role",           account.getRole());
            info.put("fullName",       account.getFullName());
            info.put("email",          account.getEmail());
            info.put("customerNumber", account.getCustomerNumber());
        } else {
            // Admin user from application.yml (not in DB)
            info.put("role",     "ROLE_ADMIN");
            info.put("fullName", "Administrator");
            info.put("email",    "");
            info.put("customerNumber", null);
        }
        return ResponseEntity.ok(info);
    }

    // ── helpers ──────────────────────────────────────────────────────
    private ResponseEntity<Object> error(String msg) {
        Map<String, String> body = new HashMap<>();
        body.put("error", msg);
        return ResponseEntity.badRequest().body(body);
    }

    private String getString(Map<String, Object> m, String key) {
        Object v = m.get(key);
        return v != null ? v.toString().trim() : null;
    }

    private String getString(Map<String, Object> m, String key, String def) {
        String v = getString(m, key);
        return (v == null || v.isBlank()) ? def : v;
    }

    private Long getLong(Map<String, Object> m, String key) {
        Object v = m.get(key);
        if (v == null) return null;
        try { return Long.parseLong(v.toString()); }
        catch (NumberFormatException e) { return null; }
    }
}
