package com.ebay.citizenservice.controller;

import com.ebay.citizenservice.data.CitizenList;
import com.ebay.citizenservice.model.Citizen;
import com.ebay.citizenservice.service.CitizenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
  private static final Logger LOGGER = LogManager.getLogger(CitizenController.class);
  @Autowired CitizenService citizenService;

  /**
   * get citizens by area numbers
   *
   * @param areaNumbers area numbers
   * @return citizens list
   */
  @GetMapping("/getByAreaNumbers")
  @ResponseBody
  public CitizenList getByAreaNumber(@RequestParam("areaNumbers") List<String> areaNumbers) {
    LOGGER.info("Get citizens by area numbers");
    return citizenService.getCitizensByAreaNumbers(areaNumbers);
  }

  /**
   * get citizen by id
   *
   * @param id id
   * @return citizen
   */
  @GetMapping("/get")
  @ResponseBody
  public Citizen getById(@RequestParam("id") int id) {
    LOGGER.info("Get citizen by id");
    return citizenService.getById(id);
  }
}
