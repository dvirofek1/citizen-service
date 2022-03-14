package com.ebay.citizenservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "citizen")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Citizen {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private long id;

  private String privateId;
  private String firstName;
  private String lastName;
  private String city;
  private String phone;
  private String guardianID;
  private String areaNumber;
}
