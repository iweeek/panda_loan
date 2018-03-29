package com.pinganzhiyuan.controller;


import org.joda.time.DateTime;  
import org.joda.time.format.DateTimeFormat;

import java.math.BigDecimal;
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
import com.pinganzhiyuan.mapper.StDeviceMapper;
import com.pinganzhiyuan.mapper.TDConfigMapper;
import com.pinganzhiyuan.mapper.TDDeviceMapper;
import com.pinganzhiyuan.mapper.UserMapper;
import com.pinganzhiyuan.model.Captcha;
import com.pinganzhiyuan.model.StDeviceExample;
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
    
    @Autowired
    StDeviceMapper stDeviceMapper;
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @ApiOperation(value = "创建TD激活设备", notes = "创建TD激活设备")
    @RequestMapping(value = { "/tdDevices" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("包名") @RequestParam String packageName, @ApiParam("渠道Id")@RequestParam Long channelId,
            @ApiParam("设备Id")@RequestParam String deviceId) {
        
        ResponseBody resBody = new ResponseBody<TDDevice>();
        
        //判断数td_device是否存在历史的判断结果,直接返回原始结果
        TDDeviceExample tdDeviceExapmle = new TDDeviceExample();
        tdDeviceExapmle.createCriteria().andChannelIdEqualTo(channelId).andPackageNameEqualTo(packageName).andDeviceIdEqualTo(deviceId);
        if (tdDeviceMapper.selectByExample(tdDeviceExapmle).size() > 0) {
        	resBody.statusMsg = "查询成功";
            resBody.obj1 = tdDeviceMapper.selectByExample(tdDeviceExapmle).get(0);
            return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(resBody);
        }
        
        //判断st_device是否存在历史设备记录,直接返回false
        StDeviceExample stDeviceExample = new StDeviceExample();
        stDeviceExample.createCriteria().andChannelIdEqualTo(channelId).andPackageNameEqualTo(packageName).andDeviceIdEqualTo(deviceId);
        if (stDeviceMapper.selectByExample(stDeviceExample).size() > 0) {
        	resBody.statusMsg = "设备已存在历史记录";
        	TDDevice tdDevice = new TDDevice();
        	tdDevice.setChannelId(channelId);
        	tdDevice.setPackageName(packageName);
        	tdDevice.setDeviceId(deviceId);
        	tdDevice.setSendFlag(false);
        	resBody.obj1 = tdDevice;
        	return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(resBody);
        }
        
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
        
        //获取当日设备总数
        deviceExample = new TDDeviceExample();
        deviceExample.createCriteria().andChannelIdEqualTo(channelId).andPackageNameEqualTo(packageName).andRegistDateEqualTo(dt);
        int totalCount =  tdDeviceMapper.selectByExample(deviceExample).size();
        
        if (totalCount == 0) {
        	tdDevice.setSendFlag(true);
        } else {
        	BigDecimal bdCount = new BigDecimal(String.valueOf(count));   
            BigDecimal bdTotalCount = new BigDecimal(String.valueOf(totalCount));
            
            BigDecimal bdThreshold = new BigDecimal(String.valueOf(tdConfig.getThreshold()));
            BigDecimal bdOneHundred = new BigDecimal(String.valueOf(100));
            
        	if ( bdCount.divide(bdTotalCount,2,BigDecimal.ROUND_DOWN).doubleValue() >= bdThreshold.divide(bdOneHundred,2,BigDecimal.ROUND_DOWN).doubleValue()) {
                tdDevice.setSendFlag(false);
            } else {
                tdDevice.setSendFlag(true);
            }
        }
        tdDeviceMapper.insert(tdDevice);
        
        resBody.statusMsg = "创建成功";
        resBody.obj1 = tdDevice;
        
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(resBody);
        
    }
}
