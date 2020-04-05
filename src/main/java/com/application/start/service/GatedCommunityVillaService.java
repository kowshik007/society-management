package com.application.start.service;

import com.application.start.dao.GatedCommunityVillaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class GatedCommunityVillaService implements GatedCommunityVillaServiceInterface{
    @Autowired
    private GatedCommunityVillaInterface gatedCommunityVillaInterface;
    @Override
    @Transactional
    public Set villaHomeList(int id) {
        return gatedCommunityVillaInterface.villaHomeList(id);
    }
}
