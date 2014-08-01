package com.umd.pothole.servlet;

import com.umd.pothole.HibernateUtil;
import com.umd.pothole.value.Device;
import com.umd.pothole.value.Report;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.hibernate.Session;

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
            boolean result = true;

            try {
                Date now = new Date();
                Device device = new Device(request.getParameter("androidid"), now);
                Report report = new Report();
                report.setDevice(device);
                report.setLatitude(Double.parseDouble(request.getParameter("latitude")));
                report.setLongitude(Double.parseDouble(request.getParameter("longitude")));
                report.setGforce(Double.parseDouble(request.getParameter("gforce")));
                report.setTimestamp(now);
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.saveOrUpdate(device);
                session.save(report);
                session.getTransaction().commit();;
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
