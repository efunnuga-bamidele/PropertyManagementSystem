package com.bjtmtechnologies.propertymanagement.service.impl;

import com.bjtmtechnologies.propertymanagement.converter.PropertyConverter;
import com.bjtmtechnologies.propertymanagement.dto.PropertyDTO;
import com.bjtmtechnologies.propertymanagement.entity.PropertyEntity;
import com.bjtmtechnologies.propertymanagement.repository.PropertyRepository;
import com.bjtmtechnologies.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;
    @Override

    public PropertyDTO saveProperty(PropertyDTO propertyDTO) { //Save Request
       PropertyEntity pe =  propertyConverter.convertDTOToEntity(propertyDTO);
       pe = propertyRepository.save(pe);
       propertyDTO = propertyConverter.convertEntityToDTO(pe);

       return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() { // Get All Request
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();
        for(PropertyEntity pe : listOfProps){
          PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
          propList.add(dto);
        }
        return propList;
    }
}
