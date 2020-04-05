package com.application.start.service;

import com.application.start.entity.Society;

import java.util.List;

public interface SocietyInterface {
    public List<Society> getSocietyList();
    public Society createSociety(Society society);
    public Society updateSociety(int id,Society society);
    public Society getSociety(int id);
}
