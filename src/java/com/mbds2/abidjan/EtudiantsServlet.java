/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbds2.abidjan;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
            /* TODO output your page here. You may use following sample code.*/ 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EtudiantsServlet</title>");            
            out.println("</head>");
            out.println("<body style='text-align:center'>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>");
            out.println("<FORM Method='GET' Action='formulaire.html'>");
            out.println("<input type=\"submit\" value=\"Voir le formulaire inscription\" />");
            out.println("</FORM>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<br/>");
           
            out.println("<table border='1px' >");
            out.println("<tr style='border: 1px solid #333; background-color:blue;'>");
            out.println("<th>Nom</th>");
            out.println("<th>Prenom</th>");
            out.println("<th>Email</th>");
            out.println("</tr>");
               try{
        BufferedReader BR = new BufferedReader(new FileReader("etudiants.csv"));
                String ligne;
        while((ligne = BR.readLine()) != null){
            String[] donne = ligne.split(",");
            out.println("<tr style='border: 1px solid #333; background-color:yellow;'>");
            out.println("<td>"+donne[0]+"</td>");
            out.println("<td>"+donne[1]+"</td>");
            out.println("<td>"+donne[2]+"</td>");
            out.println("</tr>");
        }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
            out.println("</table>");
            
            
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
       /* PrintWriter out = response.getWriter();        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        saveRecord(nom , prenom ,email,filepath);
        out.println("insertion reussite!!");      
        response.sendRedirect("http://localhost:8080/JavaNetbeansAvance2021/etudiants");*/
       
     String delimiteur=",";
     String separateur="\n";
     String nom= request.getParameter("nom");
     String prenom = request.getParameter("prenom");
     String email = request.getParameter("email");
     FileWriter filewritter= new FileWriter("etudiants.csv",true);
     
     filewritter.append(nom);
     filewritter.append(delimiteur);
     filewritter.append(prenom);
     filewritter.append(delimiteur);
     filewritter.append(email);
     filewritter.append(delimiteur);
     filewritter.append(separateur);
     filewritter.flush();
     filewritter.close();
     PrintWriter out = response.getWriter();
      doGet(request,response); 
        
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
    
     
        String filepath = "etudiants.csv";              
        public static void saveRecord(String nom, String prenom, String email,String filepath)
        {
            try
           {
             FileWriter fw = new FileWriter (filepath , true);
             BufferedWriter bw = new  BufferedWriter(fw);
             PrintWriter pw = new PrintWriter (bw);

             pw.println(nom + prenom +email);
             pw.flush();
             pw.close();
           }catch(IOException E)
          {
             
          }
        }

}
