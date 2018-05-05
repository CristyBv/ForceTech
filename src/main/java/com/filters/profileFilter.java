package com.filters;

import com.users.CheckCookies;
import com.users.CookiesClass;
import com.users.UserData;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by CristyBv on 04-Apr-18.
 */
@WebFilter(filterName = "profileFilter")
public class profileFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("profileFilter");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        CheckCookies check=new CheckCookies();
        CookiesClass cook = check.isLogged(request,response);
        UserData obj = new UserData();

        if(cook.getUser()!=null && cook.getPass()!=null) {
            request.setAttribute("avatar", cook.getAvatar_url());
            request.setAttribute("nume",cook.getNume());
            request.setAttribute("prenume",cook.getPrenume());
            request.setAttribute("email",cook.getEmail());
            request.setAttribute("sex",cook.getSex());
            request.setAttribute("varsta",cook.getVarsta());
            request.setAttribute("inaltime",cook.getInaltime());
            request.setAttribute("greutate",cook.getGreutate());
            request.setAttribute("nivelact",cook.getNivelact());
            request.setAttribute("tipact",cook.getTipact());
            try {
                String feedback = obj.getValueOf(cook.getUser(),cook.getPass(),"feedback");
                request.setAttribute("feedback",feedback);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else response.sendRedirect("/index.jsp");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
