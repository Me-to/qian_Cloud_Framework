package com.example.qian.hanadler;

import com.alibaba.fastjson.JSONObject;
import com.example.qian.entity.QianResponse;
import com.example.qian.utils.QianUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 401 token失效
 */
public class QianAuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        QianResponse qianResponse = new QianResponse();
        QianUtil.makeResponse(response,MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED,qianResponse.message("token无效"));
    }
}
