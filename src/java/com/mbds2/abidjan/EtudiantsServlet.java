/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbds2.abidjan;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class EtudiantsServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EtudiantsServlet</title>");            
            out.println("</head>");
            out.println("<body style='text-align:center'>");
            out.println("<FORM Method='POST' Action='etudiants'>");
            //out.println("<FORM Method='POST' Action='doPost'>");
            out.println("Nom : 		<INPUT type=text size=20 name=nom><BR>");
            out.println("Prénom : 	<INPUT type=text size=20 name=prenom><BR>");
            out.println("Email :        <INPUT type=text size=20 name=email><BR>");
            out.println("<INPUT type=submit value=Envoyer>");
            out.println("</FORM>");
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
       // processRequest(request, response);
        PrintWriter out = response.getWriter();
        
        //out.println(request.getParameter("nom"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        
         saveRecord(nom , prenom ,email,filepath);
        out.println("reussite");
        
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
    
     
        String filepath = "C:\\Users\\HP\\Dropbox\\Mon PC (DESKTOP-MAL4HBH)\\Documents\\GitHub\\JavaNetbeansAvance2021\\src\\etudiants.csv";
       
        
        public static void saveRecord(String nom, String prenom, String email,String filepath)
        {
            try
           {
             FileWriter fw = new FileWriter (filepath , false);
             BufferedWriter bw = new  BufferedWriter(fw);
             PrintWriter pw = new PrintWriter (bw);

             pw.println(nom + ','+ prenom + ','+email);
             pw.flush();
             pw.close();

           

           }
          catch(Exception E)
          {
              PrintWriter out = response.getWriter();
             out.println("reussite");
          }
        }

}
