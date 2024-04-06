package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.entity.Bill;
@Repository
public interface BillRespository extends JpaRepository<Bill, Integer> {

}
