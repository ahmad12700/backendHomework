package com.ahmad.backendhomework.repo;

import com.ahmad.backendhomework.entity.OrgElementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mariaRepo")
public interface OrganizationRepoMaria extends JpaRepository<OrgElementEntity, Long>, IOrganizationRepo {
}
