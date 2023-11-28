package com.bjtmtechnologies.propertymanagement.repository;

import com.bjtmtechnologies.propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

//parameters for CrudRepository are entity and datatype of id column
public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
}
