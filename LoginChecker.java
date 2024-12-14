/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginAuthenticator;


/**
 *
 * @author mitesh
 */
public class LoginChecker extends HttpServlet 
{
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
      response.sendRedirect("Login.html");
   }
     
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
       String email = request.getParameter("email");
       String password = request.getParameter("password");
       
       LoginAuthenticator l1= new LoginAuthenticator();
       boolean login = l1.isLogin(email, password);
       
       
       if(login)
       {
           HttpSession session= request.getSession(true);
           session.setAttribute("email", email);
           response.sendRedirect("Profile.jsp");
       }
       else
       {
           response.sendRedirect("LoginFail.html");
       }
 
   }
}
