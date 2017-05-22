/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.gatteender;

import amm.gatteender.Classi.GattoFactory;
import amm.gatteender.Classi.Post;
import amm.gatteender.Classi.PostFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tutor_IUM
 */
public class NuovoPost extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        
        //se la sessione esiste ed esiste anche l'attributo loggedIn impostato a true
        if(session!=null && 
           session.getAttribute("loggedIn")!=null &&
           session.getAttribute("loggedIn").equals(true)){
            /*Due possibilità:
            *   -devo ancora scrivere un messaggio (nessun post in request)
            *   -ho gia scritto il messaggio e devo confermare (esiste un post in request)
            */
            if(request.getParameter("thereIsPost")!=null)
            {
                /*Altre due possibilità
                *   -aspetto conferma da jsp
                *   -devo salvare su DB
                */
                String thereIsPost = request.getParameter("thereIsPost");
                String content = request.getParameter("textPost");
                String type = request.getParameter("postType");
                if(thereIsPost.equals("needConfirm")){
                    request.setAttribute("content", content);
                    request.setAttribute("typePost", type);
                    request.setAttribute("newpost", "true");
                    request.getRequestDispatcher("nuovopost.jsp").forward(request, response);
                    return;
                }
                else{
                    //salvo
                    Post post = new Post();
                    post.setContent(content);
                    if(type.equals("textType"))
                        post.setPostType(Post.Type.TEXT);
                    else
                        post.setPostType(Post.Type.IMAGE);
                    
                    post.setUser(GattoFactory.getInstance()
                            .getGattoById((Integer)session.getAttribute("loggedUserID")));
                    PostFactory.getInstance().addNewPost(post);
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                }
            }
            else{
                request.getRequestDispatcher("nuovopost.jsp").forward(request, response);
                return;
            }
        }
        else{
            request.getRequestDispatcher("Login").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
