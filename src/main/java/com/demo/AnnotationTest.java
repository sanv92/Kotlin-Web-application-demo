package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RunAs;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.io.IOException;

/**
 * AnnotationTest
 *
 * Use servlet 3.0 annotations from within Jetty.
 *
 * Also uses servlet 2.5 resource injection and lifecycle callbacks
 */

// @RunAs("special")
// @WebServlet(urlPatterns = {"/","/test"}, name="AnnotationTest", initParams={@WebInitParam(name="fromAnnotation", value="xyz")})
@RunAs("special")
@WebServlet({"/BaseServlet", ""})
@DeclareRoles({"user","client"})
public class AnnotationTest extends HttpServlet
{
    private DataSource myDS;

    @Resource(mappedName="UserTransaction")
    private UserTransaction myUserTransaction;

    @Resource(mappedName="maxAmount")
    private Double maxAmount;


    @Resource(mappedName="jdbc/mydatasource")
    public void setMyDatasource(DataSource ds)
    {
        myDS=ds;
    }


    @PostConstruct
    private void myPostConstructMethod ()
    {
        System.err.println("PostConstruct called");
    }


    @PreDestroy
    private void myPreDestroyMethod()
    {
        System.err.println("PreDestroy called");
    }

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            response.setContentType("text/html");
            ServletOutputStream out = response.getOutputStream();
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Results</h1>");
            out.println(myDS.toString());
            out.println("<br/>");
            out.println(maxAmount.toString());
            out.println("</body>");
            out.println("</html>");
            out.flush();
        }
        catch (Exception e)
        {
            throw new ServletException(e);
        }
    }
}
