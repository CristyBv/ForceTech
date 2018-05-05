package com.servlets;

import com.users.CheckCookies;
import com.users.CookiesClass;
import com.users.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "profile")
public class profile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Profile");
        String cale= request.getRequestURI();

        CheckCookies check=new CheckCookies();
        CookiesClass cook = check.isLogged(request,response);
        UserData obj = new UserData();
        
        if(cale.compareTo("/securityprofile")==0){  //am dat Save din formularul din stanga
            System.out.println(cale);
            String avatar=request.getParameter("avatar");
            String nume=request.getParameter("firstname");
            String prenume=request.getParameter("lastname");
            String oldpass=request.getParameter("oldpassword");
            String newpass=request.getParameter("newpassword");
            String rnewpass=request.getParameter("rnewpassword");
            String email=request.getParameter("email");
            System.out.println("Profil securitate: ");
            System.out.println(avatar+" "+nume+" "+prenume+" "+oldpass+" "+newpass+" "+rnewpass+" "+email);

            if(oldpass!=""){
                if(newpass == "" || rnewpass == "" || newpass.compareTo(rnewpass)!=0){
                    request.setAttribute("error","1");
                    request.setAttribute("notsamepass","Parolele nu se potrivesc!");
                    request.getRequestDispatcher("/profile.jsp").forward(request,response);
                }
                else{
                    if(oldpass.compareTo(cook.getPass())==0){
                        try {
                            obj.setValueOf(cook.getUser(),cook.getPass(),"user_password",newpass);
                            Cookie[] cooks = request.getCookies();
                            for(Cookie c:cooks) {
                                if(c.getName().equals("pass")){
                                    c.setValue(newpass);
                                    response.addCookie(c);
                                    cook.setPass(newpass);
                                }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        request.setAttribute("error","1");
                        request.setAttribute("notcorrectoldpass","Parola veche nu este corecta!");
                        request.getRequestDispatcher("/profile.jsp").forward(request,response);
                    }
                }
            }
            else if(newpass != "" || rnewpass != ""){
                request.setAttribute("error","1");
                request.setAttribute("notoldpass","Parola veche nu a fost introdusa!");
                request.getRequestDispatcher("/profile.jsp").forward(request,response);
            }

            try {
                if(avatar!="") {
                    obj.setValueOf(cook.getUser(),cook.getPass(),"avatar_url",avatar);
                    Cookie[] cooks = request.getCookies();
                    for(Cookie c:cooks) {
                        if(c.getName().equals("avatar_url")){
                            c.setValue(avatar);
                            response.addCookie(c);
                        }
                    }
                }
                if(nume!="") {
                    obj.setValueOf(cook.getUser(),cook.getPass(),"nume",nume);
                    Cookie[] cooks = request.getCookies();
                    for(Cookie c:cooks) {
                        if(c.getName().equals("nume")){
                            c.setValue(nume);
                            response.addCookie(c);
                        }
                    }
                }
                if(prenume!="") {
                    obj.setValueOf(cook.getUser(),cook.getPass(),"prenume",prenume);
                    Cookie[] cooks = request.getCookies();
                    for(Cookie c:cooks) {
                        if(c.getName().equals("prenume")){
                            c.setValue(prenume);
                            response.addCookie(c);
                        }
                    }
                }
                if(email!="") {
                    obj.setValueOf(cook.getUser(),cook.getPass(),"email",email);
                    Cookie[] cooks = request.getCookies();
                    for(Cookie c:cooks) {
                        if(c.getName().equals("email")){
                            c.setValue(email);
                            response.addCookie(c);
                        }
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //response.sendRedirect("/profile.jsp");
            request.setAttribute("succes","Profilul a fost updatat!");
            request.getRequestDispatcher("/profile.jsp").forward(request,response);
        }
        else {
            System.out.println(cale);
            String sex=request.getParameter("sex");
            String varsta=request.getParameter("varsta");
            String inaltime=request.getParameter("inaltime");
            String greutate=request.getParameter("greutate");
            String nivelact=request.getParameter("nivelact");
            String[] tipact=request.getParameterValues("tipact");
            String feedback=request.getParameter("feedback");
            System.out.println("Profil personal: ");
            System.out.println(sex+" "+varsta+" "+inaltime+" "+greutate+" "+nivelact+" "+feedback);
            if(tipact!=null) for(String s:tipact) System.out.print(s+" ");
            
                try {
                    if(sex!="") {
                        obj.setValueOf(cook.getUser(), cook.getPass(), "sex", sex);
                        Cookie[] cooks = request.getCookies();
                        for (Cookie c : cooks) {
                            if (c.getName().equals("sex")) {
                                c.setValue(sex);
                                response.addCookie(c);
                            }
                        }
                    }
                    if(varsta!="") {
                        obj.setValueOf(cook.getUser(), cook.getPass(), "varsta", varsta);
                        Cookie[] cooks = request.getCookies();
                        for (Cookie c : cooks) {
                            if (c.getName().equals("varsta")) {
                                c.setValue(varsta);
                                response.addCookie(c);
                            }
                        }
                    }

                    if(inaltime!="") {
                        obj.setValueOf(cook.getUser(), cook.getPass(), "inaltime", inaltime);
                        Cookie[] cooks = request.getCookies();
                        for (Cookie c : cooks) {
                            if (c.getName().equals("inaltime")) {
                                c.setValue(inaltime);
                                response.addCookie(c);
                            }
                        }
                    }
                    
                    if(greutate!="") {
                        obj.setValueOf(cook.getUser(), cook.getPass(), "greutate", greutate);
                        Cookie[] cooks = request.getCookies();
                        for (Cookie c : cooks) {
                            if (c.getName().equals("greutate")) {
                                c.setValue(greutate);
                                response.addCookie(c);
                            }
                        }
                    }

                    if(nivelact!="") {
                        obj.setValueOf(cook.getUser(), cook.getPass(), "nivel_act_actual", nivelact);
                        Cookie[] cooks = request.getCookies();
                        for (Cookie c : cooks) {
                            if (c.getName().equals("nivelact")) {
                                c.setValue(nivelact);
                                response.addCookie(c);
                            }
                        }
                    }

                    if(tipact!=null) {
                        String tips="";
                        for(String s:tipact) tips+=s+"/";
                        obj.setValueOf(cook.getUser(), cook.getPass(), "tip_act", tips);
                        Cookie[] cooks = request.getCookies();
                        for (Cookie c : cooks) {
                            if (c.getName().equals("tipact")) {
                                c.setValue(tips);
                                response.addCookie(c);
                            }
                        }
                    }

                    if(feedback!="") {
                        obj.setValueOf(cook.getUser(), cook.getPass(), "feedback", feedback);
                        /*Cookie[] cooks = request.getCookies();
                        for (Cookie c : cooks) {
                            if (c.getName().equals("feedback")) {
                                c.setValue(feedback);
                                response.addCookie(c);
                            }
                        }*/
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            if(check.allGood(request,response)){
                try {
                    obj.setValueOf(cook.getUser(),cook.getPass(),"now_registered","0");
                    Cookie[] cooks = request.getCookies();
                    for (Cookie c : cooks) {
                        if (c.getName().equals("nowReg")) {
                            c.setValue("0");
                            response.addCookie(c);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            request.setAttribute("succes","Profilul a fost updatat!");
            request.getRequestDispatcher("/profile.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
