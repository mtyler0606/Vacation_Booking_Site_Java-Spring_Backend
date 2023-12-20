package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapSampleCustomers implements CommandLineRunner {

    private final DivisionRepository divisionRepository;
    private final CustomerRepository customerRepository;

    public BootstrapSampleCustomers(DivisionRepository divisionRepository, CustomerRepository customerRepository) {
        this.divisionRepository = divisionRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(customerRepository.count()==1){
            Division sampleDivision = new Division();
            sampleDivision.setId(1L);
            sampleDivision.setDivision_name("Sample division");
            sampleDivision.setCountry_id(1L);

            divisionRepository.save(sampleDivision);

            Customer customer1 = new Customer("Sample1", "Customer1", "123 Sample St", "55555", "555-555-5555", sampleDivision);
            Customer customer2 = new Customer("Sample2", "Customer2", "456 Sample St", "55555", "555-555-5556", sampleDivision);
            Customer customer3 = new Customer("Sample3", "Customer3", "789 Sample St", "55555", "555-555-5557", sampleDivision);
            Customer customer4 = new Customer("Sample4", "Customer4", "123 Sample Rd", "55555", "555-555-5558", sampleDivision);
            Customer customer5 = new Customer("Sample5", "Customer5", "456 Sample Rd", "55555", "555-555-5559", sampleDivision);

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);
        }

    }
}
