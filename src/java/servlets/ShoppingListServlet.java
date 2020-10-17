/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 775653
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        System.out.println("doGet Action: " + action);
        if(action != null && action.equals("logout")){
            session.invalidate();
            session = request.getSession();
            request.setAttribute("action", null);
        }
        
        if(session.getAttribute("username") != null){
            request.getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response); 
        } else {
            request.setAttribute("action", "");
            request.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();        
        System.out.println("doPost Action: " + action);
        switch(action){
            case "register":
                String username = request.getParameter("username");
                session.setAttribute("username", username);
                request.getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                break;
        }
    }
}
