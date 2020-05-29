package cn.project.mpdemo;

import cn.project.mpdemo.entity.User;
import cn.project.mpdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MpdemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setName("lili");
        user.setAge(30);
        user.setEmail("654321@qq.com");
        int num = userMapper.insert(user);
        System.out.println("insert -- >"+num);
    }

    @Test
    public void updateUser(){

        User user = new User();
        user.setId(1266195486567817218L);

        user.setAge(1);

        int num = userMapper.updateById(user);

        System.out.println("update  ------- .>" + num);
    }

}
