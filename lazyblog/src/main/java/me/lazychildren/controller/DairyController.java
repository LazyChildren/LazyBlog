package me.lazychildren.controller;

import me.lazychildren.entity.Dairy;
import me.lazychildren.entity.Result;
import me.lazychildren.entity.User;
import me.lazychildren.service.DairyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/dairy")
public class DairyController {

    @Autowired
    DairyService dairyService;

    @GetMapping("/show")
    public Result showOnesDairies(@RequestParam(defaultValue = "1") Integer curpage,
                                  HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        User curUser = (User) session.getAttribute("user");
        if(curUser==null){
            return Result.fail("身份验证失效，请重新登陆",Result.RESULT_IDENTITY_ERROR);
            /*跳转指令*/
        }


        return Result.succ(dairyService.getOnesDairies(curUser, curpage));
    }

    @PostMapping("/add")
    public Result writeDairies(@RequestBody Dairy dairyWrite, HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        if(dairyService.writeDairy(user,dairyWrite))
            return Result.succ(null);
        return Result.fail("系统错误，请稍后再试!",Result.RESULT_ERROR);

    }

}
