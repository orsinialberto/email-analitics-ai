package com.example.datacollection.service;

import com.example.datacollection.repository.CustomerRepository;
import com.example.datacollection.resource.CustomerMapper;
import com.example.datacollection.resource.CustomerRes;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    /**
     * Creates a new customer by transforming the provided resource object into an entity,
     * saving it to the database, and converting the saved entity back into a resource.
     * This method uses a functional programming approach for immutability and clarity.
     *
     * @param customerReq the {@link CustomerRes} object containing the data for the new customer; must not be null
     * @return the saved {@link CustomerRes} object, containing the generated customer ID and other persisted details
     * @throws IllegalArgumentException if the provided {@code customerReq} is null
     * @throws org.springframework.dao.DataAccessException if a database access error occurs
     */
    public CustomerRes createCustomer(final CustomerRes customerReq) {
        return Optional.ofNullable(customerReq)
                .map(customerMapper::toEntity)
                .map(customerRepository::save)
                .map(customerMapper::toResource)
                .orElseThrow(() -> new IllegalArgumentException("Customer request cannot be null"));
    }

    /**
     * Retrieves all customers from the database, converts them to resource objects,
     * and returns the resulting list.
     *
     * @return a {@link List} of {@link CustomerRes} objects representing all customers stored in the database
     * @throws org.springframework.dao.DataAccessException if a database access error occurs
     */
    public List<CustomerRes> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResource)
                .toList();
    }

    /**
     * Retrieves a customer by its ID. If the customer is found, it is converted to a resource object
     * and returned. If the customer is not found, an {@link EntityNotFoundException} is thrown.
     *
     * @param customerId the ID of the customer to retrieve; must not be null
     * @return a {@link CustomerRes} object representing the customer, or {@code null} if the customer does not exist
     * @throws EntityNotFoundException if no customer with the specified ID is found in the database
     */
    public CustomerRes getCustomerById(final String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::toResource)
                .orElseThrow(() -> new EntityNotFoundException("Customer with ID " + customerId + " not found"));
    }

    /**
     * Deletes all customers from the database.
     * This operation will remove all customer records permanently.
     *
     * @throws org.springframework.dao.DataAccessException if a database access error occurs
     */
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    /**
     * Deletes a customer by its ID from the database.
     * If no customer with the specified ID is found, no action is taken.
     *
     * @param customerId the ID of the customer to be deleted; must not be null
     * @throws org.springframework.dao.DataAccessException if a database access error occurs
     */
    public void delete(final String customerId) {
        customerRepository.deleteById(customerId);
    }
}
