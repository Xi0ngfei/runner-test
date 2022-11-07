package com.example.demomicrometer.controller;
/**
 * Author: wesley.zhi@ingka.ikea.com
 */

import com.example.demomicrometer.model.Greeting;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Goodbye, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    @Timed(description = "Time taken to return greeting", percentiles = { 0.5, 0.90 })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws InterruptedException {
        Random rand =new Random(500);
        int i=rand.nextInt(7000);
        Thread.sleep(Long.parseLong(""+i));
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}