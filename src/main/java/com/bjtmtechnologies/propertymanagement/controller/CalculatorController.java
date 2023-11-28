package com.bjtmtechnologies.propertymanagement.controller;

import com.bjtmtechnologies.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")  //this is a class level mapping from url to a controller class
public class CalculatorController {

    //http://127.0.0.1:3010/api/v1/calculator/add?param1=12.1&param2=6.3
    @GetMapping("/add") // this is method level mapping from url to a controller function
    public Double add(@RequestParam("param1") Double param1, @RequestParam("param2") Double param2) {
        return param1 + param2;
    }

    @GetMapping("/subtract/{param1}/{param2}") // this is a method level mapping from url to java variables by path variable method
    public Double subtract(@PathVariable("param1") Double param1, @PathVariable("param2") Double param2) {
        Double result = null;
        if (param1 > param2) {
            result = param1 - param2;
        } else {
            result = param2 - param1;
        }
        return result;
    }

    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        // ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);  //redundant code, used inline implementation instead
        return new ResponseEntity<Double>(result, HttpStatus.CREATED);
    }

}
