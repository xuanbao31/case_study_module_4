package com.example.demo.repository;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
        @Query(value = "select c.* from `customer` c join `customer_type` ct on c.customer_type_id = ct.id " +
                "where c.name like %:name% and c.email like %:email% and ct.name like %:customerType% and c.status=0", nativeQuery = true)
    Page<Customer> findByBlogNameEmailAndCustomerTypeContaining(Pageable pageable,
                                            @Param("name") String name,
                                            @Param("email") String email,
                                            @Param("customerType") String customerType
                                            );
    @Query(value="select * from customer" +
            "where name like %:name% and status=0 ", nativeQuery = true)
    Page<Customer> findByBlogNameContaining(Pageable pageable,
                                            @Param("name") String name
    );

}
