package com.bjtmtechnologies.propertymanagement.service.impl;

import com.bjtmtechnologies.propertymanagement.converter.PropertyConverter;
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

    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
       PropertyEntity pe =  propertyConverter.convertDTOToEntity(propertyDTO);
       pe = propertyRepository.save(pe);

       return propertyConverter.convertEntityToDTO(pe);
    }
}
