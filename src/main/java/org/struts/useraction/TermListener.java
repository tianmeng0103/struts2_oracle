package org.struts.useraction;


import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;




public class TermListener implements ServletContextListener{  
    
    private Timer timer = null;  
 
    
          
    public void contextDestroyed(ServletContextEvent scEvent) {  
        // TODO Auto-generated method stub  
        timer.cancel();  
        System.out.println("ֹͣ�������ݿ⣡");  
    }  
  
      
    public void contextInitialized(ServletContextEvent scEvent) {  
        // TODO Auto-generated method stub  
        timer = new Timer(true);  
        /*24*60*60*1000*/  
        timer.schedule(new sms(), 5000, 60*1000);  //5s��ʼ5����ִ��һ��sms();
        System.out.println("��ʼ�������ݿ����ڵ�״̬��");  
    }  
  
} 