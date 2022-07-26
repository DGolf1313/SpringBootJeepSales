package com.promineotech.jeep.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FetchJeepTest extends FetchJeepTestSupport{

  @Test
  void test() {
    System.out.println(getBaseUri());
  }

}
