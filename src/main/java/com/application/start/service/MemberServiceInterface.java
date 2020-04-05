package com.application.start.service;

import java.util.Set;

public interface MemberServiceInterface {
    public Set getMemberDetails(String category,int homeid);
    public Set getDeliveryDetails(String category,int homeid);

}
