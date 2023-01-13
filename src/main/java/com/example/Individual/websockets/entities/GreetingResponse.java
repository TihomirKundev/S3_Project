package com.example.Individual.websockets.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String text;

    public String getText(){
        return text;
    }
}
