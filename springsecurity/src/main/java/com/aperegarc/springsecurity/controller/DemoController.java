
package com.aperegarc.springsecurity.controller;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String showDemo(){
        return "Hello from Demo";
    }

}