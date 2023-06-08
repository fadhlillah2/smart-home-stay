package com.komodo.serviceone.repository;

import com.komodo.serviceone.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
}
