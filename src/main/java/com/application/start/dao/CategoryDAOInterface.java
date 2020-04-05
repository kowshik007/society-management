package com.application.start.dao;

import com.application.start.entity.Apartment;
import com.application.start.entity.Category;
import com.application.start.entity.Villa;

import java.util.Set;

public interface CategoryDAOInterface {
    public Set getList(String name);
}
