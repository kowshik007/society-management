package com.application.start.restcontroller;

import com.application.start.entity.TblClient;
import com.application.start.service.TblClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TblClientRestController {
    @Autowired
    private TblClientServiceInterface tblClientServiceInterface;
    @GetMapping(value = "/clients")
    private Set<TblClient> getClientList(){
        return tblClientServiceInterface.getClientList();
    }
}
