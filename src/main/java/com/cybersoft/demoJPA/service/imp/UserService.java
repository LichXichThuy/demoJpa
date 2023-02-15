package com.cybersoft.demoJPA.service.imp;

import com.cybersoft.demoJPA.entity.UsersEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;


public interface UserService {
    UsersEntity saveUser(UsersEntity usersEntity);
}
