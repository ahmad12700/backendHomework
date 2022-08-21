package com.ahmad.backendhomework.service;

import com.ahmad.backendhomework.model.OrgElementModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationServiceTest {
    @Autowired
    OrganizationService organizationService;

    void getOrganization(){
        List<OrgElementModel> modelList = organizationService.getOrganization();
        for (OrgElementModel elementModel: modelList
             ) {
            System.out.println(elementModel.toString());

        }
    }

}