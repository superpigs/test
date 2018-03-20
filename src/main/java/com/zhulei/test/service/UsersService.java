package com.zhulei.test.service;

import com.zhulei.test.dao.UsersDao;
import com.zhulei.test.entity.Users;
import org.omg.CORBA.TRANSACTION_REQUIRED;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsersService {
    @Resource
    private UsersDao usersDao;

    public Users login(String uname,String upwd){
        Users users = usersDao.findByUnameAndUpwd(uname,upwd);
        if(users != null){
            String token = UUID.randomUUID().toString();
            usersDao.updateToken(users.getUid(),token);
            users.setToken(token);
        }
        return users;
    }

    public Users regist(Users users){
        String token = UUID.randomUUID().toString();
        users.setToken(token);
        int count = usersDao.add(users);
        if(count > 0){
            return users;
        }else{
            return null;
        }
    }
}
