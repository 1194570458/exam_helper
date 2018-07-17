package com.kason.app.service.impl;

import com.kason.app.dao.PropertyMapper;
import com.kason.app.entity.Property;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public Property addProperty(Property property) {
        propertyMapper.insertSelective(property);
        return property;
    }

    @Override
    public Property updateProperty(Property property) {
        propertyMapper.updateByPrimaryKeySelective(property);
        return propertyMapper.selectByPrimaryKey(property.getProId());
    }

    @Override
    public List<Property> getPropertys() {
        List<Property> properties = propertyMapper.selectAll();
        return properties;
    }

    @Override
    public Property getProperty(Integer id) {
        Property property = propertyMapper.selectByPrimaryKey(id);
        return property;
    }

    @Override
    public void delProperty(Integer id) {
        try {
            propertyMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new AppException(ResultEnum.PROPERTY_USED);
        }
    }
}
