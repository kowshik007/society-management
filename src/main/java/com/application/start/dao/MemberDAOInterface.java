package com.application.start.dao;

import java.util.Set;

public interface MemberDAOInterface {
    public Set getMemberDetails(String category,int homeid);
    public Set getDeliveryDetails(String category,int homeid);
}
