package com.umd.pothole.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.umd.pothole.database.ReportDBO;
import com.umd.pothole.value.Report;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * @author Steven Burgart <skburgart@gmail.com>
 */
@WebServlet(name = "GetReports", urlPatterns = {"/GetReports"})
public class GetReports extends HttpServlet {

    private static final Logger log = Logger.getLogger(GetReports.class.getName());
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set json response type
        response.setContentType("application/json;charset=UTF-8");

        // Get report data
        ReportDBO rdbo = new ReportDBO();
        List<Report> reports = rdbo.getAllReports();
        rdbo.close();

        // Log
        log.info("Get Reports -> " + reports.size());

        // Write json
        PrintWriter out = response.getWriter();
        out.print(reportsToJson(reports));
    }

    private String reportsToJson(List<Report> reports) {
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(Report.class, new ReportAdapter()).setPrettyPrinting().create();
        return gson.toJson(reports);
    }

    private static class ReportAdapter implements JsonSerializer<Report> {

        @Override
        public JsonElement serialize(Report r, Type type, JsonSerializationContext jsc) {
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Timestamp) r.getTimestamp());

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("rid", r.getRid());
            jsonObject.addProperty("androidid", r.getDevice().getAndroidid());
            jsonObject.addProperty("timestamp", date);
            jsonObject.addProperty("latitude", r.getLatitude());
            jsonObject.addProperty("longitude", r.getLongitude());
            jsonObject.addProperty("gforce", r.getGforce());
            return jsonObject;
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
