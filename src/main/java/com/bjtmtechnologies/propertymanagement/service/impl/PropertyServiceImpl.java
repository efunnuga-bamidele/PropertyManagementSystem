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
import java.util.Optional;

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

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();

            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setDescription(propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }
}
