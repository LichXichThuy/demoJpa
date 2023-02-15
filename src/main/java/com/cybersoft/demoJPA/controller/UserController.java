package com.cybersoft.demoJPA.controller;

import com.cybersoft.demoJPA.entity.RolesEntity;
import com.cybersoft.demoJPA.entity.UsersEntity;
import com.cybersoft.demoJPA.repository.RoleRepository;
import com.cybersoft.demoJPA.service.UserServiceIMP;
import com.cybersoft.demoJPA.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceIMP userServiceIMP;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("")
    public ResponseEntity<?> addUser(
//            @RequestParam int id,
            @RequestParam String email,
            @RequestParam String passWord,
            @RequestParam String fullName,
            @RequestParam String avatar,
            @RequestParam String roleName
    ){
        UsersEntity usersEntity = new UsersEntity();
//        usersEntity.setId(id);
        usersEntity.setEmail(email);
        usersEntity.setPassWord(passWord);
        usersEntity.setFullName(fullName);
        usersEntity.setAvatar(avatar);

        List<RolesEntity> listRole = roleRepository.findByName(roleName);
        usersEntity.setRoles(listRole.get(0));

        return new  ResponseEntity<>(userServiceIMP.isAddUser(usersEntity), HttpStatus.OK);
    }
}
