package backend.service;

import backend.model.Customer;
import backend.repository.CustomerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CRUDService<Customer> {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Customer findOne(int id) {
        return repository.findOne(id);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}