package com.kason.app.service;

import com.kason.app.entity.Property;

import java.util.List;

public interface PropertyService {
    Property addProperty(Property property);

    Property updateProperty(Property property);

    List<Property> getPropertys();

    Property getProperty(Integer id);

    void delProperty(Integer id);

    List<Property> getNewPropertys(Integer id);
}
