package backend;

import backend.controller.CustomerController;
import backend.model.Customer;
import backend.service.CRUDService;
import backend.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    private List<Customer> allCustomers = Arrays.asList(
            new Customer("FirstName1","LastName1","email1","phone1",
                    "city1","street1",10),
            new Customer("FirstName2","LastName2","email2","phone2",
                    "city2","street2",20));

    @Before
    public void init() {
        when(service.findAll()).thenReturn(allCustomers);
    }

    @Test
    public void allCustomers() throws Exception {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk());
    }
}