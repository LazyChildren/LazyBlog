package me.lazychildren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import me.lazychildren.dao.UserLogDao;
import me.lazychildren.entity.LoginLog;
import me.lazychildren.entity.User;
import me.lazychildren.entity.UserInfo;
import me.lazychildren.dao.UserDao;
import me.lazychildren.dao.UserInfoDao;
import me.lazychildren.service.UserService;
import me.lazychildren.util.GloabalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    UserLogDao logDao;

    @Autowired
    UserInfoDao userInfoDao;


    @Override
    public User getUserById(Integer id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        User user = userDao.selectOne(wrapper);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        log.info("ADD NEW USER\n" + user.toString());

        return userDao.insert(user)>0;

    }

    @Override
    public boolean deleteUser(Integer id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return userDao.delete(wrapper)>0;
    }

    @Override
    public boolean updateUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",user.getId());

        userDao.update(user,wrapper);
        return false;
    }

    @Override
    public User getUserByPhone(String phone) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone",phone);
        User user = userDao.selectOne(wrapper);
        return user;
    }

    @Override
    public UserInfo getUserInfoById(Integer id) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",id);
        return userInfoDao.selectOne(wrapper);
    }

    @Override
    public boolean userLog(User user,Boolean online) {
        LoginLog loginLog = new LoginLog(user,online);
        logDao.insert(loginLog);
        return true;
    }


    @Override
    public boolean setAttributes(HttpSession session, User user) {
        session.setAttribute("user",user);
        session.setAttribute("userinfo",userInfoDao.selectById(user.getId()));

        return false;
    }
}
