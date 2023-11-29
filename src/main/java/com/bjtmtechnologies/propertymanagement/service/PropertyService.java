package com.bjtmtechnologies.propertymanagement.service;

import com.bjtmtechnologies.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
}
