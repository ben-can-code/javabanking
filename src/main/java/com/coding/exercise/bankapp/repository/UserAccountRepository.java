package com.coding.exercise.bankapp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coding.exercise.bankapp.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByCustomerNumber(Long customerNumber);
}
