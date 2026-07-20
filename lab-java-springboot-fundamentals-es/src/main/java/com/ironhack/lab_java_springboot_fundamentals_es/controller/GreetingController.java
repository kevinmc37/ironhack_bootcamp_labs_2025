package com.ironhack.lab_java_springboot_fundamentals_es.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @GetMapping("/hello")
    public String hello() { return "Hello World!"; }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) { return "Hello " + name + "!"; }

    @GetMapping("/add/{num1}/{num2}")
    public int add(@PathVariable int num1, @PathVariable int num2) { return num1 + num2; }

    @GetMapping("/multiply/{num1}/{num2}")
    public int multiply(@PathVariable int num1, @PathVariable int num2) { return num1 * num2; }
}
