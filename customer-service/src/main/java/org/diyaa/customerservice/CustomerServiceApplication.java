package org.diyaa.customerservice;

import org.diyaa.customerservice.entities.Customer;
import org.diyaa.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {

			List<Customer> customerList= List.of(
					Customer.builder()
							.firstName("Diyaa")
							.lastName("chaali")
							.email("diyaa@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Ithar")
							.lastName("chaali")
							.email("ithar@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}

}
