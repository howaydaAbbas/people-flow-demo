package com.people.flow.demo.controller;

import com.people.flow.demo.PeopleFlowApplication;
import com.people.flow.demo.dto.EmployeeDTO;
import com.people.flow.demo.service.generator.GenerateStubs;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PeopleFlowApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @LocalServerPort
    private int port;

    @Test
    public void addEmployeeSuccessIT() {

        EmployeeDTO employeeDTO = GenerateStubs.generateEmployeeDTO();
        HttpEntity<EmployeeDTO> entity = new HttpEntity<>(employeeDTO, headers);
        ResponseEntity<EmployeeDTO> response = restTemplate.exchange(
                establishPortAndURIPort("/api/employee"),
                HttpMethod.POST, entity, EmployeeDTO.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void changeEmployeeStateFailureIT() {

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity response = restTemplate.exchange(
                establishPortAndURIPort("/api/employee/95b09e35-cffa-44dc-8e4c-bb159eeb9645/APPROVED"),
                HttpMethod.PATCH, entity, String.class);

        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    private String establishPortAndURIPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
