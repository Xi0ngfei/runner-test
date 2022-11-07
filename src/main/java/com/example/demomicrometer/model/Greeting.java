package com.example.demomicrometer.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Greeting {

    private long time;

    private String message;

}