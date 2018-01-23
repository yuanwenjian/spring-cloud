package com.yuanwj.security;

import com.yuanwj.model.User;
import org.apache.catalina.servlet4preview.GenericFilter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bmk on 17-12-21.
 */
public class TokenFilter extends GenericFilterBean {

    private Logger LOG = LoggerFactory.getLogger(TokenFilter.class);

    private static String TOKEN_HEADER="token";

    @Inject
    private TokenService tokenService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader(TOKEN_HEADER);
        try {
            if (StringUtils.isNotEmpty(token)){
                UserAuthentication userAuthentication = tokenService.parseToken(token);
                SecurityContextHolder.getContext().setAuthentication(userAuthentication);
            }
//            ((UserAuthentication)SecurityContextHolder.getContext().getAuthentication()).getAuthoriti();
            filterChain.doFilter(servletRequest,servletResponse);
        }catch (Exception e){
            e.printStackTrace();
            LOG.debug("访问失败,token获取异常,token为{}",token);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"token 验证失败");
        }
    }
}
