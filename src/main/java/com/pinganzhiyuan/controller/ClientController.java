package com.pinganzhiyuan.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinganzhiyuan.mapper.CaptchaMapper;
import com.pinganzhiyuan.mapper.ClientMapper;
import com.pinganzhiyuan.mapper.UserMapper;
import com.pinganzhiyuan.model.Captcha;
import com.pinganzhiyuan.model.Client;
import com.pinganzhiyuan.model.User;
import com.pinganzhiyuan.service.CaptchaService;
import com.pinganzhiyuan.service.TokenService;
import com.pinganzhiyuan.util.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
public class ClientController {
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private CaptchaService captchaService;
    
    @Autowired
    CaptchaMapper captchaMapper;
    
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    ClientMapper clientMapper;
    
    @ApiOperation(value = "创建token", notes = "验证用户名与密码，为用户创建一个用于鉴权的Token")
    @RequestMapping(value = { "/clients" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("用户Id") @RequestParam Long userId, @ApiParam("真实姓名")@RequestParam String name,
            @ApiParam("身份证号")@RequestParam String idNo, @ApiParam("居住地址")@RequestParam(required = false) String resiAddr,
            @ApiParam("性别")@RequestParam(required = false) Boolean isMan, @ApiParam("民族")@RequestParam(required = false) String nation,
            @ApiParam("生日")@RequestParam(required = false) String birthday, @ApiParam("身份证签发机关")@RequestParam(required = false) String auth,
            @ApiParam("身份证过期时间")@RequestParam(required = false) Date expirDate) {
        
        Client client = new Client();
        client.setUserId(userId);
        client.setName(name);
        client.setIdentityNo(idNo);
        if (resiAddr != null) {
            client.setResidenceAddr(resiAddr);
        }
        
        if (isMan != null) {
            client.setIsMan(isMan);
        }
        
        if (nation != null) {
            client.setNation(nation);
        }
        
        if (birthday != null) {
            client.setBirthday(birthday);
        }
        
        if (auth != null) {
            client.setIdentityAuth(auth);
        }
        
        if (expirDate != null) {
            client.setIdentityExpiration(expirDate);
        }
        
        int ret = clientMapper.insertSelective(client);
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(null); 
    }
}
