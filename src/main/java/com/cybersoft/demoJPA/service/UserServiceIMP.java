package com.cybersoft.demoJPA.service;

import com.cybersoft.demoJPA.entity.UsersEntity;
import com.cybersoft.demoJPA.repository.UserRepository;
import com.cybersoft.demoJPA.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMP implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UsersEntity saveUser(UsersEntity usersEntity) {
        UsersEntity userResponse = userRepository.save(usersEntity);
        return userResponse;
    }

    public boolean isAddUser(UsersEntity usersEntity){
        List<UsersEntity> usersEntityList = new ArrayList<>();
        usersEntityList.add(saveUser(usersEntity));

        return usersEntityList.size() != 0;
    }
}
