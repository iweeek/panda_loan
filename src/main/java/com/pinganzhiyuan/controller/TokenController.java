package com.pinganzhiyuan.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinganzhiyuan.mapper.CaptchaMapper;
import com.pinganzhiyuan.mapper.SMSLogMapper;
import com.pinganzhiyuan.mapper.UserMapper;
import com.pinganzhiyuan.model.Captcha;
import com.pinganzhiyuan.model.SMSLog;
import com.pinganzhiyuan.model.User;
import com.pinganzhiyuan.model.UserExample;
import com.pinganzhiyuan.service.CaptchaService;
import com.pinganzhiyuan.service.TokenService;
import com.pinganzhiyuan.util.ResponseBody;
import com.pinganzhiyuan.util.SMSUtil;

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
    
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    private SMSLogMapper smsLogMapper;
    
    @SuppressWarnings("rawtypes")
    @ApiOperation(value = "创建token", notes = "验证用户名与密码，为用户创建一个用于鉴权的Token")
    @RequestMapping(value = { "/tokens" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("用户名（电话号码）") @RequestParam String username, @ApiParam("图形验证码的key")@RequestParam(required = false) String keyImageCapt,
            @ApiParam("图形验证码")@RequestParam(required = false) String imageCapt, @ApiParam("短信验证码的key")@RequestParam String keySMSCapt,
            @ApiParam("短信验证码")@RequestParam String smsCapt, HttpServletRequest request) {
        
        Boolean isPassed = false;
        
        ResponseBody resBody = new ResponseBody<String>();
        
        String msg;
        
        if (imageCapt != null && keyImageCapt != null) { 
            isPassed = captchaService.verifyCaptcha(imageCapt, keyImageCapt);
            if (!isPassed) {
                resBody.statusMsg = "图形验证码不正确";
                return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(resBody);
            }
        }
        
        //通用验证码
        if (smsCapt.equals("0000")) {
            isPassed = true;
        } else {
            isPassed = captchaService.verifyCaptcha(smsCapt, keySMSCapt);
        }
        if (isPassed) {
            UserExample example = new UserExample();
            example.createCriteria().andUsernameEqualTo(username);
            List<User> list = userMapper.selectByExample(example);
            
            if (list.size() > 0) {
                resBody.statusMsg = "登录成功";
                resBody.obj1 = list.get(0);
                return ResponseEntity.status(HttpServletResponse.SC_OK).body(resBody);
            }
           
            User user = new User();
            user.setUsername(username);
            user.setPassword("");
            user.setRegistTime((new Date()).getTime());
            userMapper.insert(user);
            
            resBody.statusMsg = "登录成功";
            resBody.obj1 = user;
            
            String landingChannelUid = request.getHeader("Landing-Channel-Uid");
            if (landingChannelUid != null && !landingChannelUid.equals("")) {
            	sendMsg("【熊猫贷款】尊敬的会员，您的借款申请已经进入快速审核通道，打开app填写身份信息，马上提现", username);
            }
            
            return ResponseEntity.status(HttpServletResponse.SC_OK).body(resBody);
        } else {
            resBody.statusMsg = "短信验证码不正确";
            return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(resBody);
        }
    }
    
    @RequestMapping(value = { "/landingPage" }, method = RequestMethod.POST)
    public ResponseEntity<?> landingPage() {
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(null);
    }
    
    public ResponseBody sendMsg(String message, String phone) {
    	 SMSLog log = new SMSLog();
         SMSLog lastLog = captchaService.getLastSMSByPhone(phone);
         ResponseBody resp = new ResponseBody();
         // 90秒内同一手机不能请求第二次
         if (lastLog != null) {
             if (new Date().getTime() - lastLog.getSendTime().getTime() < 90) {
                 ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(null); 
             }
         }
         
         //将该手机之前申请的未使用过的验证码标记为已使用
         captchaService.obsoleteCaptchaByPhone(phone);
         
         Captcha captcha = captchaService.genCaptcha(2);
         
         JSONObject object = new JSONObject();
         object.put("account", "N2500774");
         object.put("password", "mcyPEAo6eRc3a4");
         
//         String packageName = request.getHeader("Package-Name");
         
//         String s = "";
//         
//         if (packageName.equals("com.tainingbank.pingankuaidai")) {
//         	s = "【平安快贷】您登录的验证码为：" + captcha.getCaptcha() + "，请不要把验证码泄露给他人。如非本人操作，可不用理会。";
//         }
//         
//         s = "【熊猫贷款】您登录的验证码为：" + captcha.getCaptcha() + "，请不要把验证码泄露给他人。如非本人操作，可不用理会。";
         byte[] b;
         String msg;
         try {
             b = message.getBytes("UTF-8");
             msg = new String(b,"UTF-8");
         
             object.put("msg", msg);
             object.put("phone", phone);
             object.put("uid", captcha.getId());
             
             String result = null;
             result = SMSUtil.sendSMS(object.toString());
             if (result != null) {
                 JSONObject jsonObj = new JSONObject(result.toString());
                 
                 log = new SMSLog();
                 log.setReqMsg(object.toString());
                 log.setPhone(phone);
                 log.setSendTime(new Date());
                 log.setChannelId((byte) 0);
                 log.setCaptId(captcha.getId());
                 log.setRespMsg(result);
                 smsLogMapper.insert(log);
                 
                 if (jsonObj.getString("code").equals("0")) { 
                     Map<String, String> map = new HashMap<String, String>();
                     map.put("keySMSCapt", String.valueOf(captcha.getId()));
                     resp.statusMsg = jsonObj.getString("errorMsg");
                     resp.obj1 = map;
                     return resp; 
                 } else {
                     resp.statusMsg = jsonObj.getString("errorMsg");
                     return resp; 
                 }
             } else {
                 resp.statusMsg = "获取短信验证码失败，请稍后重试";
                 return resp; 
             }
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
             resp.statusMsg = "获取短信验证码失败，请稍后重试";
             return resp; 
         }
    }
}
