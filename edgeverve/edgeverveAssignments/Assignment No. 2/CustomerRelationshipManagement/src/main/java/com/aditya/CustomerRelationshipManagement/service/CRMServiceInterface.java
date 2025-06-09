package com.aditya.CustomerRelationshipManagement.service;


import com.aditya.CustomerRelationshipManagement.beans.Customer;
import com.aditya.CustomerRelationshipManagement.beans.Interaction;

import java.time.LocalDate;
import java.util.List;

public interface CRMServiceInterface {

    public Customer addCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public List<Customer> getAllCustomer();

    public void deleteCustomer(int id);

    public Customer updateCustomer(Customer customer);

    public Interaction addInteraction(int customerId,Interaction interaction);

    public List<Interaction> getFeedbackByProduct(String product);

    public List<Interaction> getFeedbackByDateRange(LocalDate from, LocalDate to);

    public List<Interaction> getFeedbackByRating(int rating);
}
