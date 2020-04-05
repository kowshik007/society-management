package com.application.start.service;

import com.application.start.dao.MemberDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class MemberService implements MemberServiceInterface {
    @Autowired
    private MemberDAOInterface memberDAOInterface;
    @Override
    @Transactional
    public Set getMemberDetails(String category,int homeid) {
        return memberDAOInterface.getMemberDetails(category,homeid);
    }

    @Override
    @Transactional
    public Set getDeliveryDetails(String category, int homeid) {
        return memberDAOInterface.getDeliveryDetails(category, homeid);
    }
}
