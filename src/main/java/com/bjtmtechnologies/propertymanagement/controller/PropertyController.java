package com.bjtmtechnologies.propertymanagement.controller;

import com.bjtmtechnologies.propertymanagement.dto.PropertyDTO;
import com.bjtmtechnologies.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
       List<PropertyDTO> propertyList =  propertyService.getAllProperties();
       return new ResponseEntity<>(propertyList, HttpStatus.OK);
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyService.updateProperty(propertyDTO, propertyId);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.CREATED);
    }
}
