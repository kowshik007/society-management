package com.application.start.dao;

import com.application.start.entity.Society;

import java.util.List;

public interface SocietyDAOInterface {
    public List<Society> getSocietyList();
    public Society createSociety(Society society);
    public Society updateSociety(int id,Society society);
    public Society getSociety(int id);
}
