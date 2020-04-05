package com.application.start.service;

import com.application.start.dao.SocietyDAOInterface;
import com.application.start.entity.Society;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SocietyService implements SocietyInterface{
    @Autowired
    private SocietyDAOInterface societyDAOInterface;

    @Override
    @Transactional
    public List<Society> getSocietyList() {
        return societyDAOInterface.getSocietyList();
    }

    @Override
    @Transactional
    public Society createSociety(Society society) {
        return societyDAOInterface.createSociety(society);
    }

    @Override
    @Transactional
    public Society updateSociety(int id, Society society) {
        return societyDAOInterface.updateSociety(id,society);
    }

    @Override
    @Transactional
    public Society getSociety(int id) {
        return societyDAOInterface.getSociety(id);
    }
}
