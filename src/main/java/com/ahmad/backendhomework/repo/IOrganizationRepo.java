package com.ahmad.backendhomework.repo;


import com.ahmad.backendhomework.entity.OrgElementEntity;

import java.util.List;

public interface IOrganizationRepo {
    List<OrgElementEntity> findAll();

    OrgElementEntity save(OrgElementEntity toEntity);

    void deleteById(Long id);
}
