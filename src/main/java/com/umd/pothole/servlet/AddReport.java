package com.umd.pothole.servlet;

import com.umd.pothole.database.ReportDBO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * @author Steven Burgart <skburgart@gmail.com>
 */
@WebServlet(name = "AddReport", urlPatterns = {"/AddReport"})
public class AddReport extends HttpServlet {

    private static final Logger log = Logger.getLogger(AddReport.class.getName());
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        log.trace("Entering AddReport");
        try (PrintWriter out = response.getWriter()) {
            boolean result;
            
            try {
                String androidid = request.getParameter("androidid");
                Double latitude = Double.parseDouble(request.getParameter("latitude"));
                Double longitude = Double.parseDouble(request.getParameter("longitude"));
                Double gforce = Double.parseDouble(request.getParameter("gforce"));
                ReportDBO rdbo = new ReportDBO();
                result = rdbo.add(androidid, latitude, longitude, gforce);
                rdbo.close();
            } catch (NullPointerException | NumberFormatException e) {
                log.error(e.toString() + " -> " + e.getMessage());
                result = false;
            }

            out.print(result);
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
