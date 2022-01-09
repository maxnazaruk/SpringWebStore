package com.luxoft.webstore.servlets.filter;



import com.luxoft.webstore.service.UserVerificationService;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SecurityFilter extends GenericFilterBean {
    private List<String> userTokens;
    private UserVerificationService userVerificationService;

    public SecurityFilter(List<String> userTokens, UserVerificationService userVerificationService) {
        this.userTokens = userTokens;
        this.userVerificationService = userVerificationService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        Cookie[] cookies = httpServletRequest.getCookies();

        if (httpServletRequest.getRequestURI().endsWith("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (userVerificationService.tokenVerification(cookies, userTokens)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpServletResponse.sendRedirect("/login");
            }
        }
    }
}
