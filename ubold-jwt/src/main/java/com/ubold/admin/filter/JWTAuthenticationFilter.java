package com.ubold.admin.filter;

import com.alibaba.fastjson.JSONObject;
import com.ubold.admin.constant.StatusCodeEnum;
import com.ubold.admin.response.Response;
import com.ubold.admin.service.TokenAuthenticationService;
import com.ubold.admin.util.SpringContextUtil;
import org.apache.commons.lang3.CharEncoding;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截所有需要JWT的请求，然后调用TokenAuthenticationService类的静态方法去做JWT验证
 * Created by ningzuokun on 2017/12/18.
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        TokenAuthenticationService tokenAuthenticationService = SpringContextUtil.getBean(TokenAuthenticationService.class);


        Response<Authentication> authenticationResponse = tokenAuthenticationService.getAuthentication((HttpServletRequest) request);
        if(!authenticationResponse.checkSuccess()){
            HttpServletResponse httpServletResponse = (HttpServletResponse)response;
            httpServletResponse.setCharacterEncoding(CharEncoding.UTF_8);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            if(StatusCodeEnum.INSUFFICIENT_PRIVILEGES.getCode() == authenticationResponse.getCode()){
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }else{
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
            httpServletResponse.getWriter().println(JSONObject.toJSONString(authenticationResponse));
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authenticationResponse.getResult());
        filterChain.doFilter(request,response);
    }
}