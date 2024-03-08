package ma.enset.accountservice.clients;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.enset.accountservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")

public interface CustomerRestClient {
    @GetMapping("api/customer/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable  Long id);
    @GetMapping()
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultAllCustomers")
    List<Customer> getAllCustomers();

    default Customer getDefaultCustomer(Long id,Exception e){
        return Customer.builder().id(id).build();
    }
    default List<Customer> getDefaultAllCustomers(Exception e){
        return List.of();
    }
}
