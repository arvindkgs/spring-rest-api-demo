package com.spring.rest_api_demo.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CalculateServiceImpl implements CalculateService {
    public Integer add(int x, int y){
        return x+y;
    }

    public Integer diff(int x, int y) {
        return x-y;
    }
}
