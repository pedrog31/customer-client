/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pedro Gallego
 */
@Controller
public class ClientGreetingHomeController {
    @RequestMapping("/")
    public String home () {
        return "index";
    }
}
