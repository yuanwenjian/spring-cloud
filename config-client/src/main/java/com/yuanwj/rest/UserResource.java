package com.yuanwj.rest;

import com.yuanwj.model.User;
import com.yuanwj.repository.UserMapper;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by bmk on 17-12-26.
 */
@RestController
@RequestMapping(value = "/api/v1/user/")
public class UserResource {

    @Inject
    private UserMapper userMapper;

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public String getUser(String userId){
        User user = new User();
        user.setUserName("iooj");
        user.setRealName("realName");
        user.setId(9l);
        return JSONObject.fromObject(user).toString();
    }

    @RequestMapping(value = "findByEmail")
    public String findByEmail(String email){
        List<User> users = userMapper.findByEmail(email);
        return "success";
    }
}
