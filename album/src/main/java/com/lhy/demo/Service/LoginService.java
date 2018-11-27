package com.lhy.demo.Service;

import com.lhy.demo.Entity.User;
import com.lhy.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pc on 2018/9/5.
 */
@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    public boolean checkPass(String username, String password){
       if (userMapper.findUserByNameAndPassword(username, password) != null)
           return true;
        return false;
    }

    public boolean addUser(String username, String password){
        User user = new User();
        user.setUser_id(null);
        user.setUser_name(username);
        user.setUser_password(password);
        if(userMapper.addUser(user) > 0)
            return true;
        return false;
    }

    public Integer getUserId(String username){
        return userMapper.findUserId(username);
    }
}
