package com.komodo.userservice.repository;

import com.komodo.userservice.entity.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRepository extends JpaRepository<CheckOut, Long> {
}