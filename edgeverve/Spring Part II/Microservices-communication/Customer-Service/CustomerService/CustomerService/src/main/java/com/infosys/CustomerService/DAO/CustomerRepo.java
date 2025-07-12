package com.infosys.CustomerService.DAO;

import com.infosys.CustomerService.Entitties.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
