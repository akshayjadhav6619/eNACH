package com.intech.lem.controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.intech.lem.dao.ApplicationAttempt;


public class SessionListenerWithMetrics implements HttpSessionListener {

    private final AtomicInteger activeSessions;

    public SessionListenerWithMetrics() {
        super();

        activeSessions = new AtomicInteger();
    }

    public int getTotalActiveSession() {
        return activeSessions.get();
    }

    public void sessionCreated(final HttpSessionEvent event) {
        activeSessions.incrementAndGet();
    }
    public void sessionDestroyed(final HttpSessionEvent event) {
        HttpSession session = event.getSession();
        String Appl_no=(String) session.getAttribute("loan_ref");
        System.out.println("Appl_no inside session destroyed>>"+Appl_no);
        ApplicationAttempt.LogoutStatus(Appl_no);
        activeSessions.decrementAndGet();
        HttpServletResponse res= null ;
        try {
			res.sendRedirect("/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
