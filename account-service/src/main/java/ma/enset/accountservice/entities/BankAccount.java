package ma.enset.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.accountservice.enums.AccountType;
import ma.enset.accountservice.models.Customer;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private LocalDate creationDate;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Transient
    private Customer customer;
    private Long customerId;
}
