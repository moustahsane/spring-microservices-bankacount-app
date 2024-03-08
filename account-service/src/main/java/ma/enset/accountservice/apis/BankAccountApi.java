package ma.enset.accountservice.apis;

import lombok.RequiredArgsConstructor;
import ma.enset.accountservice.clients.CustomerRestClient;
import ma.enset.accountservice.entities.BankAccount;
import ma.enset.accountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController()
@RequestMapping(path = "api/account")
@RequiredArgsConstructor
public class BankAccountApi {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    @GetMapping("")
    public List<BankAccount> getAllCustomers()
    {
        return bankAccountRepository.findAll();
    }
    @GetMapping("/{id}")
    public BankAccount getAllCustomers(@PathVariable String id)
    {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElse(null);
        if(Objects.nonNull(bankAccount))
            bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }
}
