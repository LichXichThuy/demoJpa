package com.cybersoft.demoJPA.repository;

import com.cybersoft.demoJPA.dto.RoleDTO;
import com.cybersoft.demoJPA.entity.RolesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RolesEntity, Integer> {
    List<RolesEntity> findByName(String name);
}

