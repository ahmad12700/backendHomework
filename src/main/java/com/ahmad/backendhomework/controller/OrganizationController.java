package com.ahmad.backendhomework.controller;

import com.ahmad.backendhomework.model.GeneralResponseModel;
import com.ahmad.backendhomework.model.OrgElementModel;
import com.ahmad.backendhomework.model.OrganizationModel;
import com.ahmad.backendhomework.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;

@RestController
@RequestMapping(path = "api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }

    @GetMapping
    GeneralResponseModel<OrganizationModel> getOrganization() {
        return new GeneralResponseModel<OrganizationModel>().successWithData(new OrganizationModel(organizationService.getOrganization()));
    }

    @PostMapping
    GeneralResponseModel<OrgElementModel> saveOrganization(@Valid @RequestBody  OrgElementModel orgElementModel) {
        try {
            return new GeneralResponseModel<OrgElementModel>().successWithData(organizationService.saveOrganization(orgElementModel));
        }catch (DataIntegrityViolationException e){
            return new GeneralResponseModel<OrgElementModel>().error("can't find parent element","1");
        }
    }
    @PutMapping()
    GeneralResponseModel<OrgElementModel> updateOrganization(@Valid @RequestBody OrgElementModel orgElementModel){

        OrgElementModel orgElementModel1;
        try {
         orgElementModel1 =  organizationService.updateOrganization(orgElementModel);
        }catch (DataIntegrityViolationException e){
            return new GeneralResponseModel<OrgElementModel>().error("can't update",
                    "1");
        }
        return new GeneralResponseModel<OrgElementModel>().successWithData(orgElementModel1);
    }
    @DeleteMapping(path = "/{id}")
    GeneralResponseModel<Null> deleteOrganization(@PathVariable Long id){
        try {
            organizationService.deleteOrganization(id);
        }catch (DataIntegrityViolationException sE){
            return new GeneralResponseModel<Null>().error("please delete the sub elements below the requested element first!!!",
                    "1"
                    );
        }catch (EmptyResultDataAccessException eE){
            return new GeneralResponseModel<Null>().error("can't find this row!!!",
                    "2");
        }
        return new GeneralResponseModel<Null>().successAck();

    }
}
