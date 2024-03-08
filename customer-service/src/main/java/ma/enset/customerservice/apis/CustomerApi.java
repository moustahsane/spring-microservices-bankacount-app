package ma.enset.customerservice.apis;

import lombok.RequiredArgsConstructor;
import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(path = "api/customer")
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerRepository customerRepository;

    @GetMapping()
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }
    @GetMapping("/{id}")
    public Customer getAllCustomers(@PathVariable Long id)
    {
        return customerRepository.findById(id).orElse(null);
    }
}
