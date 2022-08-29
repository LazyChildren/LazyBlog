package me.lazychildren.controller;


import me.lazychildren.entity.UserInfo;
import me.lazychildren.entity.Result;
import me.lazychildren.entity.User;
import me.lazychildren.service.UserService;
import me.lazychildren.util.GloabalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Hashtable;





@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/login")
    public Result userLogin(@RequestBody User preUser, HttpServletRequest request){
        /*1.获取用户实体*/
        User user = userService.getUserByPhone(preUser.getPhone());
        if(user == null)
            return Result.fail("用户不存在",Result.RESULT_ERROR);

        if(!preUser.getPassword().equals(user.getPassword()))
            return Result.fail("密码错误",Result.RESULT_ERROR);






        UserInfo userInfo = userService.getUserInfoById(user.getId());
        Hashtable<String,Object> userResult = new Hashtable<>();
        userResult.put("user",user);
        userResult.put("userinfo",userInfo);
        userService.setAttributes(request.getSession(),user);
        userService.userLog(user,GloabalUtil.USER_LOGIN);
        return Result.succ(userResult);

    }

    @PostMapping("/register")
    public Result registerUser(@RequestBody User preuser, HttpServletRequest request)
    {
        if(!userService.addUser(preuser))
            return Result.fail("该手机已经注册过啦!",Result.RESULT_ERROR);
        userService.setAttributes(request.getSession(),preuser);
        return Result.succ(preuser);


    }

    @GetMapping("/logout")
    public Result logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null)
            return Result.fail("身份验证失效,请重新登录",Result.RESULT_IDENTITY_ERROR);
        session.removeAttribute("user");
        session.removeAttribute("userinfo");
        userService.userLog(user, GloabalUtil.USER_LOGOFF);
        return Result.succ(null);

    }


}


