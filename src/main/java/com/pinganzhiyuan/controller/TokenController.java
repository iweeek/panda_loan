package com.pinganzhiyuan.controller;

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
import com.pinganzhiyuan.model.Captcha;
import com.pinganzhiyuan.service.CaptchaService;
import com.pinganzhiyuan.service.TokenService;
import com.pinganzhiyuan.util.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
public class TokenController {
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private CaptchaService captchaService;
    
    @Autowired
    CaptchaMapper captchaMapper;
    
    @ApiOperation(value = "创建token", notes = "验证用户名与密码，为用户创建一个用于鉴权的Token")
    @RequestMapping(value = { "/tokens" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("用户名（电话号码）") @RequestParam String username, @ApiParam("图形验证码的key")@RequestParam(required = false) String keyImageCapt,
            @ApiParam("图形验证码")@RequestParam(required = false) String imageCapt, @ApiParam("短信验证码的key")@RequestParam String keySMSCapt,
            @ApiParam("短信验证码")@RequestParam String smsCapt) {
        
        Boolean isPassed = false;
        
        isPassed = captchaService.verifyCaptcha(smsCapt, keySMSCapt);
        
        if (imageCapt != null && keyImageCapt != null) { 
            isPassed = captchaService.verifyCaptcha(imageCapt, keyImageCapt);
        }
        
        if (isPassed) {
            return ResponseEntity.status(HttpServletResponse.SC_OK).body(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(null);
        }
    }
}
