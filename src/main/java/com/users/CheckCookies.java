package com.users;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckCookies {
    public CookiesClass isLogged(HttpServletRequest request, HttpServletResponse response){
        CookiesClass cook = new CookiesClass();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                if(c.getName().equals("user"))
                    cook.setUser(c.getValue());
                if(c.getName().equals("pass"))
                    cook.setPass(c.getValue());
                if(c.getName().equals("nowReg"))
                    cook.setNowReg(c.getValue());
                if(c.getName().equals("avatar_url"))
                    cook.setAvatar_url(c.getValue());
                if(c.getName().equals("nume"))
                    cook.setNume(c.getValue());
                if(c.getName().equals("prenume"))
                    cook.setPrenume(c.getValue());
                if(c.getName().equals("email"))
                    cook.setEmail(c.getValue());
                if(c.getName().equals("sex"))
                    cook.setSex(c.getValue());
                if(c.getName().equals("varsta"))
                    cook.setVarsta(c.getValue());
                if(c.getName().equals("inaltime"))
                    cook.setInaltime(c.getValue());
                if(c.getName().equals("greutate"))
                    cook.setGreutate(c.getValue());
                if(c.getName().equals("nivelact"))
                    cook.setNivelact(c.getValue());
                if(c.getName().equals("tipact"))
                    cook.setTipact(c.getValue());
                /*if(c.getName().equals("feedback"))
                    cook.setFeedback(c.getValue());*/
            }
        }
        return cook;
    }
    public boolean allGood(HttpServletRequest request, HttpServletResponse response){
        boolean ok=true;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
            for(Cookie c:cookies)
                if(c.getValue().compareTo("")==0) ok=false;
        return ok;
    }
}
