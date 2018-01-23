package com.yuanwj.rest;

import com.yuanwj.model.User;
import com.yuanwj.security.TokenService;
import com.yuanwj.security.UserAuthentication;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by bmk on 17-12-21.
 */
@RestController
@RequestMapping(value = "/api/v1/login")
@Api(tags = "外部操作api")
public class LoginResource {

    @Inject
    private TokenService tokenService;

    @RequestMapping(value = "login")
    @ApiOperation(value = "用户登录")
    public String login(String userName,String password){
        User user =new User();
        user.setId(1l);
        user.setUserName(userName);
        user.setPassword(password);
        user.setRealName("yuanwj");
        UserAuthentication authentication = tokenService.createToken(user);
        String token = authentication.getJwtToken();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return token;
    }
}
