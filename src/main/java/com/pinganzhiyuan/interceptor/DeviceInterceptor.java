package com.pinganzhiyuan.interceptor;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pinganzhiyuan.mapper.DeviceLogMapper;
import com.pinganzhiyuan.model.DeviceLog;
import com.pinganzhiyuan.model.DeviceLogExample;

public class DeviceInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LogManager.getLogger(DeviceInterceptor.class);

    @Autowired
    private DeviceLogMapper deviceLogMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest((HttpServletRequest) request);
        request = multiReadRequest;

        String version = request.getHeader("Version");
        String userId = request.getHeader("User-Id");
        String userAgent = request.getHeader("User-Agent");
        String channelId = request.getHeader("Channel-Id");
        String ip = request.getRemoteAddr();
        String uri = request.getRequestURI();

        if (version == null || userId == null || channelId == null || userAgent == null) {
            return false;
        }

//        InputStream is = null;
//        String body = "";
//        
//        try {
//            is = request.getInputStream();
//            StringBuffer out = new StringBuffer();
//            byte[] b = new byte[4096];
//            for (int n; (n = is.read(b)) != -1;) {
//                 out.append(new String(b, 0, n));
//            }
//            body = out.toString();
//            
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String strPageId = request.getParameter("pageId");
        int pageId = Integer.valueOf(strPageId);
        DeviceLog deviceLog = new DeviceLog();
        deviceLog.setVersion(Integer.valueOf(version));
        deviceLog.setChannelId(Long.valueOf(channelId));
        deviceLog.setUserId(Long.valueOf(userId));
        deviceLog.setUserAgent(userAgent);
        deviceLog.setIp(ip);
        deviceLog.setUri(uri);
        deviceLog.setPageId(pageId);

        deviceLogMapper.insert(deviceLog);

        return super.preHandle(request, response, handler);
    }

}
