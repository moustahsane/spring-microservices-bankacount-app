package ma.enset.accountservice;

import ma.enset.accountservice.entities.BankAccount;
import ma.enset.accountservice.enums.AccountType;
import ma.enset.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
        return args -> bankAccountRepository.saveAll(
                Arrays.asList(
                        BankAccount.builder()
                                .id(UUID.randomUUID().toString())
                                .balance(14455.014)
                                .accountType(AccountType.CURRENT_ACCOUNT)
                                .creationDate(LocalDate.now())
                                .currency("MAD")
                                .customerId(1L)
                                .build(),
                        BankAccount.builder()
                                .id(UUID.randomUUID().toString())
                                .balance(1999501D)
                                .accountType(AccountType.SAVING_ACCOUNT)
                                .creationDate(LocalDate.now())
                                .currency("MAD")
                                .customerId(2L)
                                .build()
                ));
    }
}
