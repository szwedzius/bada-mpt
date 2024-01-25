package com.database.MPT.controller;

import com.database.MPT.model.Adresy;
import com.database.MPT.model.Poczty;
import com.database.MPT.model.Pracownicy;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;

@Controller
public class WebController {

    @GetMapping("/showAdresy")
    public void showAdresy(Model model) {
        String apiUrl = "http://localhost:8080/api/admin/adresy";
        String username = "admin";
        String password = "1234";

        // Set up RestTemplate with Basic Authentication
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        // Make a GET request
        ResponseEntity<Adresy[]> responseEntity = restTemplate.getForEntity(apiUrl, Adresy[].class, httpEntity);

        // Handle the response
        Adresy[] responseBody = responseEntity.getBody();
        model.addAttribute("adresy", responseBody);
    }

    @GetMapping("/userAdresy")
    public void userAdresy(Model model) {
        String apiUrl = "http://localhost:8080/api/employee/adresy";
        String username = "user";
        String password = "123";

        // Set up RestTemplate with Basic Authentication
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        // Make a GET request
        ResponseEntity<Adresy[]> responseEntity = restTemplate.getForEntity(apiUrl, Adresy[].class, httpEntity);

        // Handle the response
        Adresy[] responseBody = responseEntity.getBody();
        model.addAttribute("adresy", responseBody);
    }

    @GetMapping("/showPoczty")
    public void showPoczty(Model model) {
        String apiUrl = "http://localhost:8080/api/admin/poczty";
        String username = "admin";
        String password = "1234";

        // Set up RestTemplate with Basic Authentication
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        // Make a GET request
        ResponseEntity<Poczty[]> responseEntity = restTemplate.getForEntity(apiUrl, Poczty[].class, httpEntity);

        // Handle the response
        Poczty[] responseBody = responseEntity.getBody();
        model.addAttribute("poczty", responseBody);
    }

    @GetMapping("/userPoczty")
    public void userPoczty(Model model) {
        String apiUrl = "http://localhost:8080/api/employee/poczty";
        String username = "admin";
        String password = "1234";

        // Set up RestTemplate with Basic Authentication
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        // Make a GET request
        ResponseEntity<Poczty[]> responseEntity = restTemplate.getForEntity(apiUrl, Poczty[].class, httpEntity);

        // Handle the response
        Poczty[] responseBody = responseEntity.getBody();
        model.addAttribute("poczty", responseBody);
    }

    @GetMapping("/showPracownicy")
    public void showPracownicy(Model model) {
        String apiUrl = "http://localhost:8080/api/admin/pracownicy";
        String username = "admin";
        String password = "1234";

        // Set up RestTemplate with Basic Authentication
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        // Make a GET request
        ResponseEntity<Pracownicy[]> responseEntity = restTemplate.getForEntity(apiUrl, Pracownicy[].class, httpEntity);

        // Handle the response
        Pracownicy[] responseBody = responseEntity.getBody();
        model.addAttribute("pracownicy", responseBody);
    }

    @GetMapping("/user")
    public void userPracownicy(Model model) {
        String apiUrl = "http://localhost:8080/api/employee/pracownicy";
        String username = "admin";
        String password = "1234";

        // Set up RestTemplate with Basic Authentication
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        // Make a GET request
        ResponseEntity<Pracownicy> responseEntity = restTemplate.getForEntity(apiUrl, Pracownicy.class, httpEntity);

        // Handle the response
        Pracownicy responseBody = responseEntity.getBody();
        model.addAttribute("pracownik", responseBody);
    }


}
