package com.application.start.service;

import com.application.start.dao.TblClientDAOInterface;
import com.application.start.entity.TblClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class TblClientService implements TblClientServiceInterface {
    @Autowired
    private TblClientDAOInterface tblClientDAOInterface;
    @Override
    @Transactional
    public Set<TblClient> getClientList() {
        return tblClientDAOInterface.getClientList();
    }
}
