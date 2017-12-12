package com.pinganzhiyuan.service;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinganzhiyuan.model.Captcha;
import com.pinganzhiyuan.model.SMSLog;



public interface CaptchaService {

    /**
     * 生成一个验证码并保存到数据库中 
     * @param response
     * @return
     */
    Captcha genCaptcha(int tag, String phone);
    
    /** 
     * 检查验证码是否正确，并把结果写入数据库中 
     */ 
    Boolean verifyCaptcha(String captcha, String key);
    
    SMSLog getLastSMSByPhone(String phone);
    
}
