package com.pinganzhiyuan.controller;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinganzhiyuan.mapper.SMSLogMapper;
import com.pinganzhiyuan.model.Captcha;
import com.pinganzhiyuan.model.SMSLog;
import com.pinganzhiyuan.service.CaptchaService;
import com.pinganzhiyuan.util.CaptchaUtil;
import com.pinganzhiyuan.util.SMSUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class SMSCaptchaController {
    
    @Autowired
    private CaptchaService captchaService;
    
    @Autowired
    private SMSLogMapper smsLogSMapper;
    
    @ApiOperation(value = "创建验证码", notes = "创建验证码，将创建好的验证码存入数据库中")
    @RequestMapping(value = { "/smsCaptcha" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("用户电话号码") @RequestParam String phone) {
        
        SMSLog log = new SMSLog();
        SMSLog lastLog = captchaService.getLastSMSByPhone(phone);
        if (lastLog != null && (new Date().getTime() - lastLog.getSendTime().getTime() < 90)) {
            ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(null);  
        }
        
        //将该手机之前申请的未使用过的验证码标记为已使用
        captchaService.obsoleteSMSsByPhone(phone);
        
        Captcha captcha = captchaService.genCaptcha(2, phone);
        
        JSONObject object = new JSONObject();
        object.put("account", "N2500774");
        object.put("password", "mcyPEAo6eRc3a4");
        
        String s = " 您的验证码是：" + captcha.getCaptcha();
        byte[] b;
        String msg;
        try {
            b = s.getBytes("UTF-8");
            msg = new String(b,"UTF-8");
        
            object.put("msg", msg);
            object.put("phone", phone);
            object.put("uid", captcha.getId());
            
            Boolean result = SMSUtil.sendSMS(object.toString());
            
            if (result) {
                log = new SMSLog();
                log.setMessage(object.toString());
                log.setPhone(phone);
                smsLogSMapper.insert(log);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        JSONObject obj = new JSONObject();
        obj.put("keySMSCapt", log.getId());
        
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(obj); 

    }

}
