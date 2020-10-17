/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<String> items = null;
        
        switch(action){
            case "register":
                String username = request.getParameter("username");
                items = new ArrayList<>();
                session.setAttribute("username", username);
                session.setAttribute("items", items);
                break;
            case "add":
                String addItem = request.getParameter("item");
                items = (ArrayList<String>) session.getAttribute("items");
                items.add(addItem);
                session.setAttribute("items", items);
                break;            
            case "delete":
                String deleteItem = request.getParameter("item");
                items = (ArrayList<String>) session.getAttribute("items");
                items.remove(deleteItem);
                session.setAttribute("items", items);
                break;
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
    }
}
