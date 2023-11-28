package com.bjtmtechnologies.propertymanagement.service.impl;

import com.bjtmtechnologies.propertymanagement.dto.PropertyDTO;
import com.bjtmtechnologies.propertymanagement.entity.PropertyEntity;
import com.bjtmtechnologies.propertymanagement.repository.PropertyRepository;
import com.bjtmtechnologies.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        //convert property DTO into Entity type
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setDescription(propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());

        propertyRepository.save(pe);
        return null;
    }
}
