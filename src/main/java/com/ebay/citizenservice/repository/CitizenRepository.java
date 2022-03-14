package com.ebay.citizenservice.repository;

import com.ebay.citizenservice.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
  List<Citizen> findAllByAreaNumber(String areaNumber);
}
