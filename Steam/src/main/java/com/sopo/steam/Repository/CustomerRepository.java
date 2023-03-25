package com.sopo.steam.Repository;

import com.sopo.steam.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public Customer findCustomerByUsername (String username);

}
