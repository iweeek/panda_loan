package com.pinganzhiyuan.interceptor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mysql.cj.api.x.io.MessageWriter;
import com.pinganzhiyuan.mapper.DeviceLogMapper;
import com.pinganzhiyuan.mapper.H5AppClientMapper;
import com.pinganzhiyuan.mapper.LandingChannelMapper;
import com.pinganzhiyuan.mapper.LandingDeviceLogMapper;
import com.pinganzhiyuan.mapper.LenderAccessLogMapper;
import com.pinganzhiyuan.mapper.UserMapper;
import com.pinganzhiyuan.model.DeviceLog;
import com.pinganzhiyuan.model.DeviceLogExample;
import com.pinganzhiyuan.model.H5AppClient;
import com.pinganzhiyuan.model.H5AppClientExample;
import com.pinganzhiyuan.model.LandingChannel;
import com.pinganzhiyuan.model.LandingChannelExample;
import com.pinganzhiyuan.model.LandingDeviceLog;
import com.pinganzhiyuan.model.LandingDeviceLogExample;
import com.pinganzhiyuan.model.LenderAccessLog;
import com.pinganzhiyuan.model.User;
import com.pinganzhiyuan.model.UserExample;
import com.pinganzhiyuan.util.WebUtils;

public class DeviceInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LogManager.getLogger(DeviceInterceptor.class);

    @Autowired
    private DeviceLogMapper deviceLogMapper;
    @Autowired
    private LandingDeviceLogMapper landingDeviceLogMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LandingChannelMapper landingChannelMapper;
    @Autowired
    private LenderAccessLogMapper lenderAccessLogMapper;
    @Autowired
    private H5AppClientMapper h5AppClientMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest((HttpServletRequest) request);
        request = multiReadRequest;
        
        System.out.println("requestUrl: " + request.getRequestURI() + "; requestMethod: " + request.getMethod());

        if (request.getMethod().equals("OPTIONS")) {

        } else {

            // WebUtils.getHeadersInfo(request);

            String version = request.getHeader("Version");
            String userId = request.getHeader("User-Id");
            String userAgent = request.getHeader("User-Agent");
            String channelId = request.getHeader("Channel-Id");
            String deviceId = request.getHeader("Device-Id");
            String uri = request.getHeader("Request-Uri");
//            String packageName = request.getHeader("Package-Name");
            
            String landingChannelUid = request.getHeader("Landing-Channel-Uid");
            
            // 1: 区分是来自客户端，还是其他投放渠道 && 不包括登录
            // 2: H5除了Landing页面的请求
            if (landingChannelUid == null) {
             // 如果有代理转发，则获取代理转发的地址
                String ip = request.getHeader("x-real-ip");
                if (ip == null) {
                    ip = request.getRemoteAddr();
                }
                // String uri = request.getRequestURI();
    
                if (version == null || userId == null || channelId == null || userAgent == null || deviceId == null
                        || uri == null) {
                    return false;
                }
    
                // String redirectUri = request.getParameter("redirect");
                // if (redirectUri == null) {
                // } else {
                // redirectUri = URLDecoder.decode(redirectUri);
                // try {
                // LenderAccessLog log = new LenderAccessLog();
                //
                // log.setLenderUrl(redirectUri);
                // lenderAccessLogMapper.insert(log);
                // response.sendRedirect(redirectUri);
                // } catch (IOException e) {
                // e.printStackTrace();
                // }
                // }
    
                // InputStream is = null;
                // String body = "";
                //
                // try {
                // is = request.getInputStream();
                // StringBuffer out = new StringBuffer();
                // byte[] b = new byte[4096];
                // for (int n; (n = is.read(b)) != -1;) {
                // out.append(new String(b, 0, n));
                // }
                // body = out.toString();
                //
                //
                // } catch (IOException e) {
                // e.printStackTrace();
                // }
    
                String strPageId = request.getParameter("pageId");
                if (strPageId == null) {
                    strPageId = "0";
                }
    
                String packageName = request.getHeader("Package-Name");
                if (packageName == null) {
                    packageName = "";
                }
                
                String jPushId = request.getHeader("Jpush-Id");
                if (jPushId == null) {
                    jPushId = "";
                }
                
                int pageId = Integer.valueOf(strPageId);
                DeviceLog deviceLog = new DeviceLog();
                deviceLog.setVersion(Integer.valueOf(version));
                deviceLog.setChannelId(Long.valueOf(channelId));
                deviceLog.setUserId(Long.valueOf(userId));
                deviceLog.setUserAgent(userAgent);
                deviceLog.setIp(ip);
                deviceLog.setUri(uri);
                deviceLog.setPackageName(packageName);
                deviceLog.setPageId(pageId);
                deviceLog.setDeviceId(deviceId);
                deviceLog.setJpushId(jPushId);
    
                String ll = request.getHeader("Long-Lat");
                if (ll != null) {
                    String[] llArr = ll.split("\\|");
                    Double longitude = Double.valueOf(llArr[0]);
                    Double latitude = Double.valueOf(llArr[1]);
    
                    deviceLog.setLongitude(longitude);
                    deviceLog.setLatitude(latitude);
                }
    
                String geoInfo = null;
                geoInfo = request.getHeader("Geo");
                if (geoInfo != null) {
                    deviceLog.setGeoInfo(geoInfo);
                }
    
                String pId = request.getParameter("pid");
                if (pId == null) {
                    pId = request.getHeader("Pid");
                }
                if (pId != null) {
                    deviceLog.setpId(Long.valueOf(pId));
                }
    
                String isWebview = request.getHeader("Is-Webview");
                if (isWebview != null) {
                    deviceLog.setIsWebview(Byte.valueOf(isWebview));
                }
    
                String sid = request.getHeader("Sid");
                if (sid != null) {
                    deviceLog.setSid(sid);
                }
    
                deviceLogMapper.insert(deviceLog);
            } else {
                if (!request.getRequestURI().contains("/tokens") && !request.getRequestURI().contains("/recordH5")) {
                    LandingDeviceLog landingDeviceLog = new LandingDeviceLog();
                    landingDeviceLog.setUserAgent(userAgent);
                    landingDeviceLog.setLandingChannelUid(landingChannelUid);
                    
                    StringBuffer url = request.getRequestURL();
                    landingDeviceLog.setUrl(url.toString());
                    
                    String sid = request.getHeader("Sid");
                    if (sid != null) {
                    		landingDeviceLog.setSid(sid);
                    }
                    
                    String h5WebName = request.getHeader("H5-Web-Name");
                    if (h5WebName != null) {
                    	 	H5AppClientExample h5AppClientExample = new H5AppClientExample();
                         h5AppClientExample.createCriteria().andNameEqualTo(h5WebName);
                         List<H5AppClient> h5AppClients = h5AppClientMapper.selectByExample(h5AppClientExample);
                    		if (h5AppClients != null && h5AppClients.size() != 0) {
                    			landingDeviceLog.setH5AppId(h5AppClients.get(0).getId());
                    		}
                    }
                    
                    String ip = request.getRemoteAddr();
                    landingDeviceLog.setIp(ip);
                    
                    LandingChannelExample example = new LandingChannelExample();
                    example.createCriteria().andChannelUidEqualTo(landingChannelUid);
                    List<LandingChannel> landingChannel = landingChannelMapper.selectByExample(example);
                    if (landingChannel != null && landingChannel.size() != 0) {
                        landingDeviceLog.setLandingChannelId(landingChannel.get(0).getId());
                    } else {
                        landingDeviceLog.setLandingChannelId(0l);
                    }
                    
                    landingDeviceLogMapper.insert(landingDeviceLog);
                }
            }
        }

        return super.preHandle(request, response, handler);
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
User user = null;
        
        String landingChannelUid = request.getHeader("Landing-Channel-Uid");
        
        String username = request.getParameter("username");
        
        // 上一次请求是来自其他投放渠道 && 是请求登录
        if (landingChannelUid != null && request.getRequestURI().contains("/tokens")) {
            LandingDeviceLog landingDeviceLog = new LandingDeviceLog();
            
            if (response.getStatus() == 200) {
                UserExample example = new UserExample();
                example.createCriteria().andUsernameEqualTo(username);
                List<User> users = userMapper.selectByExample(example);
                if (users != null) {
                    user = users.get(0);
                    landingDeviceLog.setUserId(user.getId());
                }
            }
            
            
            landingDeviceLog.setLandingChannelUid(landingChannelUid);
            
            String userAgent = request.getHeader("User-Agent");
            landingDeviceLog.setUserAgent(userAgent);
            
            StringBuffer url = request.getRequestURL();
            landingDeviceLog.setUrl(url.toString());
            
            String sid = request.getHeader("Sid");
            landingDeviceLog.setSid(sid);
            
            String ip = request.getRemoteAddr();
            landingDeviceLog.setIp(ip);
            
            LandingChannelExample channelExample = new LandingChannelExample();
            channelExample.createCriteria().andChannelUidEqualTo(landingChannelUid);
            List<LandingChannel> landingChannel = 
                    landingChannelMapper.selectByExample(channelExample);
            if (landingChannel != null && landingChannel.size() != 0) {
                landingDeviceLog.setLandingChannelId(landingChannel.get(0).getId());
            } else {
                landingDeviceLog.setLandingChannelId(0l);
            }
            
            String h5WebName = request.getHeader("H5-Web-Name");
            if (h5WebName != null) {
            	 	H5AppClientExample h5AppClientExample = new H5AppClientExample();
                 h5AppClientExample.createCriteria().andNameEqualTo(h5WebName);
                 List<H5AppClient> h5AppClients = h5AppClientMapper.selectByExample(h5AppClientExample);
            		if (h5AppClients != null && h5AppClients.size() != 0) {
            			landingDeviceLog.setH5AppId(h5AppClients.get(0).getId());
            		}
            }
            
            landingDeviceLogMapper.insertSelective(landingDeviceLog);
        }
        
        super.postHandle(request, response, handler, modelAndView);
    }
    
}
