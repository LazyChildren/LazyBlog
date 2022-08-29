package me.lazychildren.service;

import me.lazychildren.entity.User;
import me.lazychildren.entity.UserInfo;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Transactional
public interface UserService {
    public boolean addUser(User user);
    public boolean deleteUser(Integer id);
    public boolean updateUser(User user);
    public User getUserById(Integer id);
    public User getUserByPhone(String phone);
    public UserInfo getUserInfoById(Integer id);
    public boolean userLog(User user,Boolean online);
    public boolean setAttributes(HttpSession session,User user);
}
