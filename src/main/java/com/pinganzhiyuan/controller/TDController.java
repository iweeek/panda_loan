package com.pinganzhiyuan.controller;


import org.joda.time.DateTime;  
import org.joda.time.format.DateTimeFormat;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
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
import com.pinganzhiyuan.mapper.TDConfigMapper;
import com.pinganzhiyuan.mapper.TDDeviceMapper;
import com.pinganzhiyuan.mapper.UserMapper;
import com.pinganzhiyuan.model.Captcha;
import com.pinganzhiyuan.model.TDConfig;
import com.pinganzhiyuan.model.TDConfigExample;
import com.pinganzhiyuan.model.TDDevice;
import com.pinganzhiyuan.model.TDDeviceExample;
import com.pinganzhiyuan.model.User;
import com.pinganzhiyuan.model.UserExample;
import com.pinganzhiyuan.service.CaptchaService;
import com.pinganzhiyuan.service.TokenService;
import com.pinganzhiyuan.util.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class TDController {
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private CaptchaService captchaService;
    
    @Autowired
    TDConfigMapper tdConfigMapper;
    
    @Autowired
    TDDeviceMapper tdDeviceMapper;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @ApiOperation(value = "创建TD激活设备", notes = "创建TD激活设备")
    @RequestMapping(value = { "/tdDevices" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("包名") @RequestParam String packageName, @ApiParam("渠道Id")@RequestParam Long channelId,
            @ApiParam("设备Id")@RequestParam String deviceId) {
        
        ResponseBody resBody = new ResponseBody<TDDevice>();
        
        Date dt = new Date(System.currentTimeMillis());
        
        TDDevice tdDevice = new TDDevice();
        tdDevice.setPackageName(packageName);
        tdDevice.setChannelId(channelId);
        tdDevice.setDeviceId(deviceId);
        tdDevice.setRegistDate(dt);
        
        //获取该包名、该渠道的阈值
        TDConfigExample configExample = new TDConfigExample();
        configExample.createCriteria().andPackageNameEqualTo(packageName).andChannelIdEqualTo(channelId);
        TDConfig tdConfig = tdConfigMapper.selectByExample(configExample).get(0);
        
        //获取当日报告的设备
        TDDeviceExample deviceExample = new TDDeviceExample();
        deviceExample.createCriteria().andChannelIdEqualTo(channelId).andPackageNameEqualTo(packageName).andSendFlagEqualTo(true).andRegistDateEqualTo(dt);
        int count =  tdDeviceMapper.selectByExample(deviceExample).size();
        
        if (count >= tdConfig.getThreshold()) {
            tdDevice.setSendFlag(false);
        } else {
            tdDevice.setSendFlag(true);
        }
        tdDeviceMapper.insert(tdDevice);
        
        resBody.statusMsg = "创建成功";
        resBody.obj1 = tdDevice;
        
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(resBody);
        
    }
}