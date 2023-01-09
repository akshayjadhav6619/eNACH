package com.intech.lem.controller;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HSTSFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res,
        FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) res;
        HttpServletRequest reqst=(HttpServletRequest) req;
        String sessionid = ((HttpServletRequest) req).getSession().getId();


        if (req.isSecure())
            resp.setHeader("Strict-Transport-Security", "max-age=31536000; preload");
            resp.addHeader("X-FRAME-OPTIONS", "Deny");
            resp.setHeader("Pragma", "no-cache");
            resp.setHeader("Cache-Control", "no-store");
            resp.setHeader("X-Content-Type-Options", "nosniff");
            resp.setHeader("X-XSS-Protection", "0");
            resp.setHeader("Content-Security-Policy", "connect-src 'self'");
           // resp.setHeader("Content-Security-Policy", "script-src 'self'");
            //String contextPath = ((HttpServletRequest) reqst).getContextPath()+"kevalcccc";
            //((HttpServletResponse)ServletActionContext.getResponse()).setHeader("SET-COOKIE",  "JSESSIONID=" + ((HttpServletRequest)request).getSession().getId() + ";Path="+contextPath+";Secure;HttpOnly");
            resp.setHeader("SET-COOKIE", "JSESSIONID=" + sessionid + "; HttpOnly;Secure");
             
      


            


        chain.doFilter(req, resp);
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}