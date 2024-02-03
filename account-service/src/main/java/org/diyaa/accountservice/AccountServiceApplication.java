package org.diyaa.accountservice;

import org.diyaa.accountservice.clients.CustomerRestClient;
import org.diyaa.accountservice.entities.BankAccount;
import org.diyaa.accountservice.enums.AccountType;
import org.diyaa.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {

        return args -> {
            customerRestClient.allCustomers().forEach(c-> {
                BankAccount bankAccount1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*858585)
                        .createAt(LocalDate.now())
                        .accountType(AccountType.CURRENT_ACCOUNT)
                        .customerId(c.getId())
                        .build();

                BankAccount bankAccount2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*858585)
                        .createAt(LocalDate.now())
                        .accountType(AccountType.SAVING_ACCOUNT)
                        .customerId(c.getId())
                        .build();

                bankAccountRepository.save(bankAccount1);
                bankAccountRepository.save(bankAccount2);
            });
        };
    }

}
