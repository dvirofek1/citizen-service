package com.ebay.citizenservice.data;

import com.ebay.citizenservice.model.Citizen;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CitizenList {
  private final List<Citizen> citizenList;
}
