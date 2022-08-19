package com.example.demo.dto;

import lombok.Data;

@Data
public class MallRequest {
    private String to;
    private String from;
    private String subject;
    private String text;
}
