package com.encodecode.base.service;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class Base64EncodeService {
    public String encodeString(String value){
        return Base64.getEncoder().encodeToString(value.getBytes());
    }
}
