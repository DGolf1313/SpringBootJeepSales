package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
    scripts = {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql", 
      "classpath:flyway/migrations/V1.1__Jeep_Data.sql"}, 
    config = @SqlConfig(encoding = "utf-8"))
class FetchJeepTest extends FetchJeepTestSupport{

  @Test
  void testDb() {
    
  }
  
  
  @Disabled
  @Test
  void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
      //Given: a valid model, trim and URI
      JeepModel model = JeepModel.WRANGLER;
      String trim = "Sport";
      String uri = 
          String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim );
      
      System.out.println(uri);
      //When: a connection is made to the URI
      ResponseEntity<List<Jeep>> response = 
          getRestTemplate().exchange(uri, HttpMethod.GET, null, 
              new ParameterizedTypeReference<>() {});
      
      //Then: a valid status code is returned.
      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
      
      //And that the actual list is the same as the expected list.
      List<Jeep> expected = buildExpected();
      System.out.println(expected);
      assertThat(response.getBody()).isEqualTo(expected);
      
    }

  
  
}
