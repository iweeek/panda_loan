package com.pinganzhiyuan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinganzhiyuan.mapper.LenderAccessLogMapper;
import com.pinganzhiyuan.mapper.ProductMapper;
import com.pinganzhiyuan.model.LenderAccessLog;
import com.pinganzhiyuan.model.Product;

@RestController
public class IndexController {
    
    @Autowired
    private LenderAccessLogMapper lenderAccessLogMapper;
    
    @Autowired
    private ProductMapper productMapper;
    
    @RequestMapping(value="/record", method = RequestMethod.GET)
    public void record(HttpServletRequest request, HttpServletResponse response) {
        
        String deviceId = request.getHeader("Device-Id");
        String userId = request.getHeader("User-Id");
        String pId = request.getParameter("pid");
        if (pId == null) {
            pId = request.getHeader("Pid");
        }
        
        String redirectUri = request.getParameter("redirect");
        if (redirectUri == null) {
        } else {
            try {
//                System.out.println("redirectUri: "+ redirectUri);
                LenderAccessLog log = new LenderAccessLog();
                log.setLenderUrl(redirectUri);
                log.setDeviceId(deviceId);
                log.setUserId(Long.valueOf(userId));
                log.setpId(Long.valueOf(pId));
                lenderAccessLogMapper.insert(log);
                response.sendRedirect(redirectUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @RequestMapping(value="/recordH5", method = RequestMethod.POST)
    public ResponseEntity<?> recordH5(@RequestParam("userId") String userId,
                            @RequestParam("productId") String productId,
                            HttpServletRequest request, HttpServletResponse response) {
        
        Product product = productMapper.selectByPrimaryKey(Long.valueOf(productId));
        // 处理 URL，截取最后真正的链接
        String redirectUri = "";
        
        if (product != null) {
            String url = product.getUrl();
            
            Pattern p = Pattern.compile("redirect=(.*?)###");//正则表达式，取; 和; 之间的字符串  
            Matcher m = p.matcher(product.getUrl() + "###");
            if (m.find()) {
                    try {
                        redirectUri = URLDecoder.decode(m.group(1), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        
        if (redirectUri == null) {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null); 
        } else {
            LenderAccessLog log = new LenderAccessLog();
            log.setLenderUrl(redirectUri);
            log.setDeviceId("device-id-h5");
            log.setUserId(Long.valueOf(userId));
            log.setpId(Long.valueOf(productId));
            lenderAccessLogMapper.insert(log);
            
            return ResponseEntity.status(HttpServletResponse.SC_OK).body(redirectUri);
        }
        
    }
}
