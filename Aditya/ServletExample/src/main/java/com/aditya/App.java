package com.aditya;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;

public class App
{
    public static void main( String[] args ) throws LifecycleException
    {
        System.out.println( "Hello World!" );
        // Tomact is a servlet comtainer
        Tomcat tomcat = new Tomcat();

        // Hardcoding or internal tomcat config...way to map call to servlet
        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        // actual mapping
        context.addServletMappingDecoded("/hello","HelloServlet" );

        // staring the tomcat server
        tomcat.start();
        tomcat.getServer().await();
    }
}
