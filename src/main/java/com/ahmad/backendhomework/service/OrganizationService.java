package com.ahmad.backendhomework.service;

import com.ahmad.backendhomework.entity.OrgElementEntity;
import com.ahmad.backendhomework.model.OrgElementModel;
import com.ahmad.backendhomework.repo.IOrganizationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService {
    final private IOrganizationRepo organizationRepo;
    final String TYPE_SECTOR = "sector";
    final String TYPE_DEPT = "dept";
    final String TYPE_SECTION = "section";
    @Autowired
    OrganizationService(@Qualifier("mariaRepo")IOrganizationRepo organizationRepo){
        this.organizationRepo = organizationRepo;
    }

    public List<OrgElementModel> getOrganization() {
        List<OrgElementModel> orgElements = new ArrayList<>();
        List<OrgElementEntity> entities = organizationRepo.findAll();
        for(OrgElementEntity entity: entities){

            orgElements.add(toModel(entity));
        }
        return orgElements;
    }

    public OrgElementModel saveOrganization(OrgElementModel orgElementModel)throws DataIntegrityViolationException {
            OrgElementEntity resultEntity = organizationRepo.save(toEntity(orgElementModel));

        return toModel(resultEntity);
    }

    public OrgElementModel updateOrganization(OrgElementModel orgElementModel) throws DataIntegrityViolationException{
        OrgElementEntity entity = organizationRepo.save(toEntity(orgElementModel));
        return toModel(entity);
    }

    public void deleteOrganization(Long id) throws DataIntegrityViolationException, EmptyResultDataAccessException{

            organizationRepo.deleteById(id);

    }

    private OrgElementEntity toEntity(OrgElementModel orgElementModel){
        String sector = null;
        String dept = null;
        String section = null;
        switch (orgElementModel.getType()) {
            case TYPE_DEPT -> dept = orgElementModel.getName();
            case TYPE_SECTION -> section = orgElementModel.getName();
            default -> sector = orgElementModel.getName();

        }
        return new OrgElementEntity(orgElementModel.getId(), orgElementModel.getParentId(), sector, dept, section);

    }
    private OrgElementModel toModel(OrgElementEntity orgElementEntity){
        String name = null;
        String type = null;
        if(orgElementEntity.getSector() !=null){
            name = orgElementEntity.getSector();
            type = TYPE_SECTOR;
        }else
        if(orgElementEntity.getDepartment() !=null){
            name = orgElementEntity.getDepartment();
            type = TYPE_DEPT;
        }else
        if(orgElementEntity.getSection() !=null){
            name = orgElementEntity.getSection();
            type = TYPE_SECTION;
        }


        return new OrgElementModel(orgElementEntity.getId(),orgElementEntity.getParentId(),name, type);
    }


}
