package com.promineotech.jeep.entity;

import lombok.Data;

@Data
public class Customer {
  private long customerPK;
  private String customerId;
  private String firstName;
  private String lastName;
  private String phone;

}
