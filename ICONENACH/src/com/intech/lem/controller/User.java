package com.intech.lem.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {


    private static Map<String, HttpSession> logins = Collections.synchronizedMap(new HashMap<String, HttpSession>());
    private String username;

    public User(String username) {
        this.username = username;        
    }

    public String getUsername() {
        return username;
    }
    
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        if (logins.containsKey(getUsername())) {
            HttpSession session = logins.remove(getUsername());
            if (session != null) {
                session.invalidate();
            }
            logins.put(getUsername(), event.getSession());
        } else {
            logins.put(getUsername(), event.getSession());
        }

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        logins.remove(getUsername());
    }

}
