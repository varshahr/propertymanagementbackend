package com.property.property.management.repository;

import com.property.property.management.model.RealEstateUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<RealEstateUnit, Long> {
    // No additional methods needed now; basic CRUD is inherited from JpaRepository
}
