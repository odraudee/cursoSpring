package com.example.appREST.Controllers;

import com.example.appREST.Entities.Laptop;
import com.example.appREST.Repositories.LaptopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class LaptopControllerTest {
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;
    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
//        ResponseEntity<Laptop[]> response  =
//                testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(200, response.getStatusCodeValue());
//
//        List<Laptop> books = Arrays.asList(response.getBody());
//        System.out.println(books.size());
    }

    @Test
    void getByid() {
//        ResponseEntity<Laptop> response  =
//                testRestTemplate.getForEntity("/api/books/24", Laptop.class);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void save() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//        String json = """
//                {
//                    "id": null,
//                    "manufacturer": "Toshiba",
//                    "model": "satellite",
//                    "processor": "i7",
//                    "memoryRam": 16
//                  }
//                """;
//
//        HttpEntity<String> request = new HttpEntity<>(json,headers);
//
//        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
//
//        Laptop result = response.getBody();
//
//        assertEquals("satellite", result.getModel());
    }

    @Test
    void update() {
    }

    @Test
    void deleteByid() {
    }

    @Test
    void deleteAll() {
    }
}