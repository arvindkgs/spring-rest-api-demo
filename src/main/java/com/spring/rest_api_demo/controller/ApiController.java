package com.spring.rest_api_demo.controller;

import com.spring.rest_api_demo.model.Input;
import com.spring.rest_api_demo.model.Result;
import com.spring.rest_api_demo.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ApiController {
    @Autowired
    CalculateService calculateService;

    @PostMapping("/add")
    public Result add(@RequestBody Input input){
        if(input == null || input.getX() == null || input.getY() == null)
            throw new JsonParseException();
        int x = Integer.parseInt(input.getX());
        int y = Integer.parseInt(input.getY());
        return new Result(calculateService.add(x,y) +"");
    }
    @PostMapping("/diff")
    public Result diff(@RequestBody Input input){
        int x = Integer.parseInt(input.getX());
        int y = Integer.parseInt(input.getY());
        return new Result(calculateService.diff(x,y) +"");
    }
}
