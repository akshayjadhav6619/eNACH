package com.intech.lem.dao;

import java.util.HashMap;
 
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
  
public class LoginDto  implements HttpSessionListener {
    
    private int sessionCount = 0;
     
    public void sessionCreated(HttpSessionEvent event) {
         
        synchronized (this) {
            sessionCount++;
        }
 
         
        System.out.println("Session Created: " + event.getSession().getId());
        System.out.println("Total Sessions: " + sessionCount);
    }
  
    public void sessionDestroyed(HttpSessionEvent event) {
        synchronized (this) {
            sessionCount--;
        }
         
/* hMap is a HashMap that is maintained in the ServletContext, which makes it available throughout the Application. In that, Session ID and UserName is stored whenever a new user is logged in. And if a new user tries to login, we shall check if the username is present in the HashMap, if No, he will be authenticated else, we shall redirect him to login page. */
 
        System.out.println("Session Destroyed: " + event.getSession().getId());
        try{
             
            HashMap hMap=(HashMap) event.getSession().getServletContext().getAttribute("hMap");
            System.out.println("hMap::"+hMap);
            event.getSession().getServletContext().removeAttribute((String) hMap.remove(event.getSession().getId()));
            System.out.println("hMap after removing::"+hMap);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Total Sessions: " + sessionCount);
    }
}