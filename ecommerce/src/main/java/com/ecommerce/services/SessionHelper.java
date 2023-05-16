package com.ecommerce.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

@Component
public class SessionHelper {

    public void removeMessage(){

        try{

            HttpSession session = ((HttpServletRequest) RequestContextHolder.getRequestAttributes()).getSession() ;
            if(session != null){
                session.removeAttribute("message");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }



    }
}
