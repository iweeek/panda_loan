package com.pinganzhiyuan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.pinganzhiyuan.mapper.ClientMapper;
import com.pinganzhiyuan.mapper.ClientVersionMapper;
import com.pinganzhiyuan.mapper.H5AppClientMapper;
import com.pinganzhiyuan.mapper.H5AppDownloadLogMapper;
import com.pinganzhiyuan.mapper.H5ClientVersionMapper;
import com.pinganzhiyuan.mapper.LandingChannelMapper;
import com.pinganzhiyuan.mapper.LandingDeviceLogMapper;
import com.pinganzhiyuan.mapper.LenderAccessLogMapper;
import com.pinganzhiyuan.mapper.ProductMapper;
import com.pinganzhiyuan.mapper.UserMapper;
import com.pinganzhiyuan.model.Client;
import com.pinganzhiyuan.model.ClientExample;
import com.pinganzhiyuan.model.ClientVersion;
import com.pinganzhiyuan.model.ClientVersionExample;
import com.pinganzhiyuan.model.H5AppClient;
import com.pinganzhiyuan.model.H5AppClientExample;
import com.pinganzhiyuan.model.H5AppDownloadLog;
import com.pinganzhiyuan.model.H5ClientVersion;
import com.pinganzhiyuan.model.H5ClientVersionExample;
import com.pinganzhiyuan.model.LandingChannel;
import com.pinganzhiyuan.model.LandingChannelExample;
import com.pinganzhiyuan.model.LandingDeviceLog;
import com.pinganzhiyuan.model.LenderAccessLog;
import com.pinganzhiyuan.model.Product;
import com.pinganzhiyuan.model.User;
import com.pinganzhiyuan.model.UserExample;
import com.pinganzhiyuan.util.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: IndexController 
 * @Description: 
 * @author: nijun
 * @date: Mar 30, 2018 11:35:09 AM
 *
 */
@Api(tags = "日志记录相关接口")
@RestController
public class IndexController {
    
    @Autowired
    private LenderAccessLogMapper lenderAccessLogMapper;
    
    @Autowired
    private LandingDeviceLogMapper landingDeviceLogMapper;
    
    @Autowired
    private LandingChannelMapper landingChannelMapper;
    
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private H5AppClientMapper h5AppClientMapper;
    @Autowired
    private H5ClientVersionMapper h5ClientVersionMapper;
    @Autowired
    private ClientVersionMapper clientVersionMapper;
    @Autowired
    private H5AppDownloadLogMapper h5AppDownloadLogMapper;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private UserMapper userMapper;
    
    @ApiOperation(value = "客户端访问统计", notes = "统计 device_log")
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
    
    /**
     * 从原来的 lender_access_log 表迁移到 landing_device_log 中
     * @param userId
     * @param productId
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "H5访问统计", notes = "统计 H5 页面的相关访问记录")
	@RequestMapping(value = "/recordH5", method = RequestMethod.POST)
    public ResponseEntity<?> recordH5(@RequestParam(name = "userId", required = false) String userId,
                            @RequestParam(name = "pid", required = false) String productId,
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
            String userAgent = request.getHeader("User-Agent");
            String landingChannelUid = request.getHeader("Landing-Channel-Uid");
            StringBuffer url = request.getRequestURL();
            
        		LandingDeviceLog landingDeviceLog = new LandingDeviceLog();
        		landingDeviceLog.setIp(request.getRemoteAddr());
        		landingDeviceLog.setLandingChannelUid(landingChannelUid);
        		landingDeviceLog.setUrl(url.toString());
        		landingDeviceLog.setUserAgent(userAgent);
        		landingDeviceLog.setUserId(Long.valueOf(userId));
        		landingDeviceLog.setpId(Long.valueOf(productId));
        		
        		LandingChannelExample example = new LandingChannelExample();
            example.createCriteria().andChannelUidEqualTo(landingChannelUid);
            List<LandingChannel> landingChannel = landingChannelMapper.selectByExample(example);
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
            
//            LenderAccessLog log = new LenderAccessLog();
//            log.setLenderUrl(redirectUri);
//            log.setDeviceId("device-id-h5");
//            log.setUserId(Long.valueOf(userId));
//            log.setpId(Long.valueOf(productId));
//            lenderAccessLogMapper.insert(log);
            
            return ResponseEntity.status(HttpServletResponse.SC_OK).body(redirectUri);
        }
    }
	
    @ApiOperation(value = "H5下载链接获取", notes = "根据H5页面、渠道、平台，返回相应的下载链接")
	@RequestMapping(value = "/h5DownloadUrl", method = RequestMethod.POST)
    public ResponseEntity<?> getDownloadUrl(
                            HttpServletRequest request, HttpServletResponse response) {
        
		Long h5AppId = null;
		Long h5ChannelId = null;
		ClientVersion clientVersion = null;
		
		String h5WebName = request.getHeader("H5-Web-Name");
	    if (h5WebName != null) {
	    	 	H5AppClientExample h5AppClientExample = new H5AppClientExample();
	         h5AppClientExample.createCriteria().andNameEqualTo(h5WebName);
	         List<H5AppClient> h5AppClients = h5AppClientMapper.selectByExample(h5AppClientExample);
	    		if (h5AppClients != null && h5AppClients.size() != 0) {
	    			h5AppId = h5AppClients.get(0).getId();
	    		}
	    }
	    
	    String landingChannelUid = request.getHeader("Landing-Channel-Uid");
	    LandingChannelExample example = new LandingChannelExample();
	    example.createCriteria().andChannelUidEqualTo(landingChannelUid);
	    List<LandingChannel> landingChannel = landingChannelMapper.selectByExample(example);
	    if (landingChannel != null && landingChannel.size() != 0) {
	    		h5ChannelId = landingChannel.get(0).getId();
	    }	
	    
	    String platformId = request.getHeader("Platform-Id");
	    
	    if (h5AppId != null && h5ChannelId != null) {
    		H5ClientVersionExample h5ClientVersionExample = new H5ClientVersionExample();
    		h5ClientVersionExample.createCriteria().andH5AppIdEqualTo(h5AppId)
    								.andH5ChannelIdEqualTo(h5ChannelId);
//	    							.andPlatformIdEqualTo(Byte.valueOf(platformId));
    		List<H5ClientVersion> h5ClientVersions = h5ClientVersionMapper.selectByExample(h5ClientVersionExample);
    		
    		if (h5ClientVersions != null && h5ClientVersions.size() != 0) {
    			long clientVersionId = 0;
    			if (platformId.equals("1")) {
    				clientVersionId = h5ClientVersions.get(0).getIosClientVersionId();
    			} else if (platformId.equals("0")) {
    				clientVersionId = h5ClientVersions.get(0).getClientVersionId();
    			}
    			clientVersion = clientVersionMapper.selectByPrimaryKey(Long.valueOf(clientVersionId));
    		}
	    }
            
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(clientVersion);
    }
	
    @ApiOperation(value = "统计下载次数", notes = "统计下载次数")
	@RequestMapping(value = "/recordDownload", method = RequestMethod.POST)
    public ResponseEntity<?> recordDownload(@RequestParam(name = "userId", required = false) String userId,
                            @RequestParam(name = "downloadUrl", required = false) String downloadUrl,
                            HttpServletRequest request, HttpServletResponse response) {
		
		Long h5AppId = null;
		Long h5ChannelId = null;
		ClientVersion clientVersion = null;
		H5AppDownloadLog h5AppDownloadLog = new H5AppDownloadLog();
		
		String h5WebName = request.getHeader("H5-Web-Name");
	    if (h5WebName != null) {
	    	 	H5AppClientExample h5AppClientExample = new H5AppClientExample();
	         h5AppClientExample.createCriteria().andNameEqualTo(h5WebName);
	         List<H5AppClient> h5AppClients = h5AppClientMapper.selectByExample(h5AppClientExample);
	    		if (h5AppClients != null && h5AppClients.size() != 0) {
	    			h5AppId = h5AppClients.get(0).getId();
	    		}
	    }
	    
	    String landingChannelUid = request.getHeader("Landing-Channel-Uid");
	    LandingChannelExample example = new LandingChannelExample();
	    example.createCriteria().andChannelUidEqualTo(landingChannelUid);
	    List<LandingChannel> landingChannel = landingChannelMapper.selectByExample(example);
	    if (landingChannel != null && landingChannel.size() != 0) {
	    		h5ChannelId = landingChannel.get(0).getId();
	    } 
	    
	    String platformId = request.getHeader("Platform-Id");
	    if (h5AppId != null && h5ChannelId != null) {
	    		H5ClientVersionExample h5ClientVersionExample = new H5ClientVersionExample();
	    		h5ClientVersionExample.createCriteria().andH5AppIdEqualTo(h5AppId)
	    								.andH5ChannelIdEqualTo(h5ChannelId)
	    								.andPlatformIdEqualTo(Byte.valueOf(platformId));
	    		List<H5ClientVersion> h5ClientVersions = h5ClientVersionMapper.selectByExample(h5ClientVersionExample);
	    		
	    		if (h5ClientVersions != null && h5ClientVersions.size() != 0) {
	    			long clientVersionId = h5ClientVersions.get(0).getClientVersionId();
//	    			clientVersion = clientVersionMapper.selectByPrimaryKey(Long.valueOf(clientVersionId));
	    			h5AppDownloadLog.setAppClientVersionId(h5ClientVersions.get(0).getClientVersionId());
	    			h5AppDownloadLog.setH5ClientVersionId(h5ClientVersions.get(0).getId());
	    		}
	    }
	    h5AppDownloadLog.setIp(request.getRemoteAddr());
	    h5AppDownloadLog.setUserId(Long.valueOf(userId));
	    h5AppDownloadLog.setUserAgent( request.getHeader("User-Agent"));
	    h5AppDownloadLogMapper.insertSelective(h5AppDownloadLog);
	    
	    return ResponseEntity.status(HttpServletResponse.SC_OK).body(null);
	}
    
    @ApiOperation(value = "跳转H5", notes = "根据不同APP跳转相应的页面")
	@RequestMapping(value = "/redirectH5", method = RequestMethod.GET)
    public void redirectH5(HttpServletRequest request, HttpServletResponse response) {
		StringBuilder builder = new StringBuilder();
		
//		String uri = request.getHeader("Request-Uri");
//		builder.append(uri);
		
		//TODO 这里需要修改
		String packageName = request.getHeader("Package-Name");
		if (packageName.equals("com.pinganzhiyuan.xiaohuabaika") || 
        		packageName.equals("com.limafintech.xiaohuabaika")) {
			builder.append("http://www.pinganzhiyuan.com/panda_loan_app_web/xhconter");
//			builder.append("http://119.23.236.252:83/panda_loan_mobile_web/xhconter");
//			builder.append("http://119.23.12.36:84/panda_loan_mobile_web/#/xhconter");
//			builder.append("http://192.168.2.156:8228/panda_loan_mobile_web/#/xhconter");
        } else if (packageName.equals("com.lmjr.xiaoyingbaika") || 
        		packageName.equals("com.xmnjzy-Investment.xiaoyingbaika")) {
        	builder.append("http://www.pinganzhiyuan.com/panda_loan_app_web/xyconter");
//        	builder.append("http://119.23.236.252:83/panda_loan_mobile_web/xyconter");
//        	builder.append("http://119.23.12.36:84/panda_loan_mobile_web/#/xyconter");
//        	builder.append("http://192.168.2.156:8228/panda_loan_mobile_web/#/xyconter");
        } else if (packageName.equals("com.lmjr.noworryturnover") || 
        		packageName.equals("com.guangrong-Information.mochouzhouzhuan")) {
        	builder.append("http://www.pinganzhiyuan.com/panda_loan_app_web/mcconter");
//        	builder.append("http://119.23.236.252:83/panda_loan_mobile_web/mcconter");
//        	builder.append("http://119.23.12.36:84/panda_loan_mobile_web/#/mcconter");
//        	builder.append("http://192.168.2.156:8228/panda_loan_mobile_web/#/mcconter");
        } else if (packageName.equals("com.lmjr.noworryturnover") || 
        		packageName.equals("com.chunqi.suibianhua")) {
        	builder.append("http://www.pinganzhiyuan.com/panda_loan_app_web/axhconter");
 //       	builder.append("http://119.23.236.252:83/panda_loan_mobile_web/axhconter");
//        	builder.append("http://119.23.12.36:84/panda_loan_mobile_web/#/axhconter");
//        	builder.append("http://192.168.2.156:8228/panda_loan_mobile_web/#/axhconter");
        }
		
		if (packageName != null) {
        	builder.append("?packageName=" + packageName);
        }
		
		String userId = request.getHeader("User-Id");
		ClientExample example = new ClientExample();
		example.createCriteria().andUserIdEqualTo(Long.valueOf(userId));
		List<Client> list = clientMapper.selectByExample(example);

		if (list != null && list.size() != 0) {
			builder.append("&isCertified=1");
			String encode = "";
			try {
				encode = URLEncoder.encode(list.get(0).getName(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			builder.append("&name=" + encode);
		} else {
			builder.append("&isCertified=0");
		}
		
		UserExample userExample = new UserExample();
		User user = userMapper.selectByPrimaryKey(Long.valueOf(userId));
		if (user != null) {
			builder.append("&phone=" + user.getUsername());
		}
		
		String version = request.getHeader("Version");
		builder.append("&versionCode=" + version);
        	
        try {
//        	String encode = URLEncoder.encode(builder.toString(), "UTF-8");
			response.sendRedirect(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
