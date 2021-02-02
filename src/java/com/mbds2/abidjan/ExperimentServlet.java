/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbds2.abidjan;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class ExperimentServlet extends HttpServlet {

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
        
        //
        final int serverPort = request.getServerPort();
        //
        InetAddress IP = InetAddress.getLocalHost();
        //
        String MonIP = IP.getHostAddress();
        //
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style='text-align:center'>Ma premiere Servlet</h1>");
            out.println("<b><h2 style='text-align:left;'>Informations concernant l'adresse IP et le navigateur utilisé par le client:</h2></b>");
            out.println("<h3 style='text-align:left'>Adresse IP du client: " + MonIP + "</h3>");
            out.println("<h3 style='text-align:left'>Navigateur du client: " + request.getHeader("client") + " </h3>");
            out.println("<b><h2 style='text-align:left'>Informations concernant la requete du client:</h2></b>");
            out.println("<h3 style='text-align:left'>Methode : " + request.getMethod()  + "</h3>");
            out.println("<h3 style='text-align:left'>Protocole : " + request.getProtocol() + " </h3>");
            out.println("<h3 style='text-align:left'>Uri demande : " + request.getProtocol() + "</h3>");
            out.println("<h2 style='text-align:left'>Informations concernant la requete de la requete:</h2>");
            out.println("<h3 style='text-align:left'>host : " + String.format("%s:%s", request.getServerName(), serverPort) + "</h3>");
            out.println("<h3 style='text-align:left'>user-agent : " + request.getHeader("user-agent") + " </h3>");
            out.println("<h3 style='text-align:left'>accept : " + request.getHeader("accept") + "</h3>");
            out.println("<h3 style='text-align:left'>accept-language : " + request.getHeader("accept-language") + "</h3>");
            out.println("<h3 style='text-align:left'>accept-encoding : " + request.getHeader("Accept-Encoding")  + " </h3>");
            out.println("<h3 style='text-align:left'>accept-charset : " + request.getHeader("Accept-Charset") + "</h3>");
            out.println("<h3 style='text-align:left'>keep-alive : " + request.getHeader("Keep-Alive") + "</h3>");
            out.println("<h3 style='text-align:left'>connection : " + request.getHeader("connection") + " </h3>");
            //out.println("<h1>Servlet ExperimentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
