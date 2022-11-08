package com.example.demo.repository;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
        @Query(value="select * from customer where name like %:name% and status=0 ", nativeQuery = true)
    Page<Customer> findByBlogNameContaining(Pageable pageable, String name);


}
