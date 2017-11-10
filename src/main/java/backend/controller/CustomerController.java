package backend.controller;

import backend.model.Customer;
import backend.repository.CustomerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    private CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/customers")
    public List<Customer> allCustomers() {
        return Lists.newArrayList(repository.findAll());
    }

    @RequestMapping(value = "/customer/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int id) {
        repository.delete(id);
    }

    @RequestMapping(value = "/customer/update", method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }
}