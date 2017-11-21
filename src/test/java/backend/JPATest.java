package backend;

import backend.model.Customer;
import backend.repository.CustomerRepository;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPATest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void init() {
        Customer customer = new Customer("firstName", "lastName", "test@email.com",
                "1-123-123-123","New York", "Test street", 23);
        testEntityManager.persist(customer);
        testEntityManager.flush();
    }

    @Test
    public void persistenceTest() {
        ArrayList<Customer> allCustomers = Lists.newArrayList(customerRepository.findAll());
        assertThat(allCustomers, hasSize(2));
    }
}