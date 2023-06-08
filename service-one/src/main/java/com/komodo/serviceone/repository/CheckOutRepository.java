package com.komodo.serviceone.repository;

import com.komodo.serviceone.entity.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRepository extends JpaRepository<CheckOut, Long> {
}