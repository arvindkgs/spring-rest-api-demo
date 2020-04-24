package com.spring.rest_api_demo.controller;

import com.spring.rest_api_demo.model.Input;
import com.spring.rest_api_demo.model.Result;
import com.spring.rest_api_demo.service.Calculate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ApiController {
    @PostMapping("/add")
    public Result add(@RequestBody Input input){
        int x = Integer.parseInt(input.getX());
        int y = Integer.parseInt(input.getY());
        return new Result(Calculate.add(x,y) +"");
    }
    @PostMapping("/diff")
    public Result diff(@RequestBody Input input){
        int x = Integer.parseInt(input.getX());
        int y = Integer.parseInt(input.getY());
        return new Result(Calculate.diff(x,y) +"");
    }
}
