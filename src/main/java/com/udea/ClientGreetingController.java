/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pedro Gallego
 */
public class ClientGreetingController {
    protected ClientGreetingService helloWordService;

    public ClientGreetingController(ClientGreetingService helloWordService) {
        this.helloWordService = helloWordService;
    }
    
    @RequestMapping("/customer")
    public String goHome () {
        return "index";
    }
    
    @RequestMapping ("/customer/(id)")
    public String Greeting (Model model, @RequestParam(value="id") long id) {
        Customer greeting = helloWordService.greeting(id);
        Map<String, Object> params = new HashMap <> () ;
        params.put ("email", greeting.getEmail());
        params.put("name", greeting.getName());
        model.addAllAttributes(params);
        return "greeting";
    }
    
    
    
}
