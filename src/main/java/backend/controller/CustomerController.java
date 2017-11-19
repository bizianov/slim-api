package backend.controller;

import backend.model.Customer;
import backend.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    private CRUDService<Customer> service;

    @Autowired
    public CustomerController(CRUDService<Customer> service) {
        this.service = service;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> allCustomers() {
        return service.findAll();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable int id) {
        return service.findOne(id);
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int id) {
        service.delete(id);
    }

    @RequestMapping(value = "/customer/update", method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.save(customer);
    }
}