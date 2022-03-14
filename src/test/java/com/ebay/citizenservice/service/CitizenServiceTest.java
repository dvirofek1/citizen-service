package com.ebay.citizenservice.service;

import com.ebay.citizenservice.data.CitizenList;
import com.ebay.citizenservice.model.Citizen;
import com.ebay.citizenservice.repository.CitizenRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CitizenServiceTest {
  private static final Logger LOGGER = LogManager.getLogger(CitizenServiceTest.class);

  private static List<String> areaNumbers;
  private static List<Citizen> citizenList1;
  private static List<Citizen> citizenList2;
  @Autowired CitizenService citizenService;
  @MockBean CitizenRepository citizenRepository;

  @BeforeAll
  static void init() {
    areaNumbers = new ArrayList<>();
    citizenList1 = new ArrayList<>();
    citizenList2 = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      citizenList1.add(
          new Citizen(
              (1L + i),
              "123" + i,
              "dvir" + i,
              "benita" + i,
              "Jerusalem",
              "054260687" + i,
              "",
              "1"));
    }
    for (int i = 0; i < 10; i++) {
      citizenList2.add(
          new Citizen(
              (1L + i),
              "12" + i,
              "moti" + i,
              "benita" + i,
              "Tel Aviv",
              "054260686" + i,
              "123" + i,
              "2"));
    }
  }

  @Test
  void getCitizensByAreaNumbers() {
    LOGGER.info("mocking repository");
    Mockito.when(citizenRepository.findAllByAreaNumber("1")).thenReturn(citizenList1);
    areaNumbers.add("1");
    CitizenList citizenList = citizenService.getCitizensByAreaNumbers(areaNumbers);
    LOGGER.info("assert the returned list are equals");
    for (int i = 0; i < citizenList.getCitizenList().size(); i++) {
      Assertions.assertEquals(
          citizenList1.get(i).getId(), citizenList.getCitizenList().get(i).getId());
    }
    LOGGER.info("assert area numbers are not equals");
    for (int i = 0; i < citizenList.getCitizenList().size(); i++) {
      Assertions.assertNotEquals(
          citizenList2.get(i).getAreaNumber(), citizenList.getCitizenList().get(i).getAreaNumber());
    }
  }

  @Test
  void getById() {
    Mockito.when(citizenRepository.getById(1L)).thenReturn(citizenList1.get(0));
    Citizen citizen = citizenService.getById(1L);
    Assertions.assertEquals(citizen.getId(), 1L);
  }
}
