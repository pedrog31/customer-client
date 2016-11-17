/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Pedro Gallego
 */
@Service
public class ClientGreetingService {
    @Autowired
    protected RestTemplate restTemplate;
    protected String serviceUrl;
    public ClientGreetingService (String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl: "http://" + serviceUrl;
    }
    public Customer greeting (long id) {
        return restTemplate.getForObject(serviceUrl + "/customer2id=(name)", Customer.class,id);
    }
    public Customer greetingDefault (long id) {
        return new Customer (id);
    }
}
