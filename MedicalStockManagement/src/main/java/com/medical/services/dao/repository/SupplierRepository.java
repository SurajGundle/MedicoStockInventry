package com.medical.services.dao.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
