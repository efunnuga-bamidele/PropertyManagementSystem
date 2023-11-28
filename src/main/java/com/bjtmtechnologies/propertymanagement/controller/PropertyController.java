package com.bjtmtechnologies.propertymanagement.controller;

import com.bjtmtechnologies.propertymanagement.dto.PropertyDTO;
import com.bjtmtechnologies.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired //this is required for spring to do dependency injection from the service interface into the controller
    private PropertyService propertyService;

    //http://127.0.0.1:3010/api/v1/properties/hello
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello ";
    }

    @PostMapping("/properties")
    public PropertyDTO saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyService.saveProperty(propertyDTO);
        System.out.println(propertyDTO);
        return propertyDTO;
    }
}
