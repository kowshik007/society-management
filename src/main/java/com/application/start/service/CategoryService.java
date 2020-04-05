package com.application.start.service;

import com.application.start.dao.CategoryDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class CategoryService implements CategoryInterface {
    @Autowired
    private CategoryDAOInterface categoryDAOInterface;
    @Override
    @Transactional
    public Set getList(String name) {
        return categoryDAOInterface.getList(name);
    }
}
