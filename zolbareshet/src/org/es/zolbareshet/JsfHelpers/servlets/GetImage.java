package org.es.zolbareshet.JsfHelpers.servlets;

import org.es.zolbareshet.queries.SimpleQueryInvoker;

import javax.faces.bean.ManagedBean;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class GetImage extends HttpServlet{

    public byte[] getCategoryImage(String name)

    {
        return SimpleQueryInvoker.getCategoryImage(name);
    }
    public byte[] getProductImage(String name)

    {
        return SimpleQueryInvoker.getProductImage(name);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] src = req.getParameterValues("source");
        String[] name = req.getParameterValues("imagename");
        ServletOutputStream out = null;

        try {
            out = resp.getOutputStream();
            if (src[0].equals("category")) {
                byte[] b =getCategoryImage(name[0]);
                if (b!=null) {
                    out.write(b);
                }
            }
            else if(src[0].equals("product")){
                byte[] b =getProductImage(name[0]);
                if (b!=null) {
                    out.write(b);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(out!=null) {
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
