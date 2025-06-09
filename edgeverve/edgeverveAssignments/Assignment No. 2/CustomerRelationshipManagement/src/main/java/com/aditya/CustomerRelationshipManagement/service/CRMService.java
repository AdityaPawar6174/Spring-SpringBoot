package com.aditya.CustomerRelationshipManagement.service;

import com.aditya.CustomerRelationshipManagement.beans.Customer;
import com.aditya.CustomerRelationshipManagement.beans.Interaction;
import com.aditya.CustomerRelationshipManagement.repos.CustomerRepo;
import com.aditya.CustomerRelationshipManagement.repos.InteractionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CRMService implements CRMServiceInterface {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private InteractionRepo interactionRepo;

    // Customer Services

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    // Interaction Services

    @Override
    public Interaction addInteraction(int customerId, Interaction interaction) {
        Optional<Customer> customerOpt = customerRepo.findById(customerId);
        if (customerOpt.isPresent()) {
            interaction.setCustomer(customerOpt.get());
            interaction.setDate(LocalDate.now());
            return interactionRepo.save(interaction);
        } else {
            throw new IllegalArgumentException("Customer with ID " + customerId + " not found...");
        }
    }

    @Override
    public List<Interaction> getFeedbackByProduct(String product) {
        return interactionRepo.findByProduct(product);
    }

    @Override
    public List<Interaction> getFeedbackByDateRange(LocalDate start, LocalDate end) {
        return interactionRepo.findByDateBetween(start, end);
    }

    @Override
    public List<Interaction> getFeedbackByRating(int rating) {
        return interactionRepo.findByRating(rating);
    }

}
