package com.wildcodeschool.myProjectWithSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/remove")
    public String hello() {
        return "Hello World!!!";
    }
    
    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin!!!"; 
    }       
        
//  AVENGERS        
    @GetMapping("/")
    public String anyones() {
        return "Welcome to the SHIELD";
    }    
        
    @GetMapping("/avengers/assemble")
    public String champions() {
        return "Avengers... Assemble";
    }    
       
    
    @GetMapping("/secret-bases")
    public String director() {
       return "Biarritz, Bordeaux, La loupe, Lille, Lyon, Marseille, Nantes, Orleans, Paris, Reims, Strasbours, Toulouse, Tours";
    }         
       
    
}