package org.diyaa.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.diyaa.accountservice.enums.AccountType;
import org.diyaa.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Transient
    private Customer customer;
    private Long customerId;
}
