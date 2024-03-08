package ma.enset.customerservice;

import ma.enset.customerservice.config.GlobalConfig;
import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> customerRepository.saveAll(
                Arrays.asList(
                        Customer.builder()
                                .firstName("Mehdi")
                                .lastName("ALILOU")
                                .email("mehdialilou99@gmail.com")
                                .build(),
                        Customer.builder()
                                .firstName("Amine")
                                .lastName("Doum")
                                .email("amine@gmail.com")
                                .build(),
                        Customer.builder()
                                .firstName("Jean")
                                .lastName("Park")
                                .email("jean@gmail.com")
                                .build()
                ));
    }

}
