package com.bridgelabz.loginservlet;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class RequestProcessingTimeListener
 *
 */
@WebListener
public class RequestProcessingTimeListener implements HttpSessionListener 
{

   private long start,end;
   private ServletContext context;
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  
    {
    	start=System.currentTimeMillis();
    	context=se.getSession().getServletContext();
    	context.log("Session started at"+new Date());
    }
    

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  
    {
    	end=System.currentTimeMillis();
    	context.log("Session ended at:"+new Date());
    	context.log("Session Duration:"+(end-start)+"ms");
    }
	
}
