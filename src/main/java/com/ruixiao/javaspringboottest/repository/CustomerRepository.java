package com.ruixiao.javaspringboottest.repository;

import com.ruixiao.javaspringboottest.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findCustomerById(Integer id);

}
