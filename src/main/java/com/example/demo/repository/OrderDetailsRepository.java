package com.example.demo.repository;

import com.example.demo.entity.OrderDetails;
import com.example.demo.entity.OrderDetailsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsKey> {


}