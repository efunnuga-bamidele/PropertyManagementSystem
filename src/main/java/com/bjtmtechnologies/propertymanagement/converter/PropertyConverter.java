package com.bjtmtechnologies.propertymanagement.converter;

import com.bjtmtechnologies.propertymanagement.dto.PropertyDTO;
import com.bjtmtechnologies.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOToEntity(PropertyDTO propertyDTO) {
        //convert property DTO into Entity type
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setDescription(propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());

        return pe;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        PropertyDTO pd = new PropertyDTO();
        pd.setTitle(propertyEntity.getTitle());
        pd.setAddress(propertyEntity.getAddress());
        pd.setOwnerEmail(propertyEntity.getOwnerEmail());
        pd.setOwnerName(propertyEntity.getOwnerName());
        pd.setDescription(propertyEntity.getDescription());
        pd.setPrice(propertyEntity.getPrice());

        return pd;

    }
}
