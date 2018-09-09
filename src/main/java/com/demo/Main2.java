//package com.demo;
//
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.server.ServerConnector;
//import org.eclipse.jetty.servlet.DefaultServlet;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//import org.eclipse.jetty.servlet.ServletHolder;
//
//
//public class Main2
//{
//    public static void main( String[] args ) throws Exception
//    {
//        // The filesystem paths we will map
//        String pwdPath = System.getProperty("user.dir");
//        String assetsPath = pwdPath + "/assets";
//
//        // The Server
//        Server server = new Server();
//
//        // Enable parsing of jndi-related parts of web.xml and jetty-env.xml
////        org.eclipse.jetty.webapp.Configuration.ClassList classlist = org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(server);
////        classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration", "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
////        classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");
//
//        // HTTP connector
//        ServerConnector http = new ServerConnector(server);
//        http.setHost("localhost");
//        http.setPort(8080);
//
//        // Setup the basic application "context" for this application at "/"
//        // This is also known as the handler tree (in jetty speak)
//        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.setResourceBase(pwdPath);
//        context.setContextPath("/");
//        server.setHandler(context);
//
//        // Create a WebApp Servlet at "/api/*"
//        ServletHolder holderApi = new ServletHolder("api", HelloServlet.class);
//        context.addServlet(HelloServlet.class, "/*");
//
//        // Create a WebApp
////        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
////        context.setContextPath("/");
////        context.setResourceBase(".");
////        server.setHandler(context);
//
//        // Set the connector
//        server.addConnector(http);
//
//        // context.addServlet(new ServletHolder(new HelloServlet()),"/*");
//
////        context.addServlet(new ServletHolder(new HelloServlet("Buongiorno Mondo")),"/it/*");
////        context.addServlet(new ServletHolder(new HelloServlet("Bonjour le Monde")),"/fr/*");
//
//        // Set a handler
//        // server.setHandler(new HelloHandler());
//
//        ServletHolder holderHome = new ServletHolder("static-home", DefaultServlet.class);
//        holderHome.setInitParameter("resourceBase", assetsPath);
//        holderHome.setInitParameter("dirAllowed","true");
//        holderHome.setInitParameter("pathInfoOnly","true");
//        context.addServlet(holderHome,"/assets/*");
//
//        // Lastly, the default servlet for root content (always needed, to satisfy servlet spec)
//        // It is important that this is last.
////        ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
////        holderPwd.setInitParameter("dirAllowed","true");
////        context.addServlet(holderPwd,"/");
//
//        // Start the server
//        server.start();
//        // System.out.println("assetsPath: " + assetsPath);
//
//        // The use of server.join() the will make the current thread join and wait until the server is done executing.
//        // See http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#join()
//        server.join();
//    }
//}
