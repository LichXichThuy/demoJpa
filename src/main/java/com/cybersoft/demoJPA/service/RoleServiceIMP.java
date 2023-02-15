package com.cybersoft.demoJPA.service;

import com.cybersoft.demoJPA.dto.RoleDTO;
import com.cybersoft.demoJPA.entity.RolesEntity;
import com.cybersoft.demoJPA.repository.RoleRepository;
import com.cybersoft.demoJPA.service.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceIMP implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAllRole() {
        List<RolesEntity> listRole = roleRepository.findAll();
        List<RoleDTO> dtoList = new ArrayList<>();

        for (RolesEntity data: listRole){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setDesc(data.getDesc());

            dtoList.add(roleDTO);
        }
        return dtoList;
    }

    @Override
    public List<RoleDTO> getRoleByName(String name) {
        List<RolesEntity> listRole = roleRepository.findByName(name);
        List<RoleDTO> dtoList = new ArrayList<>();

        for (RolesEntity data: listRole){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setDesc(data.getDesc());

            dtoList.add(roleDTO);
        }
        return dtoList;
    }
}
