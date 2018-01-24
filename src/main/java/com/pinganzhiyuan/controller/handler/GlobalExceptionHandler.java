package com.pinganzhiyuan.controller.handler;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pinganzhiyuan.util.ResponseBody;


/**
* @ClassName: GlobalExceptionHandler
* @Description: 捕获处理所有未处理异常
* @author x1ny
* @date 2017年5月9日
*/
@ControllerAdvice
public class GlobalExceptionHandler {
	private final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handler(Exception exception) {
		logger.error(exception);
		ResponseBody resBody = new ResponseBody<>();
		resBody.statusMsg = "服务端发生错误";
		return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(resBody);
	}
}
