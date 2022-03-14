package com.ebay.citizenservice.service;

import com.ebay.citizenservice.data.CitizenList;
import com.ebay.citizenservice.model.Citizen;
import com.ebay.citizenservice.repository.CitizenRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitizenService {
  private static final Logger LOGGER = LogManager.getLogger(CitizenService.class);
  @Autowired private CitizenRepository citizenRepository;

  /**
   * get citizens by area numbers
   *
   * @param areaNumbers area numbers
   * @return citizens list
   */
  public CitizenList getCitizensByAreaNumbers(List<String> areaNumbers) {

    List<Citizen> ans = new ArrayList<>();
    LOGGER.info("for each area number find all citizens");
    for (String areaNumber : areaNumbers) {
      ans.addAll(citizenRepository.findAllByAreaNumber(areaNumber));
    }
    LOGGER.info("Return list of citizen by area numbers");
    return new CitizenList(ans);
  }

  /**
   * get citizen by id
   *
   * @param id id
   * @return citizen
   */
  public Citizen getById(long id) {
    LOGGER.info("Get citizen by id");
    return citizenRepository.getById(id);
  }
}
