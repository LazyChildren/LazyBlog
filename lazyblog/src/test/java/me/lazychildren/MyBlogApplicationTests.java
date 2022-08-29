package me.lazychildren;

import me.lazychildren.entity.User;
import me.lazychildren.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBlogApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {


    }

}
